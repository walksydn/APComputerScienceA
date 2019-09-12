/**
 * Author:  Sydney Walker
 * Period:  9
 * Sauce Code: 16
 * Class:   Person.java
 * Purpose: stores a name and place of birth for a person
 */

public class Person {
    //----------------------------------------------------------------
    //---------------- I N S T A N C E  V A R I A B L E S ------------
    //----------------------------------------------------------------    
    private String name;
    private int birthYear;
    //////////////////////////////////////////////////////////////////
    ////////////////// C O N S T R U C T O R S ///////////////////////
    //////////////////////////////////////////////////////////////////    
    public Person(String n, int by){
        name = n;
        birthYear = by;
    }
    public Person(){
        name = "";
        birthYear = 0;
    }

    //----------------------------------------------------------------
    //------------------- T O  S T R I N G  M E T H O D --------------
    //----------------------------------------------------------------    
    @Override
    public String toString(){
        return "Name: " + name + "\nBirth Year: " + birthYear + "\n";
    }
}


