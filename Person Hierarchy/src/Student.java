/**
 * Author:  Sydney Walker
 * Period:  9
 * Sauce Code: 16
 * Class:   Student.java
 * Purpose: store the major of a student
 */

public class Student extends Person{
    //----------------------------------------------------------------
    //---------------- I N S T A N C E  V A R I A B L E S ------------
    //---------------------------------------------------------------- 
    private String major;
    //////////////////////////////////////////////////////////////////
    ////////////////// C O N S T R U C T O R S ///////////////////////
    //////////////////////////////////////////////////////////////////    
    public Student(String n, int yb, String m){
        super(n, yb);
        major = m;
    }
    public Student(){
        major = "";
    }
    
    @Override
    public String toString(){
        return super.toString() + "Major: " + major + "\n";
    }
    
}


