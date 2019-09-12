import java.io.File;
import java.util.Scanner;

/**
 * Author:  Sydney Walker
 * Period:  9
 * Class:   Tester.java
 * Purpose: creates a ConnectBoard
 */

public class Tester {
    public static void main(String[] args) {
        ConnectBoard board = new ConnectBoard();
//        Scanner input = new Scanner(System.in);
        Scanner input = null;
        try{
            input = new Scanner(new File("test4.txt"));        
        }catch(Exception e){
            System.out.println(e.toString());
        }
        while(true){
//            System.out.println("Where would you like to drop your piece?");
            int col = 0;
            if(input.hasNextInt()){
                col = input.nextInt();
                if(col == -1){
                    System.exit(0);
                }                
            }
//            col = input.nextInt();
            board.dropPiece(col);
            System.out.println(board);
            int win = board.checkWin(col);
            switch(win){
                case 0:
                    System.out.println("It's a tie.");
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Player 2 Won!!!");
                    System.exit(0);
                    break;
                case 2:
                    System.out.println("Player 1 Won!!!");
                    System.exit(0);
                    break;                    
            }
        }
    }
}