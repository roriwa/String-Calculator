package hwr.oop.stringcalculator;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class ValidateInputTests {
    @Test
    void testValidInputEquation(){
        StringCalculator calculator = new StringCalculator();
        try{
            calculator.solve("1");
        } catch (RuntimeException e){
            Assertions.fail("valid equation wasn't accepted");
        }
    }

    @Test
    void testInvalidInputEquation(){
        StringCalculator calculator = new StringCalculator();
        try{
            calculator.solve("?");
        } catch (RuntimeException e){
            return;
        }
        Assertions.fail("invalid equation was accepted");
    }
}
