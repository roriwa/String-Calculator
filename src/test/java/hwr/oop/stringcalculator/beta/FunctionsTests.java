package hwr.oop.stringcalculator.beta;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FunctionsTests {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    void testSin() {
        double result = calculator.solve("sin(pi/2)");
        Assertions.assertThat(result).isCloseTo(1.0, Percentage.withPercentage(0.01));
    }

    @Test
    void testArcSin() {
        double result = calculator.solve("asin(1)");
        Assertions.assertThat(result).isCloseTo(Math.PI / 2, Percentage.withPercentage(0.01));
    }

    @Test
    void testCos() {
        double result = calculator.solve("cos(0)");
        Assertions.assertThat(result).isCloseTo(1.0, Percentage.withPercentage(0.01));
    }

    @Test
    void testArcCos() {
        double result = calculator.solve("acos(1)");
        Assertions.assertThat(result).isCloseTo(0.0, Percentage.withPercentage(0.01));
    }

    @Test
    void testTan() {
        double result = calculator.solve("tan(pi/4)");
        Assertions.assertThat(result).isCloseTo(1.0, Percentage.withPercentage(0.01));
    }

    @Test
    void testArcTan() {
        double result = calculator.solve("atan(1)");
        Assertions.assertThat(result).isCloseTo(Math.PI / 4, Percentage.withPercentage(0.01));
    }

    @Test
    void testToRadians() {
        double result = calculator.solve("rad(180)");
        Assertions.assertThat(result).isEqualTo(Math.PI);
    }

    @Test
    void testToDegrees() {
        double result = calculator.solve("deg(pi)");
        Assertions.assertThat(result).isEqualTo(180);
    }

    @Test
    void testAbsolute() {
        double result = calculator.solve("abs(-25)");
        Assertions.assertThat(result).isEqualTo(25);
    }

    @Test
    void testSquareRoot() {
        double result = calculator.solve("sqrt(9)");
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    void testLogBaseE() {
        double result = calculator.solve("log(e³)");
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    void testLogBase10() {
        double result = calculator.solve("log10(10³)");
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    void testCustomFunction() {
        calculator.setFunction("test", (x) -> 10 * x);
        double result = calculator.solve("test(10)");
        Assertions.assertThat(result).isEqualTo(100);
    }
}
