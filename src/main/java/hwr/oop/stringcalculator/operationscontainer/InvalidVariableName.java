package hwr.oop.stringcalculator.operationscontainer;

public class InvalidVariableName extends RuntimeException{
    // I want that it is required to pass a Message
    public InvalidVariableName(String message)
    {
        super(message);
    }
}
