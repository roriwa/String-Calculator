package hwr.oop.stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConstantsAndVariablesTests {
    @Test
    void testPi(){
        StringCalculator calculator = new StringCalculator();
        double result = calculator.solve("pi");
        Assertions.assertThat(result).isEqualTo(Math.PI);
    }

    @Test
    void testE(){
        StringCalculator calculator = new StringCalculator();
        double result = calculator.solve("e");
        Assertions.assertThat(result).isEqualTo(Math.E);
    }

    @Test
    void testX(){
        double x = 4567.9876;
        StringCalculator calculator = new StringCalculator();
        calculator.setVariable("x", x);
        double result = calculator.solve("x");
        Assertions.assertThat(result).isEqualTo(x);
    }

    @Test
    void testVariableOverride(){
        double x1 = 9876.5432;
        double x2 = 1234.5678;
        StringCalculator calculator = new StringCalculator();
        calculator.setVariable("x", x1);
        calculator.setVariable("x", x2);
        double result = calculator.solve("x");
        Assertions.assertThat(result).isEqualTo(x2).isNotEqualTo(x1);
    }

    @Test
    void testMissingVariable(){
        StringCalculator calculator = new StringCalculator();
        double result;
        try{
            result = calculator.solve("x");
        } catch (RuntimeException e){
            return;
        }
        Assertions.fail("missing variable was accepted: " + result);
    }
}
