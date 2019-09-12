/**
 * Author:  Sydney Walker
 * Period:  9
 * Sauce Code: 16
 * Class:   Instructor.java
 * Purpose: stores the salary for an instructor
 */

public class Instructor extends Person{
    //----------------------------------------------------------------
    //---------------- I N S T A N C E  V A R I A B L E S ------------
    //----------------------------------------------------------------    
    private int salary;
    //////////////////////////////////////////////////////////////////
    ////////////////// C O N S T R U C T O R S ///////////////////////
    //////////////////////////////////////////////////////////////////    
    public Instructor(String n, int yb, int s){
        super(n, yb);
        salary = s;
    }
    public Instructor(){
        salary = 0;
    }
    
    @Override
    public String toString(){
        return super.toString() + "Salary: " + salary + "\n";
    }
}


