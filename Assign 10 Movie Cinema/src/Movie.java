/**
 * Author:  Sydney Walker
 * Period:  9
 * Class:   Movie.java
 * Purpose: contains a movie with a title, mpaa rating, run time, and quality rating
 */
 
public class Movie {
    //----------------------------------------------------------------
    //---------------- I N S T A N C E  V A R I A B L E S ------------
    //----------------------------------------------------------------
 
    String name, mpaa;
    int runTime;
    double rating;
    //////////////////////////////////////////////////////////////////
    ////////////////// C O N S T R U C T O R S ///////////////////////
    //////////////////////////////////////////////////////////////////
    public Movie(String n, String m, int time, double r){
        name = n;
        mpaa = m;
        runTime = time;
        rating = r;
    }
    //MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
    //MMMMMMMMMMMMMMMMMMMM M U T A T O R S MMMMMMMMMMMMMMMMMMMMMMMMMMMM
    //MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
    public void setName(String n){
        name = n;
    }
     
    public void setMPAA(String m){
        mpaa = m;
    }
     
    public void setRunTime(int r){
        runTime = r;
    }
     
    public void setRating(double r){
        rating = r;
    }
    //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    //AAAAAAAAAAAAAAAAAAAA A C C E S S O R S AAAAAAAAAAAAAAAAAAAAAAAAAA
    //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA    
    public String getName(){
        return name;
    }
     
    public String getMPAA(){
        return mpaa;
    }
     
    public int getRunTime(){
        return runTime;
    }
     
    public double getRating(){
        return rating;
    }
     
    public String toString(){
        return String.format("%-50s%-20s%-20s%-20s", name, mpaa, runTime, rating);
    }
}