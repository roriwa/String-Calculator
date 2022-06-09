package hwr.oop.stringcalculator.equationsolver;

public class UnexpectedCharacterException extends RuntimeException{
    // it's required to pass a message for more details
    public UnexpectedCharacterException(String message){
        super(message);
    }
}
