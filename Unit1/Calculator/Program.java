package Calculator;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        NumCalc calc = new NumCalc();
        boolean stop = false;
        do {
            System.out.print("Expression?>");
            String expression = console.nextLine();
            if(expression.equalsIgnoreCase("quit") || expression.equalsIgnoreCase("exit")) {
                stop = true;
            }
            else {
                try {
                    System.out.println(calc.evaluate(expression));
                }
                catch(ArithmeticException e) {
                    System.out.println("##Error: Division by zero");
                    continue;
                }
                catch(IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                catch(Exception e) {
                    System.out.println("Something happened!" + e.getClass() +  " " + e.getMessage());
                }
                try {
                    System.out.println("Evaluation trace-------------------");
                    System.out.println(calc);
                }
                catch(Exception e) {
                    System.out.println("Something happened!" + e.getClass() + " " + e.getMessage());
                }
            }
        }
        while(!stop);
        console.close();
    }
}
