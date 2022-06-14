package hwr.oop.stringcalculator.operationscontainer;

public class OperationsBuilder {

    private boolean basicOperations;
    private boolean prefixOperations;
    private boolean suffixOperations;
    private boolean constants;
    private boolean functions;

    public void initialiseBasicOperations(boolean yes) {
        this.basicOperations = yes;
    }

    public void initialisePrefixOperations(boolean yes) {
        this.prefixOperations = yes;
    }

    public void initialiseSuffixOperations(boolean yes) {
        this.suffixOperations = yes;
    }

    public void initialiseConstants(boolean yes) {
        this.constants = yes;
    }

    public void initialiseFunctions(boolean yes) {
        this.functions = yes;
    }

    public void setAll(boolean yes) {
        this.initialiseBasicOperations(yes);
        this.initialisePrefixOperations(yes);
        this.initialiseSuffixOperations(yes);
        this.initialiseConstants(yes);
        this.initialiseFunctions(yes);
    }

    public OperationsContainer build() {
        OperationsContainer container = new OperationsContainer();
        this.setOnContainer(container);
        return container;
    }

    public void setOnContainer(OperationsSettable container) {
        if (this.basicOperations)  // 0x0
            this.setBasicOperators(container);

        if (this.prefixOperations)  // x0
            this.setPrefixOperators(container);

        if (this.suffixOperations)  // 0x
            this.setSuffixOperators(container);

        if (this.constants)  // x
            this.setConstants(container);

        if (this.functions)  // x(0)
            this.setFunctions(container);
    }

    /*
     * initialisation default operations, functions, etc
     */

    private void setBasicOperators(OperationsSettable container) {
        container.setExpressionOperator('+', Double::sum);
        container.setExpressionOperator('-', (a, b) -> a - b);
        container.setTermOperator('*', (a, b) -> a * b);
        container.setTermOperator('/', (a, b) -> a / b);
//        container.setTermOperator('%', (a, b) -> a % b);  // not possible with the current %-suffix (reason: priority)
        container.setTermOperator('\\', (a, b) -> a % b);  // but this version for modulo is possible
        container.setFactorOperator('^', Math::pow);
    }

    private void setPrefixOperators(OperationsSettable container) {
        container.setPrefixOperators('+', (a) -> +a);
        container.setPrefixOperators('-', (a) -> -a);
        container.setPrefixOperators('~', (a) -> (double) Math.round(a));
    }

    private void setSuffixOperators(OperationsSettable container) {
        container.setSuffixOperators('!', (a) -> {
            double result = 1;
            for (int i = 1; i <= a; i++) {
                result *= i;
            }
            return result;
        });
        container.setSuffixOperators('°', Math::toRadians);  // should be pretty helpful
        container.setSuffixOperators('%', (x) -> x / 100);  // should be pretty helpful
        container.setSuffixOperators('²', (x) -> Math.pow(x, 2));  // should be pretty helpful
        container.setSuffixOperators('³', (x) -> Math.pow(x, 3));  // should be pretty helpful
    }

    private void setConstants(OperationsSettable container) {
        container.setVariable("pi", Math.PI);
        container.setVariable("e", Math.E);
    }

    private void setFunctions(OperationsSettable container) {
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
