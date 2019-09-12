import java.util.Scanner;
 
/**
 * Author:  Sydney Walker
 * Period:  9
 * Class:   EstimatePI
 * Purpose: estimate the value of pi with an entered number of iterations of Leibnitz's formula
 */
 
public class EstimatePI {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("1: Pi Estimator\n2: Quit");
            int choice = input.nextInt();
            switch(choice){
                case 1:
                    System.out.println("How many iterations?");
                    int num = input.nextInt(), denominator = 3;
                    double pi = 1;
                    for(int i = 0; i < num; i++){
                        pi -= 1.0/denominator;
                        denominator += 2;
                        pi += 1.0/denominator;
                        denominator += 2;
                        System.out.println("Iteration " + i + "\tEstimate = " + pi*4);
                    }
                    System.out.println("");
                    break;
                case 2:
                    System.exit(0);
                    break;
            }
        }
    }
}