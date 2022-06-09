package hwr.oop.stringcalculator.equationssolver;

import hwr.oop.stringcalculator.equationsolver.EquationSolver;
import hwr.oop.stringcalculator.operationscontainer.OperationsContainer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class EquationsSolverTests {
    @Test
    void testEmptyEquationException(){
        try{
            OperationsContainer dataContainer = OperationsContainer.createNewWithDefault();
            new EquationSolver("", dataContainer);
        } catch (RuntimeException e){
            return;
        }
        Assertions.fail("empty equation was accepted");
    }

    @Test
    void testIncompleteEquation(){
        double result;
        try{
            OperationsContainer dataContainer = OperationsContainer.createNewWithDefault();
            EquationSolver solver = new EquationSolver("2+3?", dataContainer);
            result = solver.resolve();
        } catch (RuntimeException e){
            return;
        }
        Assertions.fail("incomplete equation was accepted: " + result);
    }

    @Test
    void testMissingBracket(){
        double result;
        try{
            OperationsContainer dataContainer = OperationsContainer.createNewWithDefault();
            EquationSolver solver = new EquationSolver("3*(2+4", dataContainer);
            result = solver.resolve();
        } catch (RuntimeException e){
            return;
        }
        Assertions.fail("incomplete equation was accepted: " + result);
    }
}
