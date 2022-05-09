package hwr.oop.stringcalculator;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class SuffixTests {
    @Test
    void testFacultative(){
        StringCalculator calculator = new StringCalculator();
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
    void testAngle(){
        StringCalculator calculator = new StringCalculator();
        double result = calculator.solve("34%");
        Assertions.assertThat(result).isEqualTo(0.34);
    }

    @Test
    void testSquare(){
        StringCalculator calculator = new StringCalculator();
        double result = calculator.solve("5²");
        Assertions.assertThat(result).isEqualTo(25);
    }

    @Test
    void testCubic(){
        StringCalculator calculator = new StringCalculator();
        double result = calculator.solve("3³");
        Assertions.assertThat(result).isEqualTo(27);
    }

    @Test
    void testCustomSuffix(){
        StringCalculator calculator = new StringCalculator();
        calculator.setSuffixOperators('?', (x) -> (x != 0) ? 1.0 : 0.0);
        double result;
        result = calculator.solve("5?");
        Assertions.assertThat(result).isEqualTo(1);
        result = calculator.solve("0?");
        Assertions.assertThat(result).isEqualTo(0);
    }
}
