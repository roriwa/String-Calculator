package hwr.oop.stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValidateInputTests {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    void testValidInputEquation() {
        try {
            calculator.solve("1");
        } catch (RuntimeException e) {
            Assertions.fail("valid equation wasn't accepted");
        }
    }

    @Test
    void testInvalidInputEquation() {
        try {
            calculator.solve("?");
        } catch (RuntimeException e) {
            return;
        }
        Assertions.fail("invalid equation was accepted");
    }
}
