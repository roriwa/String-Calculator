package hwr.oop.stringcalculator;


import hwr.oop.stringcalculator.equationsolver.EquationSolver;
import hwr.oop.stringcalculator.operationscontainer.OperationsContainer;
import hwr.oop.stringcalculator.operationscontainer.operationsbuilder.OperationsBuilder;

public class StringCalculator extends OperationsContainer {
    /*
     * this class is meant as a simplification of the 'equationsolver' and 'operationscontainer' (sub-)packages
     * it includes upon creation the default operations and contains a .solve() method that simplifies the EquationSolver
     *
     * inheritance is in this case allowed because this class doesn't need to know what the OperationsContainer
     * can or can't do. It only passes it forward to the EquationSolver
     */

    public StringCalculator() {
        OperationsBuilder builder = new OperationsBuilder();
        builder.setAll(true);
        builder.setOperationsOn(this);
    }

    public double solve(final String equation) {
        EquationSolver solver = new EquationSolver(equation, this);
        return solver.resolve();
    }
}
