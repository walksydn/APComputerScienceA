/**
 * Author: Sydney Walker
 * Period: 9
 * Class: ArrayPractice_Copying_Skeleton.java
 * Purpose: practice using three arrays
 */

import java.util.Date;
import java.util.Scanner;

public class ArrayPractice_Copying_Skeleton {

    static final char ur = '\u2557';
    static final char ul = '\u2554';
    static final char top = '\u2550';
    static final char side = '\u2551';
    static final char sideTL = '\u2560';
    static final char sideRL = '\u2563';
    static final char bl = '\u255A';
    static final char br = '\u255D';
    static final char one = '\u2776';
    static final char two = '\u2777';
    static final char thr = '\u2778';
    static final char fou = '\u2779';
    static final char fiv = '\u277A';
    static final char six = '\u277B';
    static final char sev = '\u277C';
    static final char eig = '\u277D';
    //----------------------------------------------------------------
    //---------------- G L O B A L  V A R I A B L E S ------------
    //----------------------------------------------------------------

    final int SIZE = 15;
    Scanner input = new Scanner(System.in);
    String[] tryList = new String[SIZE];
    String[] tried = new String[SIZE];
    String[] no = new String[SIZE];

    public static void main(String[] args) {
        ArrayPractice_Copying_Skeleton es = new ArrayPractice_Copying_Skeleton();  //invoke constructor
    }

    /**
     *
     * @param text give me a text expression
     * @param totalLength total length of String to be filled
     * @return a String of spaces to "pad" the region where len =
     * total.len-text.len
     */
    public String padding(String text, int totalLength) {
        int difference = totalLength - text.length();
        if (difference > 0) {

            for (int i = 0; i < difference; i++) {
                text += " ";
            }
        }
        return text;
    }

    public ArrayPractice_Copying_Skeleton() {
        menu();
    }

    public void menu() {

        while (true) {
            Date now = new Date();
            System.out.print("\t\t" + ul);
            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //_________________________________________");
            System.out.println(ur);
            System.out.println("\t\t" + side + "     ***    Array Copying Menu    ***    " + side);
            System.out.print("\t\t" + sideTL);

            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //_________________________________________
            System.out.println(sideRL);
            System.out.println("\t\t" + side + "        " + one + " = Display Lists                " + side);
            System.out.println("\t\t" + side + "        " + two + " = Move from First List to 2nd  " + side);
            System.out.println("\t\t" + side + "        " + thr + " = Move from First List to 3rd  " + side);
            System.out.println("\t\t" + side + "        " + fou + " = Consolidate First List       " + side);
            System.out.println("\t\t" + side + "        " + fiv + " = Initialize                   " + side);
            System.out.println("\t\t" + side + "        " + six + " = Clear Tried List             " + side);
            System.out.println("\t\t" + side + "        " + sev + " = Add to Try List              " + side);
            System.out.println("\t\t" + side + "        " + eig + " = Exit                         " + side);
            System.out.println("\t\t" + side + "  Your Selection?                        " + side);
            System.out.print("\t\t" + bl);
            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //+"_________________________________________
            System.out.println(br);

            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    display();
                    break;
                case 2:
                    moveToTried();
                    break;
                case 3:
                    moveToNo();
                    break;
                case 4:
                    consolidate();
                    break;
                case 5:
                    initialize();
                    break;
                case 6:
                    clearTried();
                    break;
                case 7:
                    addTryList();
                    break;
                case 8:
                    System.exit(0);
            }
        }
    }

    public void display() {
        System.out.println("\tInterested----------Tried----------------Not going there!-----");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + "\t");
            if (tryList[i] == null || tryList[i].equals("")) {
                System.out.print(padding("{EMPTY}", 20));
            } else {
                System.out.print(padding(tryList[i], 20));
            }

            if (tried[i] == null || tried[i].equals("")) {
                System.out.print(padding("{EMPTY}", 20));
            } else {
                System.out.print(padding(tried[i], 20));
            }
            if (no[i] == null || no[i].equals("")) {
                System.out.print(padding("{EMPTY}", 20));
            } else {
                System.out.print(padding(no[i], 20));
            }
            System.out.println("");
        }
    }

    public void initialize() {
        tryList = new String[]{"Fish Eyes", "Frog Legs", "Alligator", "Sushi", "Buffalo",
            "Cow Tongue", "Shark", "Scrapple", "Cheese Steak", "Seaweed",
            "Vegeratian Korma", "Deep Fried Oreo", "ChickBacRanch Pizza", "Cavier", ""};

        tried = new String[]{"Rice and Beans", "Liver",
            "Paella", "Chicken", "Pizza", "", "", "", "", "", "", "", "", "", "", "", "", ""};

        no = new String[SIZE];
    }

    public void clearTried() {  //loop and set entire array to null
        for (int i = 0; i < SIZE; i++) {
            tried[i] = null;
        }
    }

    public void moveToTried() {
        System.out.println("Starting with which item?");
        int start = input.nextInt();
        System.out.println("Ending with which item?");
        int end = input.nextInt();
        int[] triedIndex = new int[SIZE];
        int w = 0;
        for (int i = 0; i < SIZE; i++) { //create array of empty indexes 
            if (tried[i] == null || tried[i].equals("")) {
                triedIndex[w] = i;
                w++;
            }
        }
        int m = 0;
        for (int i = start; i <= end; i++) {
            tried[triedIndex[m]] = tryList[i];//put items in empty try list spots
            tryList[i] = null;//takes out of try list
            m++;
        }
    }

    public void moveToNo() {
        System.out.println("Starting with which item?");
        int start = input.nextInt();
        System.out.println("Ending with which item?");
        int end = input.nextInt();
        int[] noIndex = new int[SIZE];
        int w = 0;
        for (int i = 0; i < SIZE; i++) { //create array of empty indexes 
            if (no[i] == null || no[i].equals("")) {
                noIndex[w] = i;
                w++;
            }
        }
        int m = 0;
        for (int i = start; i <= end; i++) {
            no[noIndex[m]] = tryList[i];//put items in empty try list spots
            tryList[i] = null;//takes out of try list
            m++;
        }
    }

    public void addTryList() {
        System.out.println("Please consolidate first");
        input.skip("\n");
        System.out.println("OK, what food to add");
        String word = input.nextLine();
        for (int i = 0; i < SIZE; i++) {//find lowest empty spot + puts there
            if (tryList[i] == null || tryList[i].equals("")) {
                tryList[i] = word;
                break;
            }
        }
    }

    public void consolidate() {
        String[] orig = new String[SIZE]; //copy array before consolidate
        for(int i = 0; i < SIZE; i++){
            orig[i] = tryList[i];
        }
        int[] fillIndex = new int[SIZE];
        int m = 0;
        for (int i = 0; i < SIZE; i++) {//create array of filled values
            if (!(orig[i] == null || orig[i].equals(""))) {
                fillIndex[m] = i;
                m++;
            }
        }
        for (int i = 0; i < SIZE; i++) {//move every existent value up
            tryList[i] = orig[fillIndex[i]];
        }
        for (int i = m; i < SIZE; i++) {//make needed places empty
            tryList[i] = null;
        }
    }
}
