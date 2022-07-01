package hwr.oop.stringcalculator.operationscontainer.operationsbuilder;

public class OperationsImplementations {
    /*
     * this class is made similar to the builtin 'Math' class
     * but adjusted to fit the OperationsBuilder
     */

    // basic-operations

    public static double addition(double a, double b) {
        return a + b;
    }

    public static double subtraction(double a, double b) {
        return a - b;
    }

    public static double multiplication(double a, double b) {
        return a * b;
    }

    public static double division(double a, double b) {
        return a / b;
    }

    public static double modulo(double a, double b) {
        return a % b;
    }

    public static double pow(double a, double b) {
        return Math.pow(a, b);
    }

    // prefix-operations

    public static double positive(double a) {
        return +a;
    }

    public static double negative(double a) {
        return -a;
    }

    public static double round(double a) {
        return Math.round(a);
    }

    // suffix-operations

    public static double faculty(double a) {
        double result = 1;
        for (int i = 1; i <= a; i++) {
            result *= i;
        }
        return result;
    }

    public static double degreesToRadian(double a) {
        return Math.toRadians(a);
    }

    public static double toPercent(double a) {
        return a / 100;
    }

    public static double squared(double a) {
        return Math.pow(a, 2);
    }

    public static double cubic(double a) {
        return Math.pow(a, 3);
    }

    // functions

    public static double function_sin(double a) {
        return Math.sin(a);
    }

    public static double function_asin(double a) {
        return Math.asin(a);
    }

    public static double function_cos(double a) {
        return Math.cos(a);
    }

    public static double function_acos(double a) {
        return Math.acos(a);
    }

    public static double function_tan(double a) {
        return Math.tan(a);
    }

    public static double function_atan(double a) {
        return Math.atan(a);
    }

    public static double toRadians(double a) {
        return Math.toRadians(a);
    }

    public static double toDegrees(double a) {
        return Math.toDegrees(a);
    }

    public static double function_abs(double a) {
        return Math.abs(a);
    }

    public static double function_sqrt(double a) {
        return Math.sqrt(a);
    }

    public static double function_log(double a) {
        return Math.log(a);
    }

    public static double function_log10(double a) {
        return Math.log10(a);
    }
}
