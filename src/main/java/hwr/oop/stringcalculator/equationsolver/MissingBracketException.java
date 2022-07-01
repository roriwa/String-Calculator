package hwr.oop.stringcalculator.equationsolver;

public class MissingBracketException extends RuntimeException {
    // it's required to pass a message for more details
    public MissingBracketException(String message) {
        super(message);
    }
}
