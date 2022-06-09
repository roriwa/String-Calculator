package hwr.oop.stringcalculator.operationscontainer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleFunction;

public class OperationsContainerTests {
    OperationsContainer container;

    @BeforeEach
    void setup() {
        container = OperationsContainer.createNewWithDefault();
    }

    // expressionOperator

    @Test
    void testHasAndRemoveExpressionOperator() {
        Assertions.assertThat(container.hasExpressionOperator('+')).isTrue();
        container.removeExpressionOperator('+');
        Assertions.assertThat(container.hasExpressionOperator('+')).isFalse();
    }

    @Test
    void testSetGetExpressionOperator(){
        Character operator = '=';
        DoubleBinaryOperator evaluator = (a, b) -> (a == b) ? 1 : 0;

        Assertions.assertThat(container.hasExpressionOperator(operator)).isFalse();
        container.setExpressionOperator(operator, evaluator);
        Assertions.assertThat(container.hasExpressionOperator(operator)).isTrue();
        DoubleBinaryOperator returned = container.getExpressionOperator(operator);
        Assertions.assertThat(returned).isEqualTo(evaluator);
    }

    // termOperator

    @Test
    void testHasAndRemoveTermOperator() {
        Assertions.assertThat(container.hasTermOperator('*')).isTrue();
        container.removeTermOperator('*');
        Assertions.assertThat(container.hasTermOperator('*')).isFalse();
    }

    @Test
    void testSetGetTermOperator(){
        Character operator = '=';
        DoubleBinaryOperator evaluator = (a, b) -> (a == b) ? 1 : 0;

        Assertions.assertThat(container.hasTermOperator(operator)).isFalse();
        container.setTermOperator(operator, evaluator);
        Assertions.assertThat(container.hasTermOperator(operator)).isTrue();
        DoubleBinaryOperator returned = container.getTermOperator(operator);
        Assertions.assertThat(returned).isEqualTo(evaluator);
    }

    // factorOperator

    @Test
    void testHasAndRemoveFactorOperator() {
        Assertions.assertThat(container.hasFactorOperator('^')).isTrue();
        container.removeFactorOperator('^');
        Assertions.assertThat(container.hasFactorOperator('^')).isFalse();
    }

    @Test
    void testSetGetFactorOperator(){
        Character operator = '=';
        DoubleBinaryOperator evaluator = (a, b) -> (a == b) ? 1 : 0;

        Assertions.assertThat(container.hasExpressionOperator(operator)).isFalse();
        container.setExpressionOperator(operator, evaluator);
        Assertions.assertThat(container.hasExpressionOperator(operator)).isTrue();
        DoubleBinaryOperator returned = container.getExpressionOperator(operator);
        Assertions.assertThat(returned).isEqualTo(evaluator);
    }

    // prefixOperator

    @Test
    void testHasAndRemovePrefixOperator() {
        Assertions.assertThat(container.hasPrefixOperator('-')).isTrue();
        container.removePrefixOperator('-');
        Assertions.assertThat(container.hasPrefixOperator('-')).isFalse();
    }

    @Test
    void testSetGetPrefixOperator(){
        Character operator = ':';
        DoubleFunction<Double> evaluator = (a) -> 2*a;

        Assertions.assertThat(container.hasPrefixOperator(operator)).isFalse();
        container.setPrefixOperators(operator, evaluator);
        Assertions.assertThat(container.hasPrefixOperator(operator)).isTrue();
        DoubleFunction<Double> returned = container.getPrefixOperator(operator);
        Assertions.assertThat(returned).isEqualTo(evaluator);
    }

    // suffixOperator

    @Test
    void testHasAndRemoveSuffixOperator() {
        Assertions.assertThat(container.hasSuffixOperator('!')).isTrue();
        container.removeSuffixOperator('!');
        Assertions.assertThat(container.hasSuffixOperator('!')).isFalse();
    }

    @Test
    void testSetGetSuffixOperator(){
        Character operator = '"';
        DoubleFunction<Double> evaluator = (a) -> 2*a;

        Assertions.assertThat(container.hasPrefixOperator(operator)).isFalse();
        container.setPrefixOperators(operator, evaluator);
        Assertions.assertThat(container.hasPrefixOperator(operator)).isTrue();
        DoubleFunction<Double> returned = container.getPrefixOperator(operator);
        Assertions.assertThat(returned).isEqualTo(evaluator);
    }

    // variables

    @Test
    void testHasAndRemoveVariable() {
        Assertions.assertThat(container.hasVariable("e")).isTrue();
        container.removeVariable("e");
        Assertions.assertThat(container.hasVariable("e")).isFalse();
    }

    @Test
    void testSetGetVariable(){
        String name = "var";
        Double value = 456.0;

        Assertions.assertThat(container.hasVariable(name)).isFalse();
        container.setVariable(name, value);
        Assertions.assertThat(container.hasVariable(name)).isTrue();
        Double returned = container.getVariable(name);
        Assertions.assertThat(returned).isEqualTo(value);
    }

    @Test
    void testInvalidVariableName(){
        try{
            container.setVariable("", 69);
            container.setVariable("56", 420);
            container.setVariable("56ad", 69420);
        } catch (InvalidVariableNameError e){
            return;
        }
        Assertions.fail("empty or invalid variable name was accepted");
    }

    // functions

    @Test
    void testHasAndRemoveFunction() {
        Assertions.assertThat(container.hasFunction("sin")).isTrue();
        container.removeFunction("sin");
        Assertions.assertThat(container.hasFunction("sin")).isFalse();
    }

    @Test
    void testSetGetFunction(){
        String name = "func";
        DoubleFunction<Double> functions = (a) -> 2*a;

        Assertions.assertThat(container.hasFunction(name)).isFalse();
        container.setFunction(name, functions);
        Assertions.assertThat(container.hasFunction(name)).isTrue();
        DoubleFunction<Double> returned = container.getFunction(name);
        Assertions.assertThat(returned).isEqualTo(functions);
    }

    @Test
    void testInvalidFunctionName(){
        try{
            container.setFunction("", (value) -> value);
            container.setFunction("56", (value) -> value);
            container.setFunction("56ad", (value) -> value);
        } catch (InvalidFunctionNameError e){
            return;
        }
        Assertions.fail("empty or invalid function name was accepted");
    }
}
