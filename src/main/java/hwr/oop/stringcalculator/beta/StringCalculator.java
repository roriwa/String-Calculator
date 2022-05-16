package hwr.oop.stringcalculator.beta;

import java.util.HashMap;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleFunction;


public class StringCalculator {

    /*
     * attributes for operations
     */

    private final HashMap<Character, DoubleBinaryOperator> expressionOperators;
    private final HashMap<Character, DoubleBinaryOperator> termOperators;
    private final HashMap<Character, DoubleBinaryOperator> factorOperators;
    private final HashMap<Character, DoubleFunction<Double>> prefixOperators;
    private final HashMap<Character, DoubleFunction<Double>> suffixOperators;
    private final HashMap<String, Double> variables;
    private final HashMap<String, DoubleFunction<Double>> functions;

    /*
     * attributes for solving the equation
     */

    // after solving these attributes get reset
    private int position = -1;
    private char character;
    private String equation;

    /*
     * constructor
     */

    public StringCalculator() {
        this(true);
    }

    public StringCalculator(boolean setDefaultLogic) {
        this.expressionOperators = new HashMap<>();
        this.termOperators = new HashMap<>();
        this.factorOperators = new HashMap<>();
        this.prefixOperators = new HashMap<>();
        this.suffixOperators = new HashMap<>();
        this.variables = new HashMap<>();
        this.functions = new HashMap<>();

        if (setDefaultLogic) {
            this.initialiseDefaultCalculator();
        }
    }

    private void initialiseDefaultCalculator() {
        this.initialiseBasicOperators();  // 0x0
        this.initialisePrefixOperators();  // x0
        this.initialiseSuffixOperators();  // 0x
        this.initialiseConstants();  // x
        this.initialiseFunctions();  // x(0)
    }

    /*
     * configuration
     */

    public void setExpressionOperator(Character operator, DoubleBinaryOperator evaluator) {
        this.expressionOperators.put(operator, evaluator);
    }

    public void setTermOperator(Character operator, DoubleBinaryOperator evaluator) {
        this.termOperators.put(operator, evaluator);
    }

    public void setFactorOperator(Character operator, DoubleBinaryOperator evaluator) {
        this.factorOperators.put(operator, evaluator);
    }

    public void setPrefixOperators(Character operator, DoubleFunction<Double> evaluator) {
        this.prefixOperators.put(operator, evaluator);
    }

    public void setSuffixOperators(Character operator, DoubleFunction<Double> evaluator) {
        this.suffixOperators.put(operator, evaluator);
    }

    public void setVariable(String name, double value) {
        if (!name.matches("^[a-zA-Z]\\w*$")) {
            throw new RuntimeException("invalid variable name");
        }
        this.variables.put(name, value);
    }

    public void setFunction(String name, DoubleFunction<Double> function) {
        if (!name.matches("^[a-zA-Z]\\w*$")) {
            throw new RuntimeException("invalid variable name");
        }
        this.functions.put(name, function);
    }

    /*
     * evaluation
     */

    public double solve(String equation) {
        if (equation.length() == 0) {
            throw new RuntimeException("equation is empty");
        }
        this.equation = equation;
        try {
            this.nextCharacter();
            double x = this.parseExpression();
            if (this.position < equation.length()) {
                throw new RuntimeException("Unexpected Character at the end of the equation: '" + this.character + "'");
            }
            return x;
        } finally {
            this.equation = null;
            this.position = -1;
            this.character = (char) (-1);
        }
    }

    private void nextCharacter() {
        this.position++;
        if (this.position < this.equation.length()) {
            this.character = this.equation.charAt(this.position);
        } else {
            this.character = (char) (-1);
        }
    }

    private boolean nextCharacterIs(int toCheck) {
        if (this.character == toCheck) {
            this.nextCharacter();
            return true;
        }
        return false;
    }

    // expression = term | expression `+` term | expression `-` term
    private double parseExpression() {
        double value = parseTerm();
        while (true) {
            char operator = this.character;
            if (this.expressionOperators.containsKey(operator)) {
                nextCharacter();
                double other = parseTerm();
                value = this.expressionOperators.get(operator).applyAsDouble(value, other);
                continue;
            }
            break;
        }
        return value;
    }

    // term = factor | term `*` factor | term `/` factor
    private double parseTerm() {
        double value = parseFactor();
        while (true) {
            char operator = this.character;
            if (this.termOperators.containsKey(operator)) {
                nextCharacter();
                double other = parseFactor();
                value = this.termOperators.get(operator).applyAsDouble(value, other);
                continue;
            }
            return value;
        }
    }

