
import java.util.Scanner;

/**
 * Author:  Sydney Walker
 * Period:  9
 * Sauce Code: 16
 * Class:   RecursionClient.java
 * Purpose: run the methods in RecursionMethods
 */

public class RecursionClient {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("1: GCF\n2: Raise to a Power\n3: Quit");
            int choice = input.nextInt();
            switch(choice){
                case 1: 
                    System.out.println("Enter the first integer.");
                    int num1 = input.nextInt();
                    System.out.println("Enter the second integer.");
                    int num2 = input.nextInt();
                    System.out.println("GCF = " + RecursionMethods.greatestCommonFactor(num1, num2));
                    break;
                case 2:
                    System.out.println("Enter the base.");
                    int base = input.nextInt();
                    System.out.println("Enter the exponent.");
                    int exponent = input.nextInt();
                    double answer = RecursionMethods.raiseToPower(base, exponent);
                    answer *= 100000;
                    answer = (int)answer;
                    answer /= 100000;
                    System.out.println(answer);
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
    }
}




