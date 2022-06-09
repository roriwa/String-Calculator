package hwr.oop.stringcalculator.equationsolver;

public class EndOfEquationException extends RuntimeException {
    // it's required to pass a message for more details
    public EndOfEquationException(String message) {
        super(message);
    }
}
