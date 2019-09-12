import java.util.ArrayList;
 
/**
 * Author:  Sydney Walker
 * Period:  9
 * Class:   CollegeAdmissions.java
 * Purpose: calculates basic probability of getting into a college based off of GPA and SAT score, with numExCurr as a bonus for students
 */
 
public class CollegeAdmissions {
    //----------------------------------------------------------------
    //---------------- S T A T I C  V A R I A B L E S ------------
    //----------------------------------------------------------------
    static int numColleges, numStudents;
    //----------------------------------------------------------------
    //---------------- I N S T A N C E  V A R I A B L E S ------------
    //----------------------------------------------------------------    
    //Creates parallel array lists for a student and a college, student and college have 
    //a name, GPA, and SAT. Student also has number of extra curriculars.
    private ArrayList<String> nameCollege, nameStudent;
    private ArrayList<Double> collegeGPA, studentGPA;
    private ArrayList<Integer> collegeSAT, studentSAT, numExCurr;
    //////////////////////////////////////////////////////////////////
    ////////////////// C O N S T R U C T O R S ///////////////////////
    //////////////////////////////////////////////////////////////////
    //creates a complete student and initializes arrays
    public CollegeAdmissions(String aSName, double aSGPA, int aSSAT, int aNumEC){
        nameCollege = new ArrayList<>();
        collegeGPA = new ArrayList<>();
        collegeSAT = new ArrayList<>();
        nameStudent = new ArrayList<>();
        studentGPA = new ArrayList<>();
        studentSAT = new ArrayList<>();
        numExCurr = new ArrayList<>();
        nameStudent.add(aSName);
        studentGPA.add(aSGPA);
        studentSAT.add(aSSAT);
        numExCurr.add(aNumEC);
        numStudents++;
    }
    //creates a complete college and initilizes arrays
    public CollegeAdmissions(String aCollegeName, double aCollegeGPA, int aCollegeSAT){
        nameCollege = new ArrayList<>();
        collegeGPA = new ArrayList<>();
        collegeSAT = new ArrayList<>();
        nameStudent = new ArrayList<>();
        studentGPA = new ArrayList<>();
        studentSAT = new ArrayList<>();
        numExCurr = new ArrayList<>();
        nameCollege.add(aCollegeName);
        collegeGPA.add(aCollegeGPA);
        collegeSAT.add(aCollegeSAT);
        numColleges++;
    }
    //initilizes all arrays
    public CollegeAdmissions(){
        nameCollege = new ArrayList<>();
        collegeGPA = new ArrayList<>();
        collegeSAT = new ArrayList<>();
        nameStudent = new ArrayList<>();
        studentGPA = new ArrayList<>();
        studentSAT = new ArrayList<>();
        numExCurr = new ArrayList<>();        
    }
    //MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
    //MMMMMMMMMMMMMMMMMMMM M U T A T O R S MMMMMMMMMMMMMMMMMMMMMMMMMMMM
    //MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
    //takes in all parameters for a college and creates it
    public void createCollege(String name, double GPA, int SAT) throws IllegalArgumentException{
        if(GPA >= 0 && SAT >= 0){
            nameCollege.add(name);
            collegeGPA.add(GPA);
            collegeSAT.add(SAT);
            numColleges++;
        } else {
            throw new IllegalArgumentException("Cannot have a negative score");
        }
    }
    //takes in all parameters for a student and creates it
    public void createStudent(String name, double GPA, int SAT, int aNumExCurr) throws IllegalArgumentException{
        if(GPA >= 0 && SAT >= 0){
            nameStudent.add(name);
            studentGPA.add(GPA);
            studentSAT.add(SAT);
            numExCurr.add(aNumExCurr);
            numStudents++;
        } else {
            throw new IllegalArgumentException("Cannot have negative score");
        }
    }
    //clears all of the arrays associated with a college
    public void clearAllColleges(){ 
        nameCollege.clear();
        collegeGPA.clear();
        collegeSAT.clear();
        numColleges = 0;
    }
    //clears all of the arrays associated with a student
    public void clearAllStudents(){ 
        nameStudent.clear();
        studentGPA.clear();
        studentSAT.clear();
        numExCurr.clear();
        numStudents = 0;
    }
    //clears a certain college
    public void clearCollege(int which){
        //(which - 1) used because arrays are zero based and 
        //user uses one as the first number in their count
        nameCollege.remove(which - 1);  
        collegeGPA.remove(which - 1);
        collegeSAT.remove(which - 1);
        numColleges--;
    }
    public void clearStudent(int which){ //clears a certain student
        //(which - 1) used because arrays are zero based and 
        //user uses one as the first number in their count
        nameStudent.remove(which - 1); 
        studentGPA.remove(which - 1);
        studentSAT.remove(which - 1);
        numExCurr.remove(which - 1);
        numColleges--;
    }
    //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    //AAAAAAAAAAAAAAAAAAAA A C C E S S O R S AAAAAAAAAAAAAAAAAAAAAAAAAA
    //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    //returns number of students that have been created
    public int numStudents(){   
        return nameStudent.size();
    }
    //returns the number of colleges that have been created
    public int numColleges(){   
        return nameCollege.size();
    }
    //returns all information for the student selected, zero based because 
    //tester uses it in a for loop to print all students
    public String getStudentNumber(int which){  
        return nameStudent.get(which) + "\t\t\t" + studentGPA.get(which)
                + "\t\t" + studentSAT.get(which) + "\t\t" + numExCurr.get(which);
    }
    //returns all information for the college selected, zero based because 
    //tester uses it in a for loop to print all students
    public String getCollegeNumber(int which){  
        return nameCollege.get(which) + "\t\t\t" + collegeGPA.get(which) 
                + "\t\t" + collegeSAT.get(which);
    }
    //returns the chance of the selected student of getting into the selected college
    public double admissionsChances(int college, int student){  
        double chance = 0;
        //if the student has the minimum GPA of the college it adds 50% chance
        if(collegeGPA.get(college-1) <= studentGPA.get(student-1)){ 
            chance++;
        }
        //if the student has the minimum SAT of the college it adds 50% chance
        if(collegeSAT.get(college-1) <= studentSAT.get(student-1)){ 
            chance++;
        }
        chance /= 2; //divides by two to get the fraction of 
        //SAT and GPA that is the minimum or above of the college
        chance *= 100;  //multiplies by 100 in order to convert 
        //the fractional chance to a percent
        chance = (int)chance; //rounds the fraction
        chance += numExCurr.get(student - 1); //adds one percent chance of admission for 
        //each extra curricular of the student
        if(chance > 100){   //limits the percent chance of admission to 100
            chance = 100;
        }
        return chance;
    }
    public String toString(){
        String log = "----------Students----------";
        log += "Name\t\tGPA\t\tSAT\t\tNumber Activities";
        for(int i = 0; i < nameStudent.size(); i++){
            log += nameStudent.get(i) + "\t\t" + studentGPA.get(i) + "\t\t" + studentSAT.get(i) + "\t\t" + numExCurr.get(i);
        }
        log += "----------Colleges----------";
        log += "Name\t\tGPA\t\tSAT";
        for(int i = 0; i < nameCollege.size(); i++){
            log += nameCollege.get(i) + "\t\t" + collegeGPA.get(i) + "\t\t" + collegeSAT.get(i);
        }
        return log;
    }
}