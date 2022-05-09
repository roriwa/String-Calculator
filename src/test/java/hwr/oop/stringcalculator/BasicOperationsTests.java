package hwr.oop.stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BasicOperationsTests {

    private StringCalculator calculator;

    @BeforeEach
    void setUp(){
        calculator = new StringCalculator();
    }

    @Test
    void testAddition(){
        double result = calculator.solve("2+3");
        Assertions.assertThat(result).isEqualTo(5);
    }

    @Test
    void testSubtraction(){
        double result = calculator.solve("7-4");
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    void testMultiplication(){
        double result = calculator.solve("3*4");
        Assertions.assertThat(result).isEqualTo(12);
    }

    @Test
    void testDivision(){
        double result = calculator.solve("8/4");
        Assertions.assertThat(result).isEqualTo(2);
    }

    @Test
    void testPow(){
        double result = calculator.solve("4^4");
        Assertions.assertThat(result).isEqualTo(256);
    }

    @Test
    void testModulo(){
        double result = calculator.solve("6\\4");
        Assertions.assertThat(result).isEqualTo(2);
    }

    @Test
    void testCustomOperator(){
        calculator.setExpressionOperator('#', (a, b) -> a*2 + b*2);
        double result = calculator.solve("5#3");
        Assertions.assertThat(result).isEqualTo(16);
    }
}
