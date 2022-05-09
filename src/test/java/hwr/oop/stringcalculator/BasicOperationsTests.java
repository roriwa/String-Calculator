package hwr.oop.stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class BasicOperationsTests {
    @Test
    void testAddition(){
        StringCalculator calculator = new StringCalculator();
        double result = calculator.solve("2+3");
        Assertions.assertThat(result).isEqualTo(5);
    }

    @Test
    void testSubtraction(){
        StringCalculator calculator = new StringCalculator();
        double result = calculator.solve("7-4");
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    void testMultiplication(){
        StringCalculator calculator = new StringCalculator();
        double result = calculator.solve("3*4");
        Assertions.assertThat(result).isEqualTo(12);
    }

    @Test
    void testDivision(){
        StringCalculator calculator = new StringCalculator();
        double result = calculator.solve("8/4");
        Assertions.assertThat(result).isEqualTo(2);
    }

    @Test
    void testPow(){
        StringCalculator calculator = new StringCalculator();
        double result = calculator.solve("4^4");
        Assertions.assertThat(result).isEqualTo(256);
    }

    @Test
    void testModulo(){
        StringCalculator calculator = new StringCalculator();
        double result = calculator.solve("6\\4");
        Assertions.assertThat(result).isEqualTo(2);
    }

    @Test
    void testCustomOperator(){
        StringCalculator calculator = new StringCalculator();
        calculator.setExpressionOperator('#', (a, b) -> a*2 + b*2);
        double result = calculator.solve("5#3");
        Assertions.assertThat(result).isEqualTo(16);
    }
}
