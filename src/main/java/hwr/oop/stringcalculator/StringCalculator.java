package hwr.oop.stringcalculator;


import hwr.oop.stringcalculator.equationsolver.EquationSolver;
import hwr.oop.stringcalculator.operationscontainer.OperationsContainer;
import hwr.oop.stringcalculator.operationscontainer.DefaultOperationManager;

public class StringCalculator extends OperationsContainer {

    public StringCalculator() {
        DefaultOperationManager.setDefaultData(this);
    }

    public double solve(final String equation) {
        return StringCalculator.solve(equation, this);
    }

    public static double solve(final String equation, final OperationsContainer dataContainer) {
        EquationSolver solver = new EquationSolver(equation, dataContainer);
        return solver.resolve();
    }
}
