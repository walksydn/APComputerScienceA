
import java.util.Scanner;

/**
 * Author: Sydney Walker Period: 9 Class: BonusCal.java Purpose:
 */
public class BonusCal {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int dayOne = 0, month = 0, dayOfWeek = 0, numMonths = 0;
        int[] numDays = new int[12];    //stores the number of days in each month
        numDays[0] = 31;
        numDays[1] = 28;
        numDays[2] = 31;
        numDays[3] = 30;
        numDays[4] = 31;
        numDays[5] = 30;
        numDays[6] = 31;
        numDays[7] = 31;
        numDays[8] = 30;
        numDays[9] = 31;
        numDays[10] = 30;
        numDays[11] = 31;
        while (true) {
            System.out.println("What day is the first day of the month? -1 to quit, 0 for Monday, 1 for Tuesday, 2 for Wednesday, 3 for Thursday, 4 for Friday, 5 for Saturday, 6 for Sunday");
            int temp = input.nextInt();
            if (temp == -1) {
                System.exit(0);
            } else {
                dayOne = temp;
                dayOfWeek = dayOne;
            }
            System.out.println("What month is it? 0 for Jan, 1 for Feb, etc.");
            month = input.nextInt();
            System.out.println("Is it a leap year? 0 for no, 1 for yes");
            int leap = input.nextInt();
            if(leap == 1){
                numDays[1] = 29;
            }
            dayOne(dayOfWeek, month);
            for (int months = 0; months < 12; months++) {
                for (int day = 2; day <= numDays[month]; day++) {
                    if (dayOfWeek < 7) {
                        System.out.print("\t" + day);
                        dayOfWeek++;
                    } else {
                        System.out.print("\n" + day);
                        dayOfWeek = 1;
                    }
                }
                System.out.println("");
                month++;
                dayOne(dayOfWeek, month); dayOfWeek++;
            }
        }
    }

    public static void dayOne(int weekDay, int month) {
        System.out.println(month);
        System.out.println("M\tT\tW\tT\tF\tS\tSu");
        for (int tabs = 0; tabs < weekDay; tabs++) {
            System.out.print("\t");
        }
        System.out.print("1");
    }
}
