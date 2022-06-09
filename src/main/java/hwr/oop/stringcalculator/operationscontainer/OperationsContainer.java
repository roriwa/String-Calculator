package hwr.oop.stringcalculator.operationscontainer;

import java.util.HashMap;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleFunction;

public class OperationsContainer {

    // package-private to make them accessible for the EquationSolver
    // that way there is no need to make a getOperator and hasOperator for each hashMap
    // setOperator and removeOperator is still required to make it configurable from outside the package
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
        OperationsContainer container = new OperationsContainer();
        DefaultOperationManager.setDefaultData(container);
        return container;
    }

    /*
     * configuration
     */

    // expressionOperator

    public void setExpressionOperator(Character operator, DoubleBinaryOperator evaluator) {
        this.expressionOperators.put(operator, evaluator);
    }

    public DoubleBinaryOperator getExpressionOperator(Character operator){
        return this.expressionOperators.get(operator);
    }

    public boolean hasExpressionOperator(Character operator){
        return this.expressionOperators.containsKey(operator);
    }

    public void removeExpressionOperator(Character operator) {
        this.expressionOperators.remove(operator);
    }

    // termOperator

    public void setTermOperator(Character operator, DoubleBinaryOperator evaluator) {
        this.termOperators.put(operator, evaluator);
    }

    public DoubleBinaryOperator getTermOperator(Character operator){
        return this.termOperators.get(operator);
    }

    public boolean hasTermOperator(Character operator){
        return this.termOperators.containsKey(operator);
    }

    public void removeTermOperator(Character operator) {
        this.termOperators.remove(operator);
    }

    // factorOperator

    public void setFactorOperator(Character operator, DoubleBinaryOperator evaluator) {
        this.factorOperators.put(operator, evaluator);
    }

    public DoubleBinaryOperator getFactorOperator(Character operator){
        return this.factorOperators.get(operator);
    }

    public boolean hasFactorOperator(Character operator){
        return this.factorOperators.containsKey(operator);
    }

    public void removeFactorOperator(Character operator) {
        this.factorOperators.remove(operator);
    }

    // prefixOperator

    public void setPrefixOperators(Character operator, DoubleFunction<Double> evaluator) {
        this.prefixOperators.put(operator, evaluator);
    }

    public DoubleFunction<Double> getPrefixOperator(Character operator){
        return this.prefixOperators.get(operator);
    }

    public boolean hasPrefixOperator(Character operator){
        return this.prefixOperators.containsKey(operator);
    }

    public void removePrefixOperator(Character operator) {
        this.prefixOperators.remove(operator);
    }

    // suffixOperator

    public void setSuffixOperators(Character operator, DoubleFunction<Double> evaluator) {
        this.suffixOperators.put(operator, evaluator);
    }

    public DoubleFunction<Double> getSuffixOperator(Character operator){
        return this.suffixOperators.get(operator);
    }

    public boolean hasSuffixOperator(Character operator){
        return this.suffixOperators.containsKey(operator);
    }

    public void removeSuffixOperator(Character operator) {
        this.suffixOperators.remove(operator);
    }

    // variables

    // 'double' instead of 'Double' to allow passing of integer or float
    public void setVariable(String name, double value) throws InvalidVariableNameError {
        this.validateVariableName(name);
        this.variables.put(name, value);
    }

    public Double getVariable(String name){
        return this.variables.get(name);
    }

    public boolean hasVariable(String name){
        return this.variables.containsKey(name);
    }

    public void removeVariable(String name) {
        this.variables.remove(name);
    }

    private void validateVariableName(String name) throws InvalidVariableNameError {
        if (!name.matches("^[a-zA-Z]\\w*$")) {
            throw new InvalidVariableNameError("invalid variable name");
        }
    }

    // functions

    public void setFunction(String name, DoubleFunction<Double> function) throws InvalidFunctionNameError {
        this.validateFunctionName(name);
        this.functions.put(name, function);
    }

    public DoubleFunction<Double> getFunction(String name){
        return this.functions.get(name);
    }

    public boolean hasFunction(String name){
        return this.functions.containsKey(name);
    }


    public void removeFunction(String name) {
        this.functions.remove(name);
    }

    private void validateFunctionName(String name) throws InvalidFunctionNameError {
        if (!name.matches("^[a-zA-Z]\\w*$")) {
            throw new InvalidFunctionNameError("invalid function name");
        }
    }
}
