package hwr.oop.stringcalculator.beta;

import java.util.Scanner;


public class ManualTest {
    Scanner input;
    String inputEquation;
    StringCalculator calculator;

    public static void main(String[] args){
        new ManualTest().run();
    }

    ManualTest(){
        this.input = new Scanner(System.in);
        this.calculator = new StringCalculator();
    }

    private void run(){
        this.readInput();
        while(this.inputEquation.length() > 0){
            try{
                double result = calculator.solve(this.inputEquation);
                this.printResult(result);
            } catch (Exception e) {
                e.printStackTrace(System.out);
            } finally {
                this.readInput();
            }
        }
    }

    private void readInput(){
        System.out.print("Equation: ");
        this.inputEquation = this.input.nextLine();
    }

    private void printResult(double result){
        System.out.print("Result: ");
        System.out.println(result);
    }
}
