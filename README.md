# String-Calculator
Java class to evaluate Mathematical Strings

## Abstract

String-Calculator is a Java-Class to safely evaluate a Mathematical Equation.
This Equation can be (e.g.) from a User.

From Basic Operators like plus and minus it features also small helpful additions like the `°` (`90° => π/4`) suffix to convert degrees to radian.

It is designed to make it easy to customize the Calculator by adding custom functions, variables or even operators.
It is also possible to overwrite an existing operator
(eg `calculator.setExpressionOperator('+', (a, b) -> 2*a + 2*b);`, `2+2 => 8`)
or to create a complete new operator
(eg `calculator.setPrefixOperators('~', (x) -> Math.round(x));`, `~0.6845 => 1.0`)


### Usage Example
```java
import hwr.oop.stringcalculator.StringCalculator;
class Test{
    public static void main(String[] args){
        StringCalculator calculator = new StringCalculator();
        calculator.setVariable("x", 5);
        
        double result = calculator.solve("2*x²-4");  // 46
        
        System.out.print("Result: ");
        System.out.println(result);
    }
}
```
[TODO]: # (Write a short description of your project.)
[TODO]: # (State most important features.)
[TODO]: # (State the most interesting problems you encountered during the project.)

## Feature List

[TODO]: # (✔️❌️✅️❔️)

| Meaning                 | Icon |
|-------------------------|------|
| Successful:             | ️✅   |
| Failed:                 | ❌️   |
| Not Tested/Implemented: | ️❔   |

| Number | Feature                    | Tests |
|--------|----------------------------|-------|
| 1      | Basic Operations (+,-,*,/) | ❔️    |
| 2      | Custom Basic Operations    | ❔️    |
| 3      | Prefix Operators (+,-)     | ❔️    |
| 4      | Custom Prefix Operators    | ❔️    |
| 5      | Suffix Operators (!,°,²,³) | ❔️    |
| 6      | Custom Suffix Operators    | ❔️    |
| 7      | Functions                  | ❔️    |
| 8      | Custom Functions           | ❔️    |
| 9      | Constants (π,ⅇ)            | ❔️    |
| 10     | Custom Variables           | ❔️    |


## Additional Dependencies
> No Additional Dependencies Required

| Number | Dependency Name | Dependency Description | Why is it necessary? |
|--------|-----------------|------------------------|----------------------|
| 1      | /               | /                      | /                    |
