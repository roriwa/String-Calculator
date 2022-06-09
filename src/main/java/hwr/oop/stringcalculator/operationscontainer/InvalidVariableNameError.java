package hwr.oop.stringcalculator.operationscontainer;

public class InvalidVariableNameError extends RuntimeException{
    // I want that it is required to pass a Message
    public InvalidVariableNameError(String message)
    {
        super(message);
    }
}
