
import java.io.File;
import java.util.Scanner;

/**
 * Author:  Sydney Walker
 * Period:  9
 * Class:   AppHangman.java
 * Purpose: runs a hangman application
 */

public class AppHangman {
    public static void main(String[] args) {
        Scanner txtFile = null;
        Hangman hang = new Hangman();
        try{
            txtFile = new Scanner(new File("hangmanValues.txt"));        
        } catch (Exception e){
            System.out.println("File Not Found");
        }
        while(txtFile.hasNext()){
            hang.addAnswer(txtFile.nextLine());
        }
        hang.selectAnswer();
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println(hang.getMan());
            System.out.println("You have " + (6-hang.getNumWrong()) + " incorrect guesses left.");
            System.out.println(hang);
            System.out.println("What letter would you like to guess?");
            String guess = input.nextLine();
            if(hang.guessALetter(guess)){
                System.out.println(hang);
                System.out.println("You Win!!!");
                hang.reset();
                if(!hang.selectAnswer()){
                    System.out.println("All out of answers!");
                    System.exit(0);
                }
            }
            if(hang.getNumWrong() >= 6){
                System.out.println(hang.getMan());
                System.out.println("You Lost.");
                System.out.println("New Word!");
                hang.reset();
                if(!hang.selectAnswer()){
                    System.out.println("All out of answers!");
                    System.exit(0);
                }
            }
        }
    }
}
