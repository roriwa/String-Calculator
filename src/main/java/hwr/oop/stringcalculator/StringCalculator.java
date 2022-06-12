package hwr.oop.stringcalculator;


import hwr.oop.stringcalculator.equationsolver.EquationSolver;
import hwr.oop.stringcalculator.operationscontainer.OperationsContainer;
import hwr.oop.stringcalculator.operationscontainer.OperationsBuilder;

public class StringCalculator extends OperationsContainer {

    public StringCalculator() {
        OperationsBuilder builder = new OperationsBuilder();
        builder.setAll(true);
        builder.setOnContainer(this);
    }

    public double solve(final String equation) {
        EquationSolver solver = new EquationSolver(equation, this);
        return solver.resolve();
    }
}
