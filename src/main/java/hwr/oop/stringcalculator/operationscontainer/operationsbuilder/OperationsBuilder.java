package hwr.oop.stringcalculator.operationscontainer.operationsbuilder;

import hwr.oop.stringcalculator.operationscontainer.OperationsContainer;
import hwr.oop.stringcalculator.operationscontainer.OperationsSettable;

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
        this.setOperationsOn(container);
        return container;
    }

    public void setOperationsOn(OperationsSettable container) {
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
        container.setExpressionOperator('+', OperationsImplementations::addition);
        container.setExpressionOperator('-', OperationsImplementations::subtraction);
        container.setTermOperator('*', OperationsImplementations::multiplication);
        container.setTermOperator('/', OperationsImplementations::division);
//        container.setTermOperator('%', (a, b) -> a % b);  // not possible with the current %-suffix (reason: priority)
        // modulo may get removed because it's not so useful in classic math
        container.setTermOperator('\\', OperationsImplementations::modulo);  // but this version for modulo is possible
        container.setFactorOperator('^', OperationsImplementations::pow);
    }

    private void setPrefixOperators(OperationsSettable container) {
        container.setPrefixOperators('+', OperationsImplementations::positive);
        container.setPrefixOperators('-', OperationsImplementations::negative);
        container.setPrefixOperators('~', OperationsImplementations::round);
    }

    private void setSuffixOperators(OperationsSettable container) {
        container.setSuffixOperators('!', OperationsImplementations::faculty);
        // most function need radians and with this suffix you can write `sin(90°)` and it should work
        container.setSuffixOperators('°', OperationsImplementations::degreesToRadian);  // should be pretty helpful
        container.setSuffixOperators('%', OperationsImplementations::toPercent);  // should be pretty helpful
        container.setSuffixOperators('²', OperationsImplementations::squared);  // should be pretty helpful
        container.setSuffixOperators('³', OperationsImplementations::cubic);  // should be pretty helpful
    }

    private void setConstants(OperationsSettable container) {
        container.setVariable("pi", Math.PI);
        container.setVariable("e", Math.E);
    }

    private void setFunctions(OperationsSettable container) {
        container.setFunction("sin", OperationsImplementations::function_sin);
        container.setFunction("asin", OperationsImplementations::function_asin);
        container.setFunction("cos", OperationsImplementations::function_cos);
        container.setFunction("acos", OperationsImplementations::function_acos);
        container.setFunction("tan", OperationsImplementations::function_tan);
        container.setFunction("atan", OperationsImplementations::function_atan);
        container.setFunction("rad", OperationsImplementations::toRadians);
        container.setFunction("deg", OperationsImplementations::toDegrees);
        container.setFunction("abs", OperationsImplementations::function_abs);
        container.setFunction("sqrt", OperationsImplementations::function_sqrt);
        container.setFunction("log", OperationsImplementations::function_log);
        container.setFunction("log10", OperationsImplementations::function_log10);
    }
}
