/**
 * Author:  Sydney Walker
 * Period:  9
 * Class:   Student.java
 * Purpose: 
 */

public class Student {
    //----------------------------------------------------------------
    //---------------- S T A T I C  V A R I A B L E S ------------
    //----------------------------------------------------------------
    static int totalTestsAllStudents = 0, numStudents = 0, totalPointsAllStudents;
    static double classAverage = 0;
    //----------------------------------------------------------------
    //---------------- I N S T A N C E  V A R I A B L E S ------------
    //----------------------------------------------------------------
    private String name;
    private double points;
    private int numTests;
    //////////////////////////////////////////////////////////////////
    ////////////////// C O N S T R U C T O R S ///////////////////////
    //////////////////////////////////////////////////////////////////
    public Student(){
        name = "";
        points = 0;
        numTests = 0;
        numStudents++;
    }
    public Student(String aName){
        name = aName;
        points = 0;
        numTests = 0;
        numStudents++;
    }
    //MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
    //MMMMMMMMMMMMMMMMMMMM M U T A T O R S MMMMMMMMMMMMMMMMMMMMMMMMMMMM
    //MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
    public void addQuiz(int score) throws IllegalArgumentException{
        if(score >= 0){
            points += score;
            numTests++;
            totalTestsAllStudents++;
            totalPointsAllStudents += score;
            classAverage = totalPointsAllStudents/totalTestsAllStudents;
        } else {
            throw new IllegalArgumentException("Cannot have negative grades");
        }
    }
    public void recreate(String aName){
        name = aName;
        points = 0; //reset student testing
        numTests = 0;
        totalPointsAllStudents -= points;   //remove student from class average
        totalTestsAllStudents -= numTests;
    }
    public void clearGrades(){
        points = 0;
        numTests = 0;
        totalPointsAllStudents -= points;   //remove grades from class average
        totalTestsAllStudents -= numTests;
        classAverage = totalPointsAllStudents/totalTestsAllStudents;
    }
    //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    //AAAAAAAAAAAAAAAAAAAA A C C E S S O R S AAAAAAAAAAAAAAAAAAAAAAAAAA
    //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    public String getName(){
        return name;
    }
    public double getTotalScore(){
        return points;
    }
    public double getAverageScore(){
        double average = points/numTests;
        return (int)average;
    }
    public String toString(){
        return "Name: " + name + "\tPoints: " + points + "\tAverage: " + getAverageScore();
    }
}