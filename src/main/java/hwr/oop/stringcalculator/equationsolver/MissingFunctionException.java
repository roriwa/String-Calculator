package hwr.oop.stringcalculator.equationsolver;

public class MissingFunctionException extends RuntimeException {
    // it's required to pass a message for more details
    public MissingFunctionException(String message) {
        super(message);
    }
}
