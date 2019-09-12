import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
 
/**
 * Author: Sydney Walker 
 * Period: 9 
 * Class: CollegeManager.java 
 * Purpose: creates an ArrayList of colleges and manages it
 */
public class CollegeManager {
 
    static ArrayList<College> colleges = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
 
    public static void main(String[] args) {
        //runs the menu until user exits
        boolean saved = false;
        while (true) {
            System.out.println("0: Exit\n1: Read in Data From File\n2: Display List to the Console\n3: Sort List\n4: Edit a College\n5: Delete a College\n6: Add a College\n7: Save Your List\n");
            int choice = input.nextInt();
            switch (choice) {
                case 0:
                    if (!saved) {
                        System.out.println("Do you want to save first?\n0 = Yes, Please Save My List.\n1 = No, Leave Anyways.");
                        int n = input.nextInt();
                        if (n == 0) {
                            save();
                        }
                    }
                    archive();
                    System.exit(0);
                    break;
                case 1:
                    readFromFile();
                    saved = false;
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    Collections.sort(colleges);
                    saved = false;
                    break;
                case 4:
                    edit();
                    saved = false;
                    break;
                case 5:
                    delete();
                    saved = false;
                    break;
                case 6:
                    add();
                    saved = false;
                    break;
                case 7:
                    save();
                    archive();
                    saved = true;
                    break;
            }
        }
    }
 
    //reads from Colleges.txt and puts those colleges into the list
    static private void readFromFile() {
        File f = new File("Colleges.txt"); //create and initialize a file
        Scanner fileInput = null; //create a scanner
        try {
            fileInput = new Scanner(f); //initialize the path of the scanner to the file
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        }
        while (fileInput.hasNext()) { //check that there is another line in the .txt file
            String temp = fileInput.nextLine(); //get next line of file
            String[] in = temp.split(";"); //split the file into needed parts
            //create a college based off of data gotten from file
            colleges.add(new College(in[0], in[1], Double.parseDouble(in[2]), Integer.parseInt(in[3]), Integer.parseInt(in[4]), Integer.parseInt(in[5])));
        }
    }
 
    //displays all of the colleges and their statistics in a list
    static private void display() {
        System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s%n", "Name", "Region", "Average GPA", "Average SAT", "Number Students", "Rating");
        for (int i = 0; i < colleges.size(); i++) {
            System.out.print(colleges.get(i).toString());
        }
    }
 
    //saves the list of colleges to Colleges.txt
    static private void save() {
        PrintWriter saveStream = null;
        try {
            saveStream = new PrintWriter("Colleges.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        }
        for (int i = 0; i < colleges.size(); i++) {
            saveStream.println(colleges.get(i).getName() + ";" + colleges.get(i).getRegion() + ";" + colleges.get(i).getAverageGPA() + ";" + colleges.get(i).getAverageSAT()
                    + ";" + colleges.get(i).getNumStudents() + ";" + colleges.get(i).getRating());
        }
        saveStream.close();
    }
 
    //prints the list of colleges to CollegesArchive.txt
    static private void archive() {
        PrintWriter archiveStream = null;
        try {
            archiveStream = new PrintWriter("CollegesArchive.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        }
        for (int i = 0; i < colleges.size(); i++) {
            archiveStream.println(colleges.get(i).getName() + ";" + colleges.get(i).getRegion() + ";" + colleges.get(i).getAverageGPA() + ";" + colleges.get(i).getAverageSAT()
                    + ";" + colleges.get(i).getNumStudents() + ";" + colleges.get(i).getRating());
        }
        archiveStream.close();
    }
 
    //allows user to select a college and edit one of its aspects
    static private void edit() {
        System.out.println("Which college do you want to edit?");
        listColleges();
        int college = input.nextInt();
        System.out.println("Which aspect do you want to edit?");
        System.out.println("1: Name\n2: Region\n3: Average GPA\n4: Average SAT Score\n5: Number of Students\n6: Rating");
        int aspect = input.nextInt();
        switch (aspect) {
            case 1:
                input.skip("\n");
                System.out.println("What is the new name?");
                String name = input.nextLine();
                colleges.get(college).setName(name);
                break;
            case 2:
                input.skip("\n");
                System.out.println("What is the new region?");
                String region = input.nextLine();
                colleges.get(college).setRegion(region);
                break;
            case 3:
                System.out.println("What is the new average GPA?");
                double GPA = input.nextDouble();
                colleges.get(college).setAverageGPA(GPA);
                break;
            case 4:
                System.out.println("What is the new average SAT?");
                int SAT = input.nextInt();
                colleges.get(college).setAverageSAT(SAT);
                break;
            case 5:
                System.out.println("What is the new number of students?");
                int students = input.nextInt();
                colleges.get(college).setNumStudents(students);
                break;
            case 6:
                System.out.println("What is the new rating?");
                int rating = input.nextInt();
                colleges.get(college).setRating(rating);
                break;
        }
    }
 
    //creates a new college and adds it to the list
    static private void add() {
        input.skip("\n");
        System.out.println("What is the new name?");
        String name = input.nextLine();
        input.skip("\n");
        System.out.println("What is the new region?");
        String region = input.nextLine();
        System.out.println("What is the new average GPA?");
        double GPA = input.nextDouble();
        System.out.println("What is the new average SAT?");
        int SAT = input.nextInt();
        System.out.println("What is the new number of students?");
        int students = input.nextInt();
        System.out.println("What is the new rating?");
        int rating = input.nextInt();
        colleges.add(new College(name, region, GPA, SAT, students, rating));
    }
 
    //removes a college from the list
    static private void delete() {
        System.out.println("Which college do you want to delete?");
        listColleges();
        int n = input.nextInt();
        colleges.remove(n);
    }
 
    //lists the colleges on the console
    static private void listColleges() {
        for (int i = 0; i < colleges.size(); i++) {
            System.out.println(i + ": " + colleges.get(i).getName());
        }
    }
 
}