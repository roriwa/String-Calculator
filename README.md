# String-Calculator

Java class to evaluate Mathematical Strings

## Abstract

String-Calculator is a Java-Class to safely evaluate a Mathematical Equation.
This Equation can be (e.g.) from a User.

From Basic Operators like plus and minus it features also small helpful additions like the `°`-suffix to convert degrees
to radian (`90° => π/4`) to be able to execute `sin()` or `cos()` in an easy manner (`sin(90°)`) instead with the
complicated usage of `rad()` (`sin(rad(90))`).

It is designed to make it easy to customize the Calculator by adding custom functions, variables or even operators.
It is also possible to overwrite an existing operator
(eg `calculator.setExpressionOperator('+', (a, b) -> 2*a + 2*b);`, `2+2 => 8`)
or to create a completely new operators
(eg `calculator.setPrefixOperators('~', (x) -> Math.round(x));`, `~0.6845 => 1.0`)

### Usage Example

```java
import hwr.oop.stringcalculator.StringCalculator;

class CalculatorProgram{
    public static void main(String[] args){
        StringCalculator calculator = new StringCalculator();
        calculator.setVariable("x", 5);
        
        double result = calculator.solve("2*x²-4");  // 46
        
        System.out.print("Result: ");
        System.out.println(result);
    }
}
```

## Feature List

[TODO]: # (✔️❌️✅️❔️)

| Meaning                 | Icon |
|-------------------------|------|
| Successful:             | ️✅   |
| Failed:                 | ❌️   |
| Not Tested/Implemented: | ️❔   |

| Feature                    | Tests |
|----------------------------|-------|
| Basic Operations (+,-,*,/) | ️✅️   |
| Custom Basic Operations    | ️✅️   |
| Prefix Operators (+,-,~)   | ️✅️   |
| Custom Prefix Operators    | ️✅️   |
| Suffix Operators (!,°,²,³) | ️✅️   |
| Custom Suffix Operators    | ️✅️   |
| Functions (sin, sqrt, log) | ️✅️   |
| Custom Functions           | ️✅️   |
| Constants (π,ⅇ)            | ️✅️   |
| Custom Variables           | ️✅️   |

## Additional Dependencies

> No Additional Dependencies Required

| Number | Dependency Name | Dependency Description | Why is it necessary? |
|--------|-----------------|------------------------|----------------------|
| 1      | /               | /                      | /                    |

## Problems during development

- order of operations (e.g. Multiplication before Addition)
- Rounding Errors during tests (e.g. result is 0.99999999 instead of 1.0)
- how to save functions/callable

---

## Complete Index of all (default) Operations

Order of Operations priority

| Priority | Name                       |
|----------|----------------------------|
| 6        | Numbers/Variable/Functions |
| 5        | Suffix-Operators           |
| 4        | Factor-Operators           |
| 3        | Prefix-Operator            |
| 2        | Term-Operators             |
| 1        | Expression-Operators       |

### Expression Operators

| Name        | Operator | Example  |
|-------------|----------|----------|
| Addition    | +        | 2+3 => 5 |
| Subtraction | -        | 5-4 => 1 |

### Term Operators

| Name             | Operator | Example  |
|------------------|----------|----------|
| Multiplication   | *        | 2*3 => 6 |
| Division         | /        | 9/3 => 3 |
| Modulo/Remainder | \        | 8\3 => 2 |

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
| Faculty | !        | 4! => 24    |
| Degrees | °        | 180° => pi  |
| Percent | %        | 34% => 0.34 |
| Square  | ²        | 3² => 9     |
| Cubic   | ³        | 3³ => 27    |

### Constants Operators

| Functions | Name | Example         |
|-----------|------|-----------------|
| π         | pi   | pi => 3.1415... |
| ⅇ         | e    | e => 2.7182...  |

### Functions Operators

| Functions      | Name    | Example           |
|----------------|---------|-------------------|
| Sine           | sin()   | sin(pi/2) => 1.0  |
| Arc Sine       | asin()  | asin(1) => pi/2   |
| Cosine         | cos()   | cos(0) => 1.0     |
| Arc Cosine     | acos()  | acos(1.0) => 0    |
| Tangent        | tan()   | tan(pi/4) => 1.0  |
| Arc Tangent    | atan()  | atan(1.0) => pi/4 |
| To Radians     | rad()   | rad(180) => pi    |
| To Degrees     | deg()   | deg(pi) => 180    |
| Absolute       | abs()   | abs(-8) => 8      |
| Square Root    | sqrt()  | sqrt(9) => 3      |
| Log (Basis ⅇ)  | log()   | log(e³) => 3      |
| Log (Basis 10) | log10() | log(10³) => 3     |
