/**
 * Author:  Sydney Walker
 * Period:  9
 * Class:   College.java
 * Purpose: stores the information for a college
 */
   
public class College implements Comparable{
    //----------------------------------------------------------------
    //---------------- I N S T A N C E  V A R I A B L E S ------------
    //----------------------------------------------------------------    
    private String name, region;
    private double averageGPA;
    private int averageSAT, numStudents;
    private int rating; //by the US news
    //////////////////////////////////////////////////////////////////
    ////////////////// C O N S T R U C T O R S ///////////////////////
    //////////////////////////////////////////////////////////////////
    //creates a complete college
    public College(String aName, String aRegion, double GPA, int SAT, int aNumStudents, int aRating){
        name = aName;
        region = aRegion;
        averageGPA = GPA;
        averageSAT = SAT;
        numStudents = aNumStudents;
        rating = aRating;
    }
    //initilizes all variables
    public College(){
        name = "";
        region = "";
        averageGPA = 0; averageSAT = 0; numStudents = 0; rating = 0;
    }
    //MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
    //MMMMMMMMMMMMMMMMMMMM M U T A T O R S MMMMMMMMMMMMMMMMMMMMMMMMMMMM
    //MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
    public void setName(String aName){
        name = aName;
    }
    public void setRegion(String aRegion){
        region = aRegion;
    }
    //sets average GPA, throws an exception when a negative value is entered
    public void setAverageGPA(double GPA) throws IllegalArgumentException{
        if(GPA >= 0){
            averageGPA = GPA;
        } else {
            throw new IllegalArgumentException("Cannot have a negative score");
        }
    }
    //sets average SAT, throws an exception when a negative value is entered
    public void setAverageSAT(int SAT) throws IllegalArgumentException{
        if(SAT >= 0){
            averageSAT = SAT;
        } else {
            throw new IllegalArgumentException("Cannot have a negative score");
        }
    }
    //sets number of students, throws an exception when a negative value is entered
    public void setNumStudents(int aNumStudents) throws IllegalArgumentException{
        if(aNumStudents >= 0){
            numStudents = aNumStudents;
        } else {
            throw new IllegalArgumentException("Cannot have a negative number of students");
        }
    }
    //sets rating of college, throws an exception when a negative values is entered
    public void setRating(int aRating) throws IllegalArgumentException{
        if(aRating >= 0){
            rating = aRating;
        } else {
            throw new IllegalArgumentException("Cannot have a negative rating");
        }
    }
    //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    //AAAAAAAAAAAAAAAAAAAA A C C E S S O R S AAAAAAAAAAAAAAAAAAAAAAAAAA
    //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    public String getName(){
        return name;
    }
    public String getRegion(){
        return region;
    }
    public double getAverageGPA(){
        return averageGPA;
    }
    public int getAverageSAT(){
        return averageSAT;
    }
    public int getNumStudents(){
        return numStudents;
    }
    public int getRating(){
        return rating;
    }
    //----------------------------------------------------------------
    //---------------------- IMPLEMENTED METHODS ---------------------
    //----------------------------------------------------------------
    @Override
    public String toString(){
        return String.format("%-20s%-20s%-20s%-20s%-20s%-20s%n", name, region, averageGPA, averageSAT, numStudents, rating);
    }
    //@params a college to compare to
    //@returns 1 if it is a better college, -1 if it is not, 0 if they are equal
    @Override
    public int compareTo(Object t) {
        College other = (College)t;
        if(rating > other.getRating()){
            return 1;
        } else if (rating == other.getRating()){
            if(averageGPA > other.getAverageGPA()){
                return 1;
            } else if(averageGPA == other.getAverageGPA()){
                if(averageSAT > other.getAverageSAT()){
                    return 1;
                } else if(averageSAT == other.getAverageSAT()){
                    if(numStudents > other.getNumStudents()){
                        return 1;
                    } else if (numStudents == other.getNumStudents()){
                        return 0;
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }
}