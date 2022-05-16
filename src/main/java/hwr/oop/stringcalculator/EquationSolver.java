package hwr.oop.stringcalculator;

class EquationSolver {
    private final String equation;
    private final CalculatorDataContainer dataContainer;

    private int position = -1;
    private char character;

    public EquationSolver(final String equation, final CalculatorDataContainer dataContainer) {
        if (equation.length() == 0) {
            throw new RuntimeException("equation is empty");
        }
        this.equation = equation;
        this.dataContainer = dataContainer;
    }

    public double resolve() {
        try {
            this.loadNextCharacter();
            double x = this.parseExpression();
            if (this.position < equation.length()) {
                throw new RuntimeException("Unexpected Character at the end of the equation: '" + this.character + "'");
            }
            return x;
        } finally {
            this.position = -1;
            this.character = (char) (-1);
        }
    }

    private void loadNextCharacter() {
        this.position++;
        if (this.position < this.equation.length()) {
            this.character = this.equation.charAt(this.position);
        } else {
            this.character = (char) (-1);
        }
    }

    private boolean nextCharacterIs(int toCheck) {
        if (this.character == toCheck) {
            this.loadNextCharacter();
            return true;
        }
        return false;
    }

    // expression = term | expression `+` term | expression `-` term
    private double parseExpression() {
        double value = parseTerm();
        while (true) {
            char operator = this.character;
            if (this.dataContainer.expressionOperators.containsKey(operator)) {
                loadNextCharacter();
                double other = parseTerm();
                value = this.dataContainer.expressionOperators.get(operator).applyAsDouble(value, other);
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
            if (this.dataContainer.termOperators.containsKey(operator)) {
                loadNextCharacter();
                double other = parseFactor();
                value = this.dataContainer.termOperators.get(operator).applyAsDouble(value, other);
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
        if (this.dataContainer.prefixOperators.containsKey(operator)) {
            loadNextCharacter();
            value = this.parseFactor();
            return this.dataContainer.prefixOperators.get(operator).apply(value);
        }

        int startPos = this.position;  // remember start-position to cut out a substring
        if (this.nextCharacterIs('(')) {
            value = this.parseExpression();
            if (!this.nextCharacterIs(')')) {
                throw new RuntimeException("Missing ')'");
            }
        } else if (this.characterIsNumber(false)) { // numbers
            while (this.characterIsNumber(true)) {
                this.loadNextCharacter();
            }
            value = Double.parseDouble(this.equation.substring(startPos, this.position));
        } else if (this.characterIsLetter()) { // functions
            while (this.characterIsLetter() || this.characterIsNumber(false)) {
                this.loadNextCharacter();
            }
            String varOrFunctionName = this.equation.substring(startPos, this.position);
            if (this.nextCharacterIs('(')) {
                value = parseExpression();
                if (!this.nextCharacterIs(')')) {
                    throw new RuntimeException("Missing ')' after argument of " + varOrFunctionName);
                }
                if (!this.dataContainer.functions.containsKey(varOrFunctionName)) {
                    throw new RuntimeException("Unknown function: '" + varOrFunctionName + "'");
                }
                value = this.dataContainer.functions.get(varOrFunctionName).apply(value);
            } else {
                if (!this.dataContainer.variables.containsKey(varOrFunctionName)) {
                    throw new RuntimeException("Unknown variable: '" + varOrFunctionName + "'");
                }
                value = this.dataContainer.variables.get(varOrFunctionName);
            }
        } else {
            throw new RuntimeException("Unexpected Character: '" + this.character + "'");
        }

        // update, because key has changed
        operator = this.character;
        if (this.dataContainer.suffixOperators.containsKey(operator)) {
            loadNextCharacter();
            value = this.dataContainer.suffixOperators.get(operator).apply(value);
        }
        operator = this.character;
        if (this.dataContainer.factorOperators.containsKey(operator)) {
            loadNextCharacter();
            double other = this.parseFactor();
            value = this.dataContainer.factorOperators.get(operator).applyAsDouble(value, other);
        }

        return value;
    }

    private boolean characterIsNumber(boolean includeDot) {
        return (this.character >= '0' && this.character <= '9') || (includeDot && this.character == '.');
    }

    private boolean characterIsLetter() {
        return (this.character >= 'a' && this.character <= 'z') || (this.character >= 'A' && this.character <= 'Z');
    }

}
