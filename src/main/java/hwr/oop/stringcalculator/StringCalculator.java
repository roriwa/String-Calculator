package hwr.oop.stringcalculator;


public class StringCalculator extends CalculatorDataContainer {

    public StringCalculator() {
        DefaultCalculatorData.fillDataContainer(this);
    }

    public double solve(final String equation) {
        return StringCalculator.solve(equation, this);
    }

    public static double solve(final String equation, CalculatorDataContainer dataContainer) {
        EquationSolver solver = new EquationSolver(equation, dataContainer);
        return solver.resolve();
    }
}
