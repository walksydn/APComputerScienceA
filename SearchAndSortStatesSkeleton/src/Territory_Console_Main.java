
/**
 * ---------------------------------------------------------------------------
 * S-h-e-n-e-n-d-e-h-o-w-a--H-i-g-h--S-c-h-o-o-l--T-e-c-h-n-o-l-o-g-y--D-e-p-t
 * ---------------------------------------------------------------------------
 * FILE: Territory_Console_Main.java
 *
 * DATE:  Mar 24, 2017
 *
 * PURPOSE: Provide a menu and drive the searching and sorting of states
 *          and cities
 *
 * @author mr Hanley
 * @version 1.0
 * ---------------------------------------------------------------------------
 *
 * h-a-n-l-e-y.c-o-.-n-r------t-e-a-m-2-0-.-c-o-m-----------------------------
 */
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Territory_Console_Main {

    public static void main(String[] args) {
        String currFile = "states and territories with 2012 populations.csv";
        Territory_Manager tm = null;
        try {
            tm = new Territory_Manager(currFile);
        } catch (IOException ex) {
            Logger.getLogger(Territory_Console_Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("\t*************************************************");
            System.out.println("\t ***********************************************");
            System.out.println("\t  **         SEARCHING N SORTING             **");
            System.out.println("\t  **      SPONSORED BY HANLEYS HOOD          **");
            System.out.println("\t **------------------------------------------**");
            System.out.println("\t **   0 = Quit                                **");
            System.out.println("\t **   1 = Load Different Data                 **");
            System.out.println("\t **   2 = Display                             **");
            System.out.println("\t **   3 = Sequential Search (not sorted OK)   **");
            System.out.println("\t **   4 = Binary Search (must be sorted)      **");
            System.out.println("\t **   5 = Bin Search Recursive(must be sorted)**");
            System.out.println("\t **   6 = Bubble Sort by Name                 **");
            System.out.println("\t **   7 = Selection Sort by Name              **");
            System.out.println("\t **   8 = Selection Sort by Population        **");
            System.out.println("\t **   9 = Insertion Sort by Name              **");
            System.out.println("\t **  10 = Insertion Sort by Population        **");
            System.out.println("\t **  11 = Merge Sort by Name                  **");
            System.out.println("\t **  12 = Merge Sort by Population            **");
            System.out.println("\t **  13 = Learn about Sequential Search       **");
            System.out.println("\t **  14 = Learn about Binary Search           **");
            System.out.println("\t **  15 = Learn about Selection Sort          **");
            System.out.println("\t **  16 = Learn about Insertion Sort          **");
            System.out.println("\t **  17 = Learn about Merge Sort              **");
            System.out.println("\t **  18 = Scrambled Eggs                      **");
            System.out.println("\t **  19 = Verify Order                        **");
            System.out.println("\t **  20 = Load 5,000 cities and pops          **");
            System.out.println("\t **  21 = BONUS, Seq Search on Partial Name   **");
            System.out.println("\t  **                                         **");
            System.out.println("\t ***********************************************");
            System.out.println("\t*************************************************");
            int choice = input.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("Goodbye");
                    System.exit(0);
                case 1:
                    System.out.println("What file to load?");
                    break;
                case 2:
                    DecimalFormat df = new DecimalFormat("###,###,000");
                    Territory[] temp = tm.getList();
                    System.out.format("%-25s%20s\n", "Territory", "Population");
                    System.out.println("-----------------------------------------------");
                    for (Territory t : temp) {
                        String name = t.name;
                        if (t.name.length() > 24) {
                            name = name.substring(0, 24) + "*";
                        }
                        String pop = df.format(t.pop);
                        System.out.format("%-25s%20s\n", t.name, pop);
                    }
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("Enter 0 to sort by name or 1 to sort by population");
                    int ch = input.nextInt();
                    SortResult sortRe = new SortResult();
                    switch(ch){
                        case 0:
                            input.nextLine();
                            System.out.println("What city are you searching for?");
                            String name = input.nextLine();
                            sortRe = tm.sequentialSearch(name);
                            break;
                        case 1:
                            System.out.println("What population are you searching for?");
                            int pop = input.nextInt();
                            sortRe = tm.sequentialSearch(pop);
                            break;
                    }
                    System.out.println("___________________________");
                    System.out.println("|   comparisons :"+sortRe.comparisons+"    |");
                    System.out.println("___________________________");
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_");
                    System.out.println("_+_+_+_+_+_+_  Bubble Sorting Dude(ette)  _+_+_+_+_+_");
                    System.out.println("_+_+_+_+_+_+_  Cross your fingers!!!!!!!!!_+_+_+_+_+_");
                    System.out.println("_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_");
                    System.out.println("Cross your fingers!!!!!!!!!!!!");
                    SortResult sr = tm.bubbleSort("name");
                    System.out.println("___________________________");
                    System.out.println("|   comparisons :"+sr.comparisons+"    |");
                    System.out.println("|        swaps  :"+sr.swaps+"          |");
                    System.out.println("___________________________");
                    break;
                case 7:
                    SortResult result = tm.selectionSortByName();
                    System.out.println("___________________________");
                    System.out.println("|   comparisons :"+result.comparisons+"    |");
                    System.out.println("|        swaps  :"+result.swaps+"          |");
                    System.out.println("___________________________");
                    break;
                case 8:
                    System.out.println("Would you like an increasing or decreasing population sort?");
                    System.out.println("0: Increasing Order");
                    System.out.println("1: Decreasing Order");
                    int in = input.nextInt();
                    SortResult r = null;
                    if(in == 0){
                        r = tm.selectionSortByPop(true);                        
                    } else {
                        r = tm.selectionSortByPop(false);
                    }
                    System.out.println("___________________________");
                    System.out.println("|   comparisons :"+r.comparisons+"    |");
                    System.out.println("|        swaps  :"+r.swaps+"          |");
                    System.out.println("___________________________");
                    break;
                case 9:
                    SortResult sr1 = tm.insertionSortByName();
                    System.out.println("___________________________");
                    System.out.println("|   comparisons :"+sr1.comparisons+"    |");
                    System.out.println("|        swaps  :"+sr1.swaps+"          |");
                    System.out.println("___________________________");                    
                    break;
                case 10:
                    tm.insertionSortByPop();
                    break;
                case 11:
                    tm.mergeSortByName();
                    break;
                case 12:
                    tm.mergeSortByPop();
                    break;
                case 13:
                    System.out.println("Selection Search: ");
                    //TODO insert paragraph
                    break;
                case 14:
                    System.out.println("Binary Search: ");
                    //TODO insert paragraph
                case 15:
                    System.out.println("Selection Sort: ");
                    //TODO insert paragraph
                case 16:
                    System.out.println("Insertion Sort: ");
                    //TODO insert paragraph
                case 17:
                    System.out.println("Merge Sort: ");
                    //TODO insert paragraph
                case 18:
                    tm.randomize();
                    break;
                case 19:
                    System.out.println("0: Verify By Name\n1: Verify By Population");
                    int d = input.nextInt();
                    Territory t = null;
                    switch(d){
                        case 0:
                            t = tm.verifyOrder(true);
                            break;
                        case 1: 
                            t = tm.verifyOrder(false);
                            break;
                    }
                    if(t != null){
                        System.out.println(t.name + "\t\t" + t.pop);                        
                    } else {
                        System.out.println("It's in order!");
                    }
                    break;
                case 20:
                    try{
                        tm = new Territory_Manager("Top5000Population", "StatesAndPops");
                    } catch(Exception e){
                        System.out.println(e);
                    }
                    break;
                default:
                    System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                    System.out.println("%         NOT A THING!!                     %");
                    System.out.println("%         DO YOU WANT TO GET RICK ROLLED??  %");
                    System.out.println("%                                           %");
                    System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                    break;
            }
        }
    }

}
