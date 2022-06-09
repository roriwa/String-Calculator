package hwr.oop.stringcalculator.operationscontainer;

public class InvalidFunctionNameException extends RuntimeException{
    // it's required to pass a message for more details
    public InvalidFunctionNameException(String message)
    {
        super(message);
    }
}
