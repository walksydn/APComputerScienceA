
import java.util.Scanner;

/**
 * Author: Sydney Walker Period: 9 Class: Cal.java Purpose:
 */
public class Cal {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int dayOne = 0, daysInMonth = 0, dayOfWeek = 0;
        while (true) {
            System.out.println("What day is the first day of the month? -1 to quit, 0 for Monday, 1 for Tuesday, 2 for Wednesday, 3 for Thursday, 4 for Friday, 5 for Saturday, 6 for Sunday");
            int temp = input.nextInt();
            if (temp == -1) {
                System.exit(0);
            } else {
                dayOne = temp;
                dayOfWeek = dayOne;
            }
            System.out.println("How many days are in the month?");
            daysInMonth = input.nextInt();
            System.out.println("M\tT\tW\tT\tF\tS\tSu");
            for(int tabs = 0; tabs < dayOne; tabs++){
                System.out.print("\t");                
            }
            System.out.print("1");
            dayOfWeek++;
            for(int day = 2; day <= daysInMonth; day++){
                if(dayOfWeek < 7){
                    System.out.print("\t" + day);
                    dayOfWeek++;
                } else {
                    System.out.print("\n" + day);
                    dayOfWeek = 1;
                }
            }
            System.out.println("");
        }
    }
}
