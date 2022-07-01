package hwr.oop.stringcalculator.equationsolver;

public class EmptyEquationException extends RuntimeException {
    // it's required to pass a message for more details
    public EmptyEquationException(String message) {
        super(message);
    }
}
