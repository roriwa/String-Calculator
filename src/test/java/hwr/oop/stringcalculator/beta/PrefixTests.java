package hwr.oop.stringcalculator.beta;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrefixTests {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    void testPositivePrefix() {
        double result = calculator.solve("+10");
        Assertions.assertThat(result).isEqualTo(+10);
    }

    @Test
    void testNegativePrefix() {
        double result = calculator.solve("-10");
        Assertions.assertThat(result).isEqualTo(-10);
    }

    @Test
    void testDoubleNegativePrefix() {
        double result = calculator.solve("--10");
        Assertions.assertThat(result).isEqualTo(10);
    }

    @Test
    void testRoundPrefix() {
        double result = calculator.solve("~3.1415");
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    void testCustomPrefix() {
        calculator.setPrefixOperators(':', (a) -> Math.E * a);
        double result = calculator.solve(":7");
        Assertions.assertThat(result).isEqualTo(Math.E * 7);
    }
}
