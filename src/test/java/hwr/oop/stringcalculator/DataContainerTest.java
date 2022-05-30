package hwr.oop.stringcalculator;

import org.junit.jupiter.api.Test;

public class DataContainerTest {
    @Test
    void testAddRemoveOperations(){
        CalculatorDataContainer container = CalculatorDataContainer.createNewWithDefault();

        container.removeExpressionOperator('+');
        container.removeTermOperator('*');
        container.removeFactorOperator('^');
        container.removePrefixOperator('-');
        container.removeSuffixOperator('!');
        container.removeVariable("e");
        container.removeFunction("sin");
    }
}
