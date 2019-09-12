
/**
 * Author:  Sydney Walker
 * Period:  9
 * Class:   PythaoreanTriples.java
 * Purpose: identify the triples between two years inputed by the user
 */

import java.util.ArrayList;
import java.util.Scanner;

public class PythaoreanTriples {

    static int startYear = 0, endYear = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> output = new ArrayList<>();
        int numberTrips = 0;
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
            System.out.println("Please enter the years you want to analyze.");
            startYear = input.nextInt();
            endYear = input.nextInt();
            for (int year = startYear; year < endYear; year++) {
                int tripYear = year % 100;    //tripYear = year used in triples, stores the last two digits of the current year
                for (int month = 0; month < 12; month++) {
                    for (int day = 1; day <= numDays[month]; day++) {
                        if (Math.pow(day, 2) + Math.pow(month + 1, 2) == Math.pow(tripYear, 2)) {
                            output.add((month + 1) + "-" + day + "-" + tripYear + " (" + year + ")");
                            numberTrips++;
                        }
                    }
                }
            }
            System.out.println(numberTrips);
            for(int i = 0; i < numberTrips; i++){
                System.out.println(output.get(i));
            }
            output.clear();
            numberTrips = 0;
        }
    }
}
