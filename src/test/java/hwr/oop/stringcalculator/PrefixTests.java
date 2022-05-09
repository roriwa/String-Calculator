package hwr.oop.stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrefixTests {
    @Test
    void testPositivePrefix(){
        StringCalculator calculator = new StringCalculator();
        double result = calculator.solve("+10");
        Assertions.assertThat(result).isEqualTo(+10);
    }

    @Test
    void testNegativePrefix(){
        StringCalculator calculator = new StringCalculator();
        double result = calculator.solve("-10");
        Assertions.assertThat(result).isEqualTo(-10);
    }

    @Test
    void testDoubleNegativePrefix(){
        StringCalculator calculator = new StringCalculator();
        double result = calculator.solve("--10");
        Assertions.assertThat(result).isEqualTo(10);
    }

    @Test
    void testRoundPrefix(){
        StringCalculator calculator = new StringCalculator();
        double result = calculator.solve("~3.1415");
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    void testCustomPrefix(){
        StringCalculator calculator = new StringCalculator();
        calculator.setPrefixOperators(':', (a) -> Math.E * a);
        double result = calculator.solve(":7");
        Assertions.assertThat(result).isEqualTo(Math.E * 7);
    }
}
