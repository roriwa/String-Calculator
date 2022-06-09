package hwr.oop.stringcalculator.operationscontainer;

public class InvalidFunctionName extends RuntimeException{
    // I want that it is required to pass a Message
    public InvalidFunctionName(String message)
    {
        super(message);
    }
}
