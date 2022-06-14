package hwr.oop.stringcalculator.operationscontainer;

import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleFunction;

public interface OperationsSettable {
    void setExpressionOperator(Character operator, DoubleBinaryOperator evaluator);

    void setTermOperator(Character operator, DoubleBinaryOperator evaluator);

    void setFactorOperator(Character operator, DoubleBinaryOperator evaluator);

    void setPrefixOperators(Character operator, DoubleFunction<Double> evaluator);

    void setSuffixOperators(Character operator, DoubleFunction<Double> evaluator);

    // 'double' instead of 'Double' to allow passing of integer or float
    void setVariable(String name, double value) throws InvalidVariableNameException;

    void setFunction(String name, DoubleFunction<Double> function) throws InvalidFunctionNameException;
}
