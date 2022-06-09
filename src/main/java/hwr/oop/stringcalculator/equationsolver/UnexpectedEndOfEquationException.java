package hwr.oop.stringcalculator.equationsolver;

public class UnexpectedEndOfEquationException extends RuntimeException {
    // it's required to pass a message for more details
    public UnexpectedEndOfEquationException(String message) {
        super(message);
    }
}
