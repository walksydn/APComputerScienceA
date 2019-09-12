import java.util.Scanner;
 
/**
 * Author: Sydney Walker 
 * Period: 9 
 * Class: CollegeAdmissionsTester.java 
 * Purpose: runs CollegeAdmissions class
 */
 
public class CollegeAdmissionsTester {
 
    public static void main(String[] args) {
        CollegeAdmissions admissions = new CollegeAdmissions();
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Would you like to...");
            System.out.println("1. Create a College \n2. Create a Student \n3. Display Colleges \n4. Display Students \n5. Remove a College \n"
                    + "6. Remove a Student \n7. Clear All Colleges \n8. Clear All Students \n9. Calculate Admissions Chances \n10. Exit Program");
            int which = input.nextInt();
            switch (which) {
                case 1:
                    input.skip("\n");
                    System.out.println("Enter the name of your college. ");
                    String name = input.nextLine();
                    System.out.println("Enter the minimum GPA of your college.");
                    double GPA = input.nextDouble();
                    System.out.println("Enter the minimum SAT score of your college. ");
                    int SAT = input.nextInt();
                    admissions.createCollege(name, GPA, SAT);
                    break;
                case 2:
                    input.skip("\n");
                    System.out.println("Enter the name of your student. ");
                    String aName = input.nextLine();
                    System.out.println("Enter the GPA of your student.");
                    double aGPA = input.nextDouble();
                    System.out.println("Enter the SAT score of your student. ");
                    int aSAT = input.nextInt();
                    System.out.println("Enter the amount of extra curriculars your student is involved in. ");
                    int numExCurr = input.nextInt();
                    admissions.createStudent(aName, aGPA, aSAT, numExCurr);
                    break;
                case 3:
                    System.out.println("Num\tName\t\t\tGPA\t\tSAT");
                    for(int i = 0; i < admissions.numColleges(); i++){
                        System.out.println(i+1 + "\t" + admissions.getCollegeNumber(i));
                    }
                    break;
                case 4: 
                    System.out.println("Num\tName\t\t\tGPA\t\tSAT\t\tNumber Extra Curriculars");
                    for(int i = 0; i < admissions.numStudents(); i++){
                        System.out.println(i+1 + "\t" + admissions.getStudentNumber(i));
                    }
                    break;
                case 5: 
                    System.out.println("Which college would you like to remove?");
                    int college = input.nextInt();
                    admissions.clearCollege(college);
                    break;
                case 6:
                    System.out.println("Which student would you like to remove?");
                    int student = input.nextInt();
                    admissions.clearStudent(student);
                    break;
                case 7:
                    admissions.clearAllColleges();
                    break;
                case 8:
                    admissions.clearAllStudents();
                    break;
                case 9:
                    System.out.println("Which college is your student applying to?");
                    int whichCollege = input.nextInt();
                    System.out.println("Which student is applying?");
                    int whichStudent = input.nextInt();
                    System.out.println("You have a " + admissions.admissionsChances(whichCollege, whichStudent) + "% chance of making it in!");
                    break;
                case 10:
                    System.exit(0);
                    break;
            }
        }
    }
}