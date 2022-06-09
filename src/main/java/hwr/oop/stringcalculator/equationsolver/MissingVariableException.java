package hwr.oop.stringcalculator.equationsolver;

public class MissingVariableException extends RuntimeException{
    // it's required to pass a message for more details
    public MissingVariableException(String message){
        super(message);
    }
}
