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


## Complete Index of all (default) Operations

### Expression Operators
| Name        | Operator | Example  |
|-------------|----------|----------|
| Addition    | +        | 2+3 => 5 |
| Subtraction | -        | 5-4 => 1 |

### Term Operators
| Name           | Operator | Example  |
|----------------|----------|----------|
| Multiplication | *        | 2*3 => 6 |
| Division       | /        | 9/3 => 3 |
| Modulo         | \        | 8\3 => 2 |

### Factor Operators
| Name | Operator | Example  |
|------|----------|----------|
| Pow  | ^        | 2^3 => 8 |

### Prefix Operators
| Name     | Operator | Example      |
|----------|----------|--------------|
| Positive | +        | +5 => 5      |
| Negative | -        | -5 => -5     |
| Round    | ~        | ~3.1415 => 3 |

### Suffix Operators
| Name    | Operator | Example     |
|---------|----------|-------------|
| Fak     | !        | 4! => 24    |
| Degrees | °        | 180° => pi  |
| Percent | %        | 34% => 0.34 |
| Square  | ²        | 3² => 9     |
| Cubic   | ³        | 3³ => 27    |

### Constants Operators
| Name | Operator | Example         |
|------|----------|-----------------|
| π    | pi       | pi => 3.1415... |
| ⅇ    | e        | e => 2.7182...  |

### Functions Operators
| Name           | Operator | Example           |
|----------------|----------|-------------------|
| Sine           | sin()    | sin(pi/2) => 1.0  |
| Arc Sine       | asin()   | asin(1) => pi/2   |
| Cosine         | cos()    | cos(0) => 1.0     |
| Arc Cosine     | acos()   | acos(1.0) => 0    |
| Tangent        | tan()    | tan(pi/4) => 1.0  |
| Arc Tangent    | atan()   | atan(1.0) => pi/4 |
| To Radians     | rad()    | rad(180) => pi    |
| To Degrees     | deg()    | deg(pi) => 180    |
| Absolute       | abs()    | abs(-8) => 8      |
| Square Root    | sqrt()   | sqrt(9) => 3      |
| Log (Basis ⅇ)  | log()    | log(e³) => 3      |
| Log (Basis 10) | log10()  | log(10³) => 3     |
