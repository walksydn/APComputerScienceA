/**
 * Author: Sydney Walker 
 * Period: 9 
 * Class: BagelTest.java 
 * Purpose: prints bagels according to entered specifications
 */
package bageltest;

import java.util.Scanner;

public class BagelTest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("Please enter number of bagels >0, -1 to quit");
            int numBagels = input.nextInt();
            if(numBagels == -1){
                System.exit(0);
            }
            System.out.println("Please enter hill limit (1-15)");
            int hillLimit = input.nextInt();
            System.out.println("Please enter bad bagel frequency (>0)");
            int badFreq = input.nextInt();
            boolean ascending = true;
            System.out.println("");
            int bagelsInLine = 0;
            int bagelsPrinted = 0;
            int nextRow = 0;
            String line = "";
            while(true){
                if(bagelsPrinted+nextRow > numBagels){
                    for(int i = 0; i < nextRow; i++){
                        if(bagelsPrinted%badFreq == 0){
                                line += "#";
                                bagelsPrinted++;
                                bagelsInLine++;
                        } else {
                            line += "O";
                            bagelsPrinted++;
                            bagelsInLine++;                            
                        }
                        String x = Integer.toHexString(bagelsInLine);
                        System.out.println(x + "    " + line);
                    }
                    break;
                }
                if(ascending){
                    for(int i = 0; i < hillLimit; i++){
                        for(int j = hillLimit-i; j < hillLimit+1; j++){
                            if(bagelsPrinted%badFreq == 0){
                                line += "#";
                                bagelsPrinted++;
                                bagelsInLine++;
                            } else {
                                line += "O";
                                bagelsPrinted++;
                                bagelsInLine++;                            
                            }
                        }
                        String x = Integer.toHexString(bagelsInLine);
                        System.out.println(x + "    " + line);
                        nextRow = bagelsInLine+1;
                        bagelsInLine = 0;
                        line = "";
                    }
                    ascending = false;
                } else {
                    for(int i = 0; i < hillLimit; i++){
                        for(int j = i; j < hillLimit+1; j++){
                            if(bagelsPrinted%badFreq == 0){
                                line += "#";
                                bagelsPrinted++;
                                bagelsInLine++;
                            } else {
                                line += "O";
                                bagelsPrinted++;
                                bagelsInLine++;                            
                            }
                        }
                        String x = Integer.toHexString(bagelsInLine);
                        System.out.println(x + "    " + line);
                        nextRow = bagelsInLine-1;
                        bagelsInLine = 0;
                        line = "";
                    }
                    ascending = true;                
                }
            }
        }
    }    
}