package hwr.oop.stringcalculator;

public class DefaultCalculatorData {
    public static void fillDataContainer(CalculatorDataContainer container){
        initialiseBasicOperators(container);  // 0x0
        initialisePrefixOperators(container);  // x0
        initialiseSuffixOperators(container);  // 0x
        initialiseConstants(container);  // x
        initialiseFunctions(container);  // x(0)
    }

    /*
     * initialisation default operations, functions, etc
     */

    private static void initialiseBasicOperators(CalculatorDataContainer container){
        container.setExpressionOperator('+', Double::sum);
        container.setExpressionOperator('-', (a, b) -> a - b);
        container.setTermOperator('*', (a, b) -> a * b);
        container.setTermOperator('/', (a, b) -> a / b);
//        container.setTermOperator('%', (a, b) -> a % b);  // not possible with the current %-suffix (reason: priority)
        container.setTermOperator('\\', (a, b) -> a % b);  // but this version for modulo is possible
        container.setFactorOperator('^', Math::pow);
    }

    private static void initialisePrefixOperators(CalculatorDataContainer container){
        container.setPrefixOperators('+', (a) -> +a);
        container.setPrefixOperators('-', (a) -> -a);
        container.setPrefixOperators('~', (a) -> (double)Math.round(a));
    }

    private static void initialiseSuffixOperators(CalculatorDataContainer container){
        container.setSuffixOperators('!', (a) -> {
            double result = 1;
            for(int i = 1; i <= a; i++){
                result *= i;
            }
            return result;
        });
        container.setSuffixOperators('°', Math::toRadians);  // should be pretty helpful
        container.setSuffixOperators('%', (x) -> x / 100);  // should be pretty helpful
        container.setSuffixOperators('²', (x) -> Math.pow(x, 2));  // should be pretty helpful
        container.setSuffixOperators('³', (x) -> Math.pow(x, 3));  // should be pretty helpful
    }

    private static void initialiseConstants(CalculatorDataContainer container){
        container.setVariable("pi", Math.PI);
        container.setVariable("e", Math.E);
    }

    private static void initialiseFunctions(CalculatorDataContainer container){
        container.setFunction("sin", Math::sin);
        container.setFunction("asin", Math::asin);
        container.setFunction("cos", Math::cos);
        container.setFunction("acos", Math::acos);
        container.setFunction("tan", Math::tan);
        container.setFunction("atan", Math::atan);
        container.setFunction("rad", Math::toRadians);
        container.setFunction("deg", Math::toDegrees);
        container.setFunction("abs", Math::abs);
        container.setFunction("sqrt", Math::sqrt);
        container.setFunction("log", Math::log);
        container.setFunction("log10", Math::log10);
    }
}
