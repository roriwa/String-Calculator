package hwr.oop.stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SuffixTests {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    void testFacultative() {
        double result;
        result = calculator.solve("1!");
        Assertions.assertThat(result).isEqualTo(1);
        result = calculator.solve("2!");
        Assertions.assertThat(result).isEqualTo(2);
        result = calculator.solve("3!");
        Assertions.assertThat(result).isEqualTo(6);
        result = calculator.solve("4!");
        Assertions.assertThat(result).isEqualTo(24);
    }

    @Test
    void testAngle() {
        double result = calculator.solve("34%");
        Assertions.assertThat(result).isEqualTo(0.34);
    }

    @Test
    void testSquare() {
        double result = calculator.solve("5²");
        Assertions.assertThat(result).isEqualTo(25);
    }

    @Test
    void testCubic() {
        double result = calculator.solve("3³");
        Assertions.assertThat(result).isEqualTo(27);
    }

    @Test
    void testCustomSuffix() {
        calculator.setSuffixOperators('?', (x) -> (x != 0) ? 1.0 : 0.0);
        double result;
        result = calculator.solve("5?");
        Assertions.assertThat(result).isEqualTo(1);
        result = calculator.solve("0?");
        Assertions.assertThat(result).isEqualTo(0);
    }
}
