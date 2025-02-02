package hwr.oop.stringcalculator.operationscontainer;

import hwr.oop.stringcalculator.equationsolver.OperationsHolder;
import hwr.oop.stringcalculator.operationscontainer.operationsbuilder.OperationsBuilder;

import java.util.HashMap;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleFunction;

public class OperationsContainer implements OperationsHolder, OperationsSettable {

    private final HashMap<Character, DoubleBinaryOperator> expressionOperators;
    private final HashMap<Character, DoubleBinaryOperator> termOperators;
    private final HashMap<Character, DoubleBinaryOperator> factorOperators;
    private final HashMap<Character, DoubleFunction<Double>> prefixOperators;
    private final HashMap<Character, DoubleFunction<Double>> suffixOperators;
    private final HashMap<String, Double> variables;
    private final HashMap<String, DoubleFunction<Double>> functions;

    public OperationsContainer() {
        this.expressionOperators = new HashMap<>();
        this.termOperators = new HashMap<>();
        this.factorOperators = new HashMap<>();
        this.prefixOperators = new HashMap<>();
        this.suffixOperators = new HashMap<>();
        this.variables = new HashMap<>();
        this.functions = new HashMap<>();
    }

    public static OperationsContainer createNewWithDefault() {
        OperationsBuilder builder = new OperationsBuilder();
        builder.setAll(true);
        return builder.build();
    }

    /*
     * configuration
     */

    // expressionOperator

    @Override
    public void setExpressionOperator(Character operator, DoubleBinaryOperator evaluator) {
        this.expressionOperators.put(operator, evaluator);
    }

    @Override
    public DoubleBinaryOperator getExpressionOperator(Character operator) {
        return this.expressionOperators.get(operator);
    }

    @Override
    public boolean hasExpressionOperator(Character operator) {
        return this.expressionOperators.containsKey(operator);
    }

    public void removeExpressionOperator(Character operator) {
        this.expressionOperators.remove(operator);
    }

    // termOperator

    @Override
    public void setTermOperator(Character operator, DoubleBinaryOperator evaluator) {
        this.termOperators.put(operator, evaluator);
    }

    @Override
    public DoubleBinaryOperator getTermOperator(Character operator) {
        return this.termOperators.get(operator);
    }

    @Override
    public boolean hasTermOperator(Character operator) {
        return this.termOperators.containsKey(operator);
    }

    public void removeTermOperator(Character operator) {
        this.termOperators.remove(operator);
    }

    // factorOperator

    @Override
    public void setFactorOperator(Character operator, DoubleBinaryOperator evaluator) {
        this.factorOperators.put(operator, evaluator);
    }

    @Override
    public DoubleBinaryOperator getFactorOperator(Character operator) {
        return this.factorOperators.get(operator);
    }

    @Override
    public boolean hasFactorOperator(Character operator) {
        return this.factorOperators.containsKey(operator);
    }

    public void removeFactorOperator(Character operator) {
        this.factorOperators.remove(operator);
    }

    // prefixOperator

    @Override
    public void setPrefixOperators(Character operator, DoubleFunction<Double> evaluator) {
        this.prefixOperators.put(operator, evaluator);
    }

    @Override
    public DoubleFunction<Double> getPrefixOperator(Character operator) {
        return this.prefixOperators.get(operator);
    }

    @Override
    public boolean hasPrefixOperator(Character operator) {
        return this.prefixOperators.containsKey(operator);
    }

    public void removePrefixOperator(Character operator) {
        this.prefixOperators.remove(operator);
    }

    // suffixOperator

    @Override
    public void setSuffixOperators(Character operator, DoubleFunction<Double> evaluator) {
        this.suffixOperators.put(operator, evaluator);
    }

    @Override
    public DoubleFunction<Double> getSuffixOperator(Character operator) {
        return this.suffixOperators.get(operator);
    }

    @Override
    public boolean hasSuffixOperator(Character operator) {
        return this.suffixOperators.containsKey(operator);
    }

    public void removeSuffixOperator(Character operator) {
        this.suffixOperators.remove(operator);
    }

    // variables

    // 'double' instead of 'Double' to allow passing of integer or float
    @Override
    public void setVariable(String name, double value) throws InvalidVariableNameException {
        this.validateVariableName(name);
        this.variables.put(name, value);
    }

    @Override
    public Double getVariable(String name) {
        return this.variables.get(name);
    }

    @Override
    public boolean hasVariable(String name) {
        return this.variables.containsKey(name);
    }

    public void removeVariable(String name) {
        this.variables.remove(name);
    }

    private void validateVariableName(String name) throws InvalidVariableNameException {
        if (!name.matches("^[a-zA-Z]\\w*$")) {
            throw new InvalidVariableNameException("invalid variable name");
        }
    }

    // functions

    @Override
    public void setFunction(String name, DoubleFunction<Double> function) throws InvalidFunctionNameException {
        this.validateFunctionName(name);
        this.functions.put(name, function);
    }

    @Override
    public DoubleFunction<Double> getFunction(String name) {
        return this.functions.get(name);
    }

    @Override
    public boolean hasFunction(String name) {
        return this.functions.containsKey(name);
    }


    public void removeFunction(String name) {
        this.functions.remove(name);
    }

    private void validateFunctionName(String name) throws InvalidFunctionNameException {
        if (!name.matches("^[a-zA-Z]\\w*$")) {
            throw new InvalidFunctionNameException("invalid function name");
        }
    }
}