    // factor = `+` factor | `-` factor | `(` expression `)` | number
    //        | functionName `(` expression `)` | factor `^` factor
    private double parseFactor() {
        double value;

        char operator = this.character;
        if (this.prefixOperators.containsKey(operator)) {
            nextCharacter();
            value = this.parseFactor();
            return this.prefixOperators.get(operator).apply(value);
        }

        int startPos = this.position;  // remember start-position to cut out a substring
        if (this.nextCharacterIs('(')) {
            value = this.parseExpression();
            if (!this.nextCharacterIs(')')) {
                throw new RuntimeException("Missing ')'");
            }
        } else if (this.characterIsNumber(false)) { // numbers
            while (this.characterIsNumber(true)) {
                this.nextCharacter();
            }
            value = Double.parseDouble(this.equation.substring(startPos, this.position));
        } else if (this.characterIsLetter()) { // functions
            while (this.characterIsLetter() || this.characterIsNumber(false)) {
                this.nextCharacter();
            }
            String varOrFunctionName = this.equation.substring(startPos, this.position);
            if (this.nextCharacterIs('(')) {
                value = parseExpression();
                if (!this.nextCharacterIs(')')) {
                    throw new RuntimeException("Missing ')' after argument of " + varOrFunctionName);
                }
                if (!this.functions.containsKey(varOrFunctionName)) {
                    throw new RuntimeException("Unknown function: '" + varOrFunctionName + "'");
                }
                value = this.functions.get(varOrFunctionName).apply(value);
            } else {
                if (!this.variables.containsKey(varOrFunctionName)) {
                    throw new RuntimeException("Unknown variable: '" + varOrFunctionName + "'");
                }
                value = this.variables.get(varOrFunctionName);
            }
        } else {
            throw new RuntimeException("Unexpected Character: '" + this.character + "'");
        }

        // update, because key has changed
        operator = this.character;
        if (this.suffixOperators.containsKey(operator)) {
            nextCharacter();
            value = this.suffixOperators.get(operator).apply(value);
        }
        operator = this.character;
        if (this.factorOperators.containsKey(operator)) {
            nextCharacter();
            double other = this.parseFactor();
            value = this.factorOperators.get(operator).applyAsDouble(value, other);
        }

        return value;
    }

    private boolean characterIsNumber(boolean includeDot) {
        return (this.character >= '0' && this.character <= '9') || (includeDot && this.character == '.');
    }

    private boolean characterIsLetter() {
        return (this.character >= 'a' && this.character <= 'z') || (this.character >= 'A' && this.character <= 'Z');
    }

    /*
     * initialisation default operations, functions, etc
     */

    private void initialiseBasicOperators() {
        this.setExpressionOperator('+', Double::sum);
        this.setExpressionOperator('-', (a, b) -> a - b);
        this.setTermOperator('*', (a, b) -> a * b);
        this.setTermOperator('/', (a, b) -> a / b);
//        this.setTermOperator('%', (a, b) -> a % b);  // not possible with the current %-suffix (reason: priority)
        this.setTermOperator('\\', (a, b) -> a % b);  // but this version for modulo is possible
        this.setFactorOperator('^', Math::pow);
    }

    private void initialisePrefixOperators() {
        this.setPrefixOperators('+', (a) -> +a);
        this.setPrefixOperators('-', (a) -> -a);
        this.setPrefixOperators('~', (a) -> (double) Math.round(a));
    }

    private void initialiseSuffixOperators() {
        this.setSuffixOperators('!', (a) -> {
            double result = 1;
            for (int i = 1; i <= a; i++) {
                result *= i;
            }
            return result;
        });
        this.setSuffixOperators('°', Math::toRadians);  // should be pretty helpful
        this.setSuffixOperators('%', (x) -> x / 100);  // should be pretty helpful
        this.setSuffixOperators('²', (x) -> Math.pow(x, 2));  // should be pretty helpful
        this.setSuffixOperators('³', (x) -> Math.pow(x, 3));  // should be pretty helpful
    }

    private void initialiseConstants() {
        this.setVariable("pi", Math.PI);
        this.setVariable("e", Math.E);
    }

    private void initialiseFunctions() {
        this.setFunction("sin", Math::sin);
        this.setFunction("asin", Math::asin);
        this.setFunction("cos", Math::cos);
        this.setFunction("acos", Math::acos);
        this.setFunction("tan", Math::tan);
        this.setFunction("atan", Math::atan);
        this.setFunction("rad", Math::toRadians);
        this.setFunction("deg", Math::toDegrees);
        this.setFunction("abs", Math::abs);
        this.setFunction("sqrt", Math::sqrt);
        this.setFunction("log", Math::log);
        this.setFunction("log10", Math::log10);
    }
}
