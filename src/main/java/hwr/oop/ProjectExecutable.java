package hwr.oop;

import java.util.Scanner;
import hwr.oop.stringcalculator.StringCalculator;


public class ProjectExecutable {
    /*
     * this class is meant to have an executable version of the StringCalculator
     *
     * it consists of continues input of equation that then get solved using the StringCalculator class
     *
     * it is NOT part of the 'stringcalculator' or related packages
     *
     * maybe a better file-place would be somewhere in the test directory (because it's the same as the ManuelTest.java)
     */

    Scanner inputStream;
    String inputEquation;
    StringCalculator calculator;

    public static void main(String[] args) {
        new ProjectExecutable().run();
    }

    ProjectExecutable() {
        this.inputStream = new Scanner(System.in);
        this.calculator = new StringCalculator();
    }

    private void run() {
        this.readInput();
        while (this.inputEquation.length() > 0) {
            try {
                double result = this.calculator.solve(this.inputEquation);
                this.printResult(result);
            } catch (Exception e) {
                e.printStackTrace(System.out);
            } finally {
                this.readInput();
            }
        }
    }

    private void readInput() {
        System.out.print("Equation: ");
        this.inputEquation = this.inputStream.nextLine();
    }

    private void printResult(double result) {
        System.out.print("Result: ");
        System.out.println(result);
    }
}
