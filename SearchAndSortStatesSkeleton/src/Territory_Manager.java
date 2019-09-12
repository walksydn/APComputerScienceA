
/**
 * ---------------------------------------------------------------------------
 * S-h-e-n-e-n-d-e-h-o-w-a--H-i-g-h--S-c-h-o-o-l--T-e-c-h-n-o-l-o-g-y--D-e-p-t
 * ---------------------------------------------------------------------------
 * FILE: Territory_Manager.java
 *
 * DATE:  Mar 24, 2017
 *
 * PURPOSE: Class to manage an array of territories, allows searching and
 *          sorting.  Show sequential, binary searches and selection,
 *          insertion and merge sorts.  Also, bubble sort
 *
 * @author mr Hanley
 * @version 1.0
 * ---------------------------------------------------------------------------
 *
 * h-a-n-l-e-y.c-o-.-n-r------t-e-a-m-2-0-.-c-o-m-----------------------------
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.StringTokenizer;

public class Territory_Manager {

    private Territory[] list = new Territory[1];  //A list of different types of territories, 
    //states or cities
    ////////////////////////////////////////////////////////////////// 
    //////////////      C O N S T R U C T O R S      /////////////////   
    //////////////////////////////////////////////////////////////////

    public Territory_Manager(String filename) throws IOException {
        //Try to open this file
        BufferedReader br = new BufferedReader(new FileReader(filename));
        ArrayList<Territory> temp = new ArrayList<Territory>();

        //Do some reading of da file...
        String line = br.readLine();
        while (line != null) {
            Territory t = new Territory();
            StringTokenizer st = new StringTokenizer(line, ",");
            t.name = st.nextToken();
            //get rid of the commas
            t.pop = Integer.parseInt(st.nextToken().replaceAll("\"", ""));
            temp.add(t);
            line = br.readLine();  //go fetch next line of text file
        }
        list = new Territory[temp.size()];  //allocate an array of the right size
        list = temp.toArray(list);  //force the arraylist into an array
    }
    public Territory_Manager(String filename, String format) throws IOException {
        //Try to open this file
        BufferedReader br = new BufferedReader(new FileReader(filename));
        ArrayList<Territory> temp = new ArrayList<Territory>();

        switch (format) {
            case "StatesAndPops":
                //Do some reading of da file...
                String line = br.readLine();
                while (line != null) {
                    Territory t = new Territory();
                    StringTokenizer st = new StringTokenizer(line, ",");
                    t.name = st.nextToken();
                    //get rid of the commas
                    t.pop = Integer.parseInt(st.nextToken().replaceAll("\"", ""));
                    temp.add(t);
                    line = br.readLine();  //go fetch next line of text file
                }
                break;
            case "CitiesStatesAndPops":
                //Do some reading of da file...
                line = br.readLine();
                while (line != null) {
                    Territory t = new Territory();
                    //StringTokenizer st = new StringTokenizer(line, ",");
                    //Find the first comma
                    int firstComma = line.indexOf(",");
                    //Grab the city name
                    t.name = line.substring(0, firstComma).trim();
                    //Find the second comma, we will ignore the state
                    int secondComma = line.indexOf(",", firstComma + 1);
                    //The population starts after the 2nd comma
                    String tempPop = line.substring(secondComma + 1);
                    //Strip the ""
                    tempPop = tempPop.replaceAll("\"", "");
                    //Strip the commas
                    tempPop = tempPop.replaceAll(",", "");

                    try {
                        t.pop = Integer.parseInt(tempPop);
                    } catch (NumberFormatException e) {
                        System.out.println("Here is the line " + line);
                    }
                    temp.add(t);
                    line = br.readLine();
                }
        }
        list = new Territory[temp.size()];  //allocate an array of the right size
        list = temp.toArray(list);  //force the arraylist into an array
    }


    //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    //AAAAAAAAAAAAAAAAAAAAA  A C C E S S O R S  AAAAAAAAAAAAAAAAAAAAAAA
    //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    public Territory[] getList() {
        return list;
    }
    //MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
    //MMMMMMMMMMMMMMM  S O R T I N G  A L G O S  MMMMMMMMMMMMMMMMMMMMMM
    //MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM

    /**
     * ================================================================ public
     * SortResult bubbleSort(String byWhat)
     *
     * @param byWhat "name" or "pop" depending on what criteria to sort by
     * @return SortResult with the number of comparisons, swaps and the time
     * Borrowed without permission:
     * https://mathbits.com/MathBits/Java/arrays/Bubble.htm
     * ================================================================
     */
    public SortResult bubbleSort(String byWhat) {
        //Method for comparing depends upon byWhat
        Comparator sorter = null;
        if (byWhat.equals("name")) {
            sorter = new AlphaComparator();
        } else {
            sorter = null;  //you got to add your PopulationComparator
        }
        //Report results via a SortResult
        SortResult sr = new SortResult();
        sr.comparisons = sr.swaps = 0;

        Territory temp = null;  //Use this to swap

        int j; //inner loop does its thang....

        boolean flag = true;   // set flag to true to begin first pass
        //if flag is false, there were no comparisons
        //so we can stop bubble sorting,must be in order

        while (flag) {
            flag = false;    //set flag to false awaiting a possible swap
            for (j = 0; j < list.length - 1; j++) {
                sr.comparisons++;
                if (sorter.compare(list[j], list[j + 1]) > 0) // change to > for ascending sort
                {
                    sr.swaps++;
                    temp = list[j];                //swap elements
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    flag = true;              //shows a swap occurred  
                }
            }
        }
        return sr;
    }

    public SortResult sequentialSearch(String name) {
        SortResult sr = new SortResult();
        DecimalFormat df = new DecimalFormat("###,###,000");
        sr.comparisons = sr.swaps = 0;
        ArrayList<Territory> cities = new ArrayList<>();
        for (Territory t : list) {
            sr.comparisons++;
            if (name.equals(t.name)) {
                cities.add(t);
            }
        }
        for (Territory t : cities) {
            String n = t.name;
            if (t.name.length() > 24) {
                n = n.substring(0, 24) + "*";
            }
            String pop = df.format(t.pop);
            System.out.format("%-25s%20s\n", t.name, pop);
        }
        return sr;
    }

    public SortResult sequentialSearch(int pop) {
        SortResult sr = new SortResult();
        DecimalFormat df = new DecimalFormat("###,###,000");
        sr.comparisons = sr.swaps = 0;
        ArrayList<Territory> cities = new ArrayList<>();
        for (Territory t : list) {
            sr.comparisons++;
            if (pop == t.pop) {
                cities.add(t);
            }
        }
        for (Territory t : cities) {
            String n = t.name;
            if (t.name.length() > 24) {
                n = n.substring(0, 24) + "*";
            }
            String p = df.format(t.pop);
            System.out.format("%-25s%20s\n", t.name, p);
        }
        return sr;
    }

    public void randomize() {
        Random r = new Random();
        for (int x = 0; x < 1000; x++) {
            for (int i = 0; i < list.length; i++) {
                int index = r.nextInt(list.length);
                Territory temp = list[i];
                list[i] = list[index];
                list[index] = temp;
            }
        }
    }

    public SortResult selectionSortByName() {
        SortResult sr = new SortResult();
        sr.comparisons = sr.swaps = 0;
        for (int i = 0; i < list.length; i++) {
            Territory smallT = list[i];
            int smallIndex = i;
            for (int r = i; r < list.length; r++) {
                sr.comparisons++;
                if (list[r].name.compareTo(smallT.name) < 0) {
                    sr.swaps++;
                    smallT = list[r];
                    smallIndex = r;
                }
            }
            Territory temp = list[i];
            list[i] = list[smallIndex];
            list[smallIndex] = temp;
        }
        return sr;
    }

    public SortResult selectionSortByPop(boolean increasing) {
        SortResult sr = new SortResult();
        sr.comparisons = sr.swaps = 0;
        for (int i = 0; i < list.length; i++) {
            Territory smallT = list[i];
            int smallIndex = i;
            for (int r = i; r < list.length; r++) {
                sr.comparisons++;
                if (increasing && list[r].pop < smallT.pop) {
                    sr.swaps++;
                    smallT = list[r];
                    smallIndex = r;
                } else if (!increasing && list[r].pop > smallT.pop) {
                    sr.swaps++;
                    smallT = list[r];
                    smallIndex = r;
                }
            }
            Territory temp = list[i];
            list[i] = list[smallIndex];
            list[smallIndex] = temp;
        }
        return sr;
    }

    public SortResult insertionSortByName() {
        SortResult sr = new SortResult();
        sr.comparisons = sr.swaps = 0;
        for (int i = 0; i < list.length; i++) {
            for (int r = i; r > -1; r--) {
                sr.comparisons++;
                if (list[i].name.compareTo(list[r].name) < 0) {
                    sr.swaps++;
                    Territory temp = list[r];
                    list[r] = list[i];
                    list[r + 1] = temp;
                    for (int x = r + 1; x < list.length; x++) {
                        temp = list[x];
                        list[x - 1] = list[x];
                        list[x - 1] = temp;
                    }
                }
            }
        }
        return sr;
    }

    public void insertionSortByPop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void mergeSortByName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void mergeSortByPop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Territory verifyOrder(boolean byName) {
        for(int i = 1; i < list.length; i++){
            if(byName && list[i-1].name.compareTo(list[i].name) > 0){
                return list[i-1];
            } else if(!byName && list[i-1].pop > list[i].pop){
                return list[i-1];
            }
        }
        return null;
    }
}
