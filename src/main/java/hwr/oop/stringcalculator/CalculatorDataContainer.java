package hwr.oop.stringcalculator;

import java.util.HashMap;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleFunction;

public class CalculatorDataContainer {

    // package-private to make them accessible for the EquationSolver
    // that way there is no need to make a getOperator and hasOperator for each hashMap
    // setOperator is still required to make it configurable from outside the package
    final HashMap<Character, DoubleBinaryOperator> expressionOperators;
    final HashMap<Character, DoubleBinaryOperator> termOperators;
    final HashMap<Character, DoubleBinaryOperator> factorOperators;
    final HashMap<Character, DoubleFunction<Double>> prefixOperators;
    final HashMap<Character, DoubleFunction<Double>> suffixOperators;
    final HashMap<String, Double> variables;
    final HashMap<String, DoubleFunction<Double>> functions;

    public CalculatorDataContainer() {
        this.expressionOperators = new HashMap<>();
        this.termOperators = new HashMap<>();
        this.factorOperators = new HashMap<>();
        this.prefixOperators = new HashMap<>();
        this.suffixOperators = new HashMap<>();
        this.variables = new HashMap<>();
        this.functions = new HashMap<>();
    }

    public static CalculatorDataContainer createNewWithDefault() {
        CalculatorDataContainer container = new CalculatorDataContainer();
        DefaultCalculatorData.fillDataContainer(container);
        return container;
    }

    /*
     * configuration
     */

    public void setExpressionOperator(Character operator, DoubleBinaryOperator evaluator) {
        this.expressionOperators.put(operator, evaluator);
    }

    public void removeExpressionOperator(Character operator) {
        this.expressionOperators.remove(operator);
    }

    public void setTermOperator(Character operator, DoubleBinaryOperator evaluator) {
        this.termOperators.put(operator, evaluator);
    }

    public void removeTermOperator(Character operator) {
        this.termOperators.remove(operator);
    }

    public void setFactorOperator(Character operator, DoubleBinaryOperator evaluator) {
        this.factorOperators.put(operator, evaluator);
    }

    public void removeFactorOperator(Character operator) {
        this.factorOperators.remove(operator);
    }

    public void setPrefixOperators(Character operator, DoubleFunction<Double> evaluator) {
        this.prefixOperators.put(operator, evaluator);
    }

    public void removePrefixOperator(Character operator) {
        this.prefixOperators.remove(operator);
    }

    public void setSuffixOperators(Character operator, DoubleFunction<Double> evaluator) {
        this.suffixOperators.put(operator, evaluator);
    }

    public void removeSuffixOperator(Character operator) {
        this.suffixOperators.remove(operator);
    }

    public void setVariable(String name, double value) {
        if (!name.matches("^[a-zA-Z]\\w*$")) {
            throw new RuntimeException("invalid variable name");
        }
        this.variables.put(name, value);
    }

    public void removeVariable(String name) {
        this.variables.remove(name);
    }

    public void setFunction(String name, DoubleFunction<Double> function) {
        if (!name.matches("^[a-zA-Z]\\w*$")) {
            throw new RuntimeException("invalid variable name");
        }
        this.functions.put(name, function);
    }

    public void removeFunction(String name) {
        this.functions.remove(name);
    }
}
