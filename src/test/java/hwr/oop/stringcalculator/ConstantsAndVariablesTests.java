package hwr.oop.stringcalculator;

import hwr.oop.stringcalculator.equationsolver.MissingVariableException;
import hwr.oop.stringcalculator.operationscontainer.InvalidVariableNameException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConstantsAndVariablesTests {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    void testPi() {
        double result = calculator.solve("pi");
        Assertions.assertThat(result).isEqualTo(Math.PI);
    }

    @Test
    void testE() {
        double result = calculator.solve("e");
        Assertions.assertThat(result).isEqualTo(Math.E);
    }

    @Test
    void testX() {
        double x = 4567.9876;
        calculator.setVariable("x", x);
        double result = calculator.solve("x");
        Assertions.assertThat(result).isEqualTo(x);
    }

    @Test
    void testVariableOverride() {
        double x1 = 9876.5432;
        double x2 = 1234.5678;
        calculator.setVariable("x", x1);
        calculator.setVariable("x", x2);
        double result = calculator.solve("x");
        Assertions.assertThat(result).isEqualTo(x2).isNotEqualTo(x1);
    }

    @Test
    void testMissingVariable() {
        double result;
        try {
            result = calculator.solve("x");
        } catch (MissingVariableException e) {
            return;
        }
        Assertions.fail("missing variable was accepted: " + result);
    }

    @Test
    void testIllegalVariableName() {
        try {
            calculator.setVariable("1234", 69);
        } catch (InvalidVariableNameException e) {
            return;
        }
        Assertions.fail("illegal variable-name (a number) was accepted");
    }
}
