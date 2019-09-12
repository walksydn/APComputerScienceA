/**
 * Author:  Sydney Walker
 * Period:  9
 * Class:   Car.java
 * Purpose: 
 */

public class Car {
    //----------------------------------------------------------------
    //---------------- S T A T I C  V A R I A B L E S ------------
    //----------------------------------------------------------------
    static int totalNumCars = 0, totalMilesDriven = 0;
    //----------------------------------------------------------------
    //---------------- I N S T A N C E  V A R I A B L E S ------------
    //----------------------------------------------------------------
    private double fuelEff, gas;
    private String name;
    //////////////////////////////////////////////////////////////////
    ////////////////// C O N S T R U C T O R S ///////////////////////
    //////////////////////////////////////////////////////////////////
    public Car(String aName, double aEfficiency){ //miles per gallon
        name = aName;
        fuelEff = aEfficiency;
        gas = 0;
        totalNumCars++;
    }
    public Car(double aEfficiency){
        name = "";
        fuelEff = aEfficiency;
        gas = 0;        
        totalNumCars++;
    }
    //MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
    //MMMMMMMMMMMMMMMMMMMM M U T A T O R S MMMMMMMMMMMMMMMMMMMMMMMMMMMM
    //MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
    public void addGas(double gasAdded){//gallons
        gas += gasAdded;
    }
    public void drive(double milesDriven) throws IllegalArgumentException{
        if(milesDriven >= 0){
            gas -= milesDriven/fuelEff;
            totalMilesDriven += milesDriven;    
        } else {
            throw new IllegalArgumentException("Cannot drive negative miles.");
        }
    }
    public void setName(String aName){
        name = aName;
    }
    public void setFuelEff(double aFuelEff){
        fuelEff = aFuelEff;
    }
    //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    //AAAAAAAAAAAAAAAAAAAA A C C E S S O R S AAAAAAAAAAAAAAAAAAAAAAAAAA
    //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    public String getName(){
        return name;
    }
    public double getFuelEfficiency(){
        return fuelEff;
    }
    public double getGas(){
        return gas;
    }
    public int getTotalNumberCars(){
        return totalNumCars;
    }
    public int getTotalMilesDriven(){
        return totalMilesDriven;
    }
    public String toString(){
        return "Name: " + name + "\tGas: " + gas;
    }
}
