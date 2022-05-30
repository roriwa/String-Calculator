package hwr.oop.stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class EquationsSolverTest {
    @Test
    void testEmptyEquationException(){
        try{
            CalculatorDataContainer dataContainer = CalculatorDataContainer.createNewWithDefault();
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
            CalculatorDataContainer dataContainer = CalculatorDataContainer.createNewWithDefault();
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
            CalculatorDataContainer dataContainer = CalculatorDataContainer.createNewWithDefault();
            EquationSolver solver = new EquationSolver("3*(2+4", dataContainer);
            result = solver.resolve();
        } catch (RuntimeException e){
            return;
        }
        Assertions.fail("incomplete equation was accepted: " + result);
    }
}
