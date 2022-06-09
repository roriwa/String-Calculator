package hwr.oop.stringcalculator.operationscontainer;

public class InvalidFunctionNameError extends RuntimeException{
    // I want that it is required to pass a Message
    public InvalidFunctionNameError(String message)
    {
        super(message);
    }
}
