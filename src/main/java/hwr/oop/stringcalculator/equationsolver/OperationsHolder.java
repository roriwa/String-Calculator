package hwr.oop.stringcalculator.equationsolver;

import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleFunction;

public interface OperationsHolder {
    DoubleBinaryOperator getExpressionOperator(Character operator);

    boolean hasExpressionOperator(Character operator);

    DoubleBinaryOperator getTermOperator(Character operator);

    boolean hasTermOperator(Character operator);

    DoubleBinaryOperator getFactorOperator(Character operator);

    boolean hasFactorOperator(Character operator);

    DoubleFunction<Double> getPrefixOperator(Character operator);

    boolean hasPrefixOperator(Character operator);

    DoubleFunction<Double> getSuffixOperator(Character operator);

    boolean hasSuffixOperator(Character operator);

    Double getVariable(String name);

    boolean hasVariable(String name);

    DoubleFunction<Double> getFunction(String name);

    boolean hasFunction(String name);
}
