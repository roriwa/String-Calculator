package hwr.oop.stringcalculator.operationscontainer;

import org.junit.jupiter.api.Test;

public class OperationsContainerTests {
    @Test
    void testAddRemoveOperations(){
        OperationsContainer container = OperationsContainer.createNewWithDefault();

        container.removeExpressionOperator('+');
        container.removeTermOperator('*');
        container.removeFactorOperator('^');
        container.removePrefixOperator('-');
        container.removeSuffixOperator('!');
        container.removeVariable("e");
        container.removeFunction("sin");
    }
}
