package hwr.oop.stringcalculator.operationscontainer;

public class InvalidVariableNameException extends RuntimeException{
    // it's required to pass a message for more details
    public InvalidVariableNameException(String message)
    {
        super(message);
    }
}
