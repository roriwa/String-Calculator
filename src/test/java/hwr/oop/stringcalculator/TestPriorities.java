package hwr.oop.stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestPriorities {
    @Test
    void testMultiplicationBeforeAddition(){
        StringCalculator calculator = new StringCalculator();
        double result = calculator.solve("2+3*3");
        Assertions.assertThat(result).isEqualTo(11).isNotEqualTo(15);
    }

    @Test
    void testDivisionBeforeSubtraction(){
        StringCalculator calculator = new StringCalculator();
        double result = calculator.solve("10-9/3");
        Assertions.assertThat(result).isEqualTo(7);
    }
}
