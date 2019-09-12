/**
 * Author:  Sydney Walker
 * Period:  9
 * Class:   Employee.java
 * Purpose: holds and modifies the name and salary of an employee
 */

public class Employee {
    //----------------------------------------------------------------
    //---------------- S T A T I C  V A R I A B L E S ------------
    //----------------------------------------------------------------
    static int numEmployees = 0, totalSalaryForAllEmployees = 0;
    //----------------------------------------------------------------
    //---------------- I N S T A N C E  V A R I A B L E S ------------
    //----------------------------------------------------------------
    private double salary;
    private String name;
    //////////////////////////////////////////////////////////////////
    ////////////////// C O N S T R U C T O R S ///////////////////////
    //////////////////////////////////////////////////////////////////
    public Employee(){
        name = "";
        salary = 0;
        numEmployees++;
    }
    public Employee(String aName, double aSalary){
        name = aName;
        salary = aSalary;
        numEmployees++;
        totalSalaryForAllEmployees += aSalary;
    }
    //MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
    //MMMMMMMMMMMMMMMMMMMM M U T A T O R S MMMMMMMMMMMMMMMMMMMMMMMMMMMM
    //MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
    public void setName(String aName){
        name = aName;
    }
    public void setSalary(double aSalary) throws IllegalArgumentException{
        if(aSalary >= 0){
            totalSalaryForAllEmployees -= salary;
            salary = aSalary;
            totalSalaryForAllEmployees += salary;            
        } else {
            throw new IllegalArgumentException("Cannot have negative salaries");
        }
    }
    public void raiseSalary(double percentIncrease){
        totalSalaryForAllEmployees -= salary;
        percentIncrease /= 100;
        salary *= (1 + percentIncrease);
        salary *= 100;
        salary = (int)salary;
        salary /= 100;
        totalSalaryForAllEmployees += salary;
    }
    //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    //AAAAAAAAAAAAAAAAAAAA A C C E S S O R S AAAAAAAAAAAAAAAAAAAAAAAAAA
    //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    public String getName(){
        return name;
    }
    public double getSalary(){
        return salary;
    }
    public String toString(){   //returns the employee's information in a string
        return "Name: " + name + "\tSalary: " + salary;
    }
}
