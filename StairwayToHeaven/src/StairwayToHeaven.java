
import java.util.Scanner;

/**
 * Author: Sydney Walker 
 * Period: 9 
 * Class: StairwayToHeaven.java 
 * Purpose: Create a staircase of the size specified by the user
 */
public class StairwayToHeaven {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter the size of your staircase.");
            int size = input.nextInt();
//            System.out.println("Enter the three digits you would like in you boxes. ");
//            String boxText = input.next();
            int totalRows = size * 2 + 1;
            int totalLength = size * 4, boxRow = 1, row = 1;
            int leadingSpaces = 0, boxes = 0;
            for (int l = 0; l < totalRows; l++) {   //loops the total amount of rows
                if (l % 2 == 0) {   //determines if the number of leading spaces/boxes need to be changed
                    if (!(row == totalRows)) {  //number of leading spaces and boxes do not change for the last row
                        boxes++;
                        leadingSpaces = totalLength - (boxes * 4);
                        boxRow++;
                    }
                    for (int i = 0; i < leadingSpaces; i++) {//prints the number of leading spaces for the row
                        System.out.print(" ");
                        }
                    for (int i = 0; i < boxes; i++) {//prints the number of boxes for the row
                        System.out.print("+---");
                    }
                    System.out.println("+");//prints the final + and move onto the next line
                } else {
                    for (int i = 0; i < leadingSpaces; i++) {//prints the number of leading spaces for the row
                        System.out.print(" ");
                    }
                    for (int i = 0; i < boxes; i++) {//prints the number of box sides for the row
                        System.out.print("|   ");
                    }
                    System.out.println("|");//prints the final box side and moves onto the next line
                }
                row++;
            }
        }
    }
}
