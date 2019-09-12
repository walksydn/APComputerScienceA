
import java.util.Scanner;

/**
 * Author: Sydney Walker 
 * Period: 9 
 * Class: TidbitStore.java 
 * Purpose: Calculates payment plan based off of cost, down payment, and annual interest
 */
public class TidbitStore {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double price = 0, annualInterest = 0, downPercent = 0, interest = 0, principal = 0, totalInterest = 0, balance = 0;
        while (true) {
            System.out.println("Please enter the cost of your computer.");
            price = input.nextDouble();
            System.out.println("Enter your percent annual interest");
            annualInterest = input.nextDouble();
            System.out.println("Enter your percent down.");
            downPercent = input.nextDouble();
            double downPayment = price * (downPercent / 100);   //calculate the downpayment
            downPayment *= 100;
            downPayment = (int) downPayment;
            downPayment /= 100;
            price -= downPayment;
            double monthlyInterest = (annualInterest / 100) / 12;   //calculates the monthly interest (in decimal form, not percent)
            double payment = price * 0.05;  //the monthly payment is 5% of the total cost (not including the downpayment)
            balance = price;
            System.out.format("%10s%18s%15s%15s%15s%18s%n", "Month", "Balance Start", "Interest", "Pricipal", "Payment", "Balance End");
            for (int i = 1; balance > 0; i++) {
                    interest = price * monthlyInterest; //calculates the interest based off of the remainding total each month
                    principal = payment - interest; //calculates the amount of item cost left after the payment (doesn't include interest)
                    balance = price - principal;    //calculates the balance of the item cost left
                    if(balance < 0){    //if it is the last month the remainder of the balance is paid (with tax)
                        balance += principal;
                        principal = balance;
                        interest = principal*monthlyInterest;
                        payment = principal + interest;
                        balance = 0;
                    }
                    totalInterest += interest;
                    System.out.format("%10d%18.2f%15.2f%15.2f%15.2f%18.2f%n", i, price, interest, principal, payment, balance); //formats and prints
                    price = balance;                    
            }
            System.out.format("%10s%10.2f%n", "Total Interest Paid: ", totalInterest);
            totalInterest = 0;
        }
    }
}
