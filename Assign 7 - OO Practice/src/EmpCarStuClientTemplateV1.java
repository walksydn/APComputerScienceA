
/**
 * ---------------------------------------------------------------------------
 * S-h-e-n-e-n-d-e-h-o-w-a--H-i-g-h--S-c-h-o-o-l--T-e-c-h-n-o-l-o-g-y--D-e-p-t
 * ---------------------------------------------------------------------------
 * FILE: EmpCarStuClientTemplate.java
 *
 * DATE: October 23, 2015
 *
 * PURPOSE: Sample Client for Car, Student, Employee
 *
 * @author mr Hanley
 * @version 1.0
 * ---------------------------------------------------------------------------
 *
 * h-a-n-l-e-y.c-o-.-n-r------t-e-a-m-2-0-.-c-o-m-----------------------------
 */
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Scanner;

public class EmpCarStuClientTemplateV1 {
    static final char ur = '\u2557';
    static final char ul = '\u2554';
    static final char top = '\u2550';
    static final char side = '\u2551';
    static final char sideTL = '\u2560';
    static final char sideRL = '\u2563';
    static final char bl = '\u255A';
    static final char br = '\u255D';
    static final char one = '\u2776';
    static final char two = '\u2777';
    static final char thr = '\u2778';
    static final char fou = '\u2779';
    static final char fiv = '\u277A';
    static final char six = '\u277B';
    static final char sev = '\u277C';

    public static void main(String[] args) {
        SRWUtilities util = new SRWUtilities();
        util.outputBoxString("Sydney Walker Period 9 APCS");
        EmpCarStuClientTemplateV1 es = new EmpCarStuClientTemplateV1();  //invoke constructor
    }

    /**
     *
     * @param text give me a text expression
     * @param totalLength total length of String to be filled
     * @return a String of spaces to "pad" the region where len =
     * total.len-text.len
     */
    public String padding(String text, int totalLength) {
        int difference = totalLength - text.length();
        if (difference > 0) {
        
            for (int i = 0; i < difference; i++) {
                text += " ";
            }
        }
        return text;
    }

    public EmpCarStuClientTemplateV1() {
        menu();
    }

    public void menu() {
        while (true) {
            Date now = new Date();
            System.out.print("\t\t" + ul);
            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //_________________________________________");
            System.out.println(ur);
            System.out.println("\t\t" + side + "        OO Practice Main Menu            " + side);
            System.out.println("\t\t" + side + "  $@$ OO is Delicious and Nutritious $@$ " + side);
            System.out.print("\t\t" + sideTL);

            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //_________________________________________
            System.out.println(sideRL);
            System.out.println("\t\t" + side + "        " + one + " = Employee Example             " + side);
            System.out.println("\t\t" + side + "        " + two + " = Car Example                  " + side);
            System.out.println("\t\t" + side + "        " + thr + " = Student Example              " + side);
            System.out.println("\t\t" + side + "        " + fou + " = Enhanced Employee Example    " + side);
            System.out.println("\t\t" + side + "        " + fiv + " = Enhanced Car Example         " + side);
            System.out.println("\t\t" + side + "        " + six + " = Enhanced Student Example     " + side);
            System.out.println("\t\t" + side + "        " + sev + " = Exit                         " + side);
            System.out.println("\t\t" + side + "                                         " + side);
            System.out.print("\t\t" + bl);
            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //+"_________________________________________
            System.out.println(br);
            System.out.println("\t\tYour Selection?");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    employeeModule();
                    break;
                case 2:
                    carModule();
                    break;
                case 3:
                    studentModule();
                    break;
                case 4:
                    employeeModuleWithMods();
                    break;
                case 5:
                    carModuleWithMods();
                    break;
                case 7:
                    System.exit(0);
            }
        }
    }

    public void employeeModule() {
        DecimalFormat df = new DecimalFormat("###,###,###");
        //Declare some Employees
        Employee e1 = new Employee();
        Employee e2 = new Employee("John Anderson", 52000);
        Employee e3 = new Employee("Steve Wozniak", 60000);
        while (true) {
            System.out.print("\t\t" + ul);
            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //_________________________________________");
            System.out.println(ur);
            System.out.println("\t\t" + side + "  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% " + side);
            System.out.println("\t\t" + side + "  E M P L O Y E E     M E N U            " + side);
            System.out.println("\t\t" + side + "  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% " + side);
            System.out.print("\t\t" + sideTL);

            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //_________________________________________
            System.out.println(sideRL);
            System.out.println("\t\t" + side + "        1 = Display Employees            " + side);
            System.out.println("\t\t" + side + "        2 = Recreate one Employee        " + side);
            System.out.println("\t\t" + side + "        3 = Give Raise                   " + side);
            System.out.println("\t\t" + side + "        4 = Exit to Main                 " + side);
            System.out.println("\t\t" + side + "        5 = Exit Program                 " + side);
            System.out.println("\t\t" + side + "                                         " + side);
            System.out.print("\t\t" + bl);
            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //+"_________________________________________
            System.out.println(br);
            System.out.println("\t\tYour Selection?");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("_____________Display Employees____________");
                    System.out.println(e1.getName() + "\t" + e1.getSalary());
                    System.out.println(e2.getName() + "\t" + e2.getSalary());
                    System.out.println(e3.getName() + "\t" + e3.getSalary());
                    break;
                case 2:
                    System.out.println("_____________Recreate Employee____________");
                    System.out.println("Which employee? 1 2 or 3:");
                    int which = input.nextInt();
                    input.skip("\n");
                    System.out.println("Enter your new name.");
                    String name = input.nextLine();
                    System.out.println("Enter their salary");
                    double salary = input.nextDouble();
                    switch (which){
                        case 1:
                            e1.setName(name);
                            e1.setSalary(salary);
                            break;
                        case 2:
                            e2.setName(name);
                            e2.setSalary(salary);
                            break;
                        case 3: 
                            e3.setName(name);
                            e3.setSalary(salary);
                            break;
                    }
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    System.out.println("Employee " + which + " Updated");
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    break;
                case 3:
                    System.out.println("$$$$$$$$$$$ Give Employee Raise $$$$$$$$$$$");
                    System.out.println("Which employee? 1 2 or 3:");
                    int whichOne = input.nextInt();
                    switch(whichOne){
                        case 1:
                            System.out.println("What percent would you like to raise their salary by?");
                            e1.raiseSalary(input.nextInt());
                            break;
                        case 2:
                            System.out.println("What percent would you like to raise their salary by?");
                            e2.raiseSalary(input.nextInt());
                            break;
                        case 3:
                            System.out.println("What percent would you like to raise their salary by?");
                            e3.raiseSalary(input.nextInt());
                            break;
                    }
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    System.out.println("Employee " + whichOne + " Given Raise");
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

                case 4:
                    break;
                case 5:
                    System.exit(0);
            }
            if (choice == 4) {
                break;
            }
        }
    }

    public void employeeModuleWithMods() {
        DecimalFormat df = new DecimalFormat("###,###,###");
        //Declare some Employees
        Employee e1 = new Employee();
        Employee e2 = new Employee("John Anderson", 52000);
        Employee e3 = new Employee("Steve Wozniak", 60000);
        while (true) {
            System.out.print("\t\t" + ul);
            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //_________________________________________");
            System.out.println(ur);
            System.out.println("\t\t" + side + "  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% " + side);
            System.out.println("\t\t" + side + "  %       E M P L O Y E E     M E N U  % " + side);
            System.out.println("\t\t" + side + "  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% " + side);
            System.out.println("\t\tNumber of Employees: \t\t" + e1.numEmployees);
            System.out.println("\t\tPayroll Sum: \t\t" + e1.totalSalaryForAllEmployees);
            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //_________________________________________
            System.out.println(sideRL);
            System.out.println("\t\t" + side + "        1 = Display Employees            " + side);
            System.out.println("\t\t" + side + "        2 = Recreate one Employee        " + side);
            System.out.println("\t\t" + side + "        3 = Give Raise                   " + side);
            System.out.println("\t\t" + side + "        4 = Exit to Main                 " + side);
            System.out.println("\t\t" + side + "        5 = Exit Program                 " + side);
            System.out.println("\t\t" + side + "                                         " + side);
            System.out.print("\t\t" + bl);
            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //+"_________________________________________
            System.out.println(br);
            System.out.println("\t\tYour Selection?");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("_____________Display Employees____________");
                    System.out.println(e1.getName() + "\t" + e1.getSalary());
                    System.out.println(e2.getName() + "\t" + e2.getSalary());
                    System.out.println(e3.getName() + "\t" + e3.getSalary());
                    break;
                case 2:
                    System.out.println("_____________Recreate Employee____________");
                    System.out.println("Which employee? 1 2 or 3:");
                    int which = input.nextInt();
                    input.skip("\n");
                    System.out.println("Enter your new name.");
                    String name = input.nextLine();
                    System.out.println("Enter their salary");
                    double salary = input.nextDouble();
                    switch (which){
                        case 1:
                            e1.setName(name);
                            e1.setSalary(salary);
                            break;
                        case 2:
                            e2.setName(name);
                            e2.setSalary(salary);
                            break;
                        case 3: 
                            e3.setName(name);
                            e3.setSalary(salary);
                            break;
                    }
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    System.out.println("Employee " + which + " Updated");
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    break;
                case 3:
                    System.out.println("$$$$$$$$$$$ Give Employee Raise $$$$$$$$$$$");
                    System.out.println("Which employee? 1 2 or 3:");
                    int whichOne = input.nextInt();
                    switch(whichOne){
                        case 1:
                            System.out.println("What percent would you like to raise their salary by?");
                            e1.raiseSalary(input.nextInt());
                            break;
                        case 2:
                            System.out.println("What percent would you like to raise their salary by?");
                            e2.raiseSalary(input.nextInt());
                            break;
                        case 3:
                            System.out.println("What percent would you like to raise their salary by?");
                            e3.raiseSalary(input.nextInt());
                            break;
                    }
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    System.out.println("Employee " + whichOne + " Given Raise");
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

                case 4:
                    break;
                case 5:
                    System.exit(0);
            }
            if (choice == 4) {
                break;
            }
        }
    }

    //____________________________________________________________________________________
    //CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*
    //CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*
    //CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*
    //  C A R  E X A M P L E
    //CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*
    //CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*
    //CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*CAR*
    //____________________________________________________________________________________
    public void carModule() {
        //Declare some Cars
        Car c1 = new Car("Beemer", 29); //beemer
        Car c2 = new Car("Honda", 30); //honda accord
        Car c3 = new Car("Prius", 35); //prius
        //FINISH
        while (true) {
            System.out.print("\t\t" + ul);
            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //_________________________________________");
            System.out.println(ur);
            System.out.println("\t\t" + side + "  ______________________________________ " + side);
            System.out.println("\t\t" + side + "       C A R     M E N U                 " + side);
            System.out.println("\t\t" + side + "  ______________________________________ " + side);
            
            System.out.print("\t\t" + sideTL);

            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //_________________________________________
            System.out.println(sideRL);
            System.out.println("\t\t" + side + "        1 = Display Cars                 " + side);
            System.out.println("\t\t" + side + "        2 = Recreate one Car             " + side);
            System.out.println("\t\t" + side + "        3 = Fill Up                      " + side);
            System.out.println("\t\t" + side + "        4 = Drive                        " + side);
            System.out.println("\t\t" + side + "        5 = Exit to Main                 " + side);
            System.out.println("\t\t" + side + "        6 = Exit Program                 " + side);
            System.out.println("\t\t" + side + "                                         " + side);
            System.out.print("\t\t" + bl);
            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //+"_________________________________________
            System.out.println(br);
            System.out.println("\t\tYour Selection?");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("_____________Display Cars____________");
                    System.out.println("Name\t\t\tMPG\t\tGas in Tank");
                    System.out.println("----\t\t\t----\t\t---------");
                    System.out.println(c1.getName() + "\t\t\t" + c1.getFuelEfficiency() + "\t\t" + c1.getGas());
                    System.out.println(c3.getName() + "\t\t\t" + c2.getFuelEfficiency() + "\t\t" + c2.getGas());
                    System.out.println(c2.getName() + "\t\t\t" + c3.getFuelEfficiency() + "\t\t" + c3.getGas());
                  //FINISH
                    break;
                case 2:
                    System.out.println("_____________Recreate Car____________");
                    System.out.println("Which car? 1 2 or 3:");
                    int which = input.nextInt();
                    input.skip("\n");
                    System.out.println("Please enter car name.");
                    String name = input.nextLine();
                    System.out.println("Please enter the fuel efficiency of " + name);
                    double fuelEff = input.nextDouble();
                    switch(which){
                        case 1: 
                            c1.setName(name);
                            c1.setFuelEff(fuelEff);
                            break;
                        case 2: 
                            c2.setName(name);
                            c2.setFuelEff(fuelEff);
                            break;
                        case 3: 
                            c3.setName(name);
                            c3.setFuelEff(fuelEff);
                            break;
                    }
                  //FINISH
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    System.out.println("Car " + which + " Updated");
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    break;
                case 3:
                    System.out.println("_____________Fill Up____________");
                    System.out.println("Which car? 1 2 or 3:");
                    int whichOne = input.nextInt();
                    System.out.println("How much gas are you adding?");
                    double gasAdded = input.nextDouble();
                    switch(whichOne){
                        case 1: 
                            c1.addGas(gasAdded);
                            break;
                        case 2: 
                            c2.addGas(gasAdded);
                            break;
                        case 3: 
                            c3.addGas(gasAdded);
                            break;
                    }
          //FINISH
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    System.out.println("Car " + whichOne + " Added " + gasAdded + " gallons!");
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    break;
                case 4:
                    System.out.println("DRIVE#DRIVE#DRIVE#DRIVE#DRIVE#DRIVE#DRIVE#DRIVE");
                    System.out.println("DRIVE##____________Drive Car____________##DRIVE");
                    System.out.println("DRIVE#DRIVE#DRIVE#DRIVE#DRIVE#DRIVE#DRIVE#DRIVE");
                    System.out.println("Which car? 1 2 or 3:");
                    int wh = input.nextInt();
                    System.out.println("How much far are you driving?");
                    double miles = input.nextDouble();
                    switch(wh){
                        case 1: 
                            c1.addGas(miles);
                            break;
                        case 2: 
                            c2.addGas(miles);
                            break;
                        case 3: 
                            c3.addGas(miles);
                            break;
                    }
         //FINISH
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    System.out.println("Car " + wh + " Drove " + miles + " Miles");
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    break;
                case 5:
                    break;
                case 6:
                    System.exit(0);
            }
            if (choice == 5) {
                break;
            }
        }
    }

    public void carModuleWithMods() {
        //Declare some Cars
        Car c1 = new Car("Beemer", 29); //beemer
        Car c2 = new Car("Honda", 30); //honda accord
        Car c3 = new Car("Prius", 35); //prius
   //FINISH
        while (true) {
            System.out.print("\t\t" + ul);
            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //_________________________________________");
            System.out.println(ur);
            System.out.println("\t\t" + side + "  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ " + side);
            System.out.println("\t\t" + side + "    C A R  M E N U  W I T H  M O D S     " + side);
            System.out.println("\t\t" + side + "  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ " + side);
            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //_________________________________________
            System.out.println(sideRL);
            System.out.println("\t\t" + side + "        1 = Display Cars                 " + side);
            System.out.println("\t\t" + side + "        2 = Recreate one Car             " + side);
            System.out.println("\t\t" + side + "        3 = Fill Up                      " + side);
            System.out.println("\t\t" + side + "        4 = Drive                        " + side);
            System.out.println("\t\t" + side + "        5 = Exit to Main                 " + side);
            System.out.println("\t\t" + side + "        6 = Exit Program                 " + side);
            System.out.println("\t\t" + side + "                                         " + side);
            System.out.print("\t\t" + bl);
            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //+"_________________________________________
            System.out.println(br);
            System.out.println("\t\tYour Selection?");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("_____________Display Cars____________");
                    // CAR 1
       //FINISH
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                   // System.out.println("Car " + which + " Updated");
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    break;
                case 3:
                    System.out.println("_____________Fill Up____________");

                    System.out.println("Which car? 1 2 or 3:");
                    int whichOne = input.nextInt();
          //FINISH
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                 //   System.out.println("Car " + wh + " Drove " + f + " Miles");
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    break;
                case 5:
                    break;
                case 6:
                    System.exit(0);
            }
            if (choice == 5) {
                break;
            }
        }
    }

    //____________________________________________________________________________________
    //STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*
    //STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*
    //STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*
    //  S T U D E N T    E X A M P L E
    //STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*
    //STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*
    //STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*STU*
    //____________________________________________________________________________________
    public void studentModule() {
        //Declare some Students
        Student s1 = new Student("Michael");
        Student s2 = new Student("Adam");
        Student s3 = new Student("Matt");
        //FINISH
        char menuBox = '\u2660';
        while (true) {
            System.out.print("\t\t" + ul);
            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //_________________________________________");
            System.out.println(ur);
            System.out.print("\t\t" + side + "  ");
            for (int i = 0; i < 38; i++) {
                System.out.print(menuBox);
            }
            System.out.println(" " + side);
            System.out.println("\t\t" + side + "    S T U D E N T     M E N U            " + side);
            System.out.print("\t\t" + side + "  ");
            for (int i = 0; i < 38; i++) {
                System.out.print(menuBox);
            }
            System.out.println(" " + side);
            System.out.print("\t\t" + sideTL);

            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //_________________________________________
            System.out.println(sideRL);
            System.out.println("\t\t" + side + "        1 = Display Students             " + side);
            System.out.println("\t\t" + side + "        2 = Recreate one Student         " + side);
            System.out.println("\t\t" + side + "        3 = Add Quiz Grade               " + side);
            System.out.println("\t\t" + side + "        4 = Clear Grades                 " + side);
            System.out.println("\t\t" + side + "        5 = Exit to Main                 " + side);
            System.out.println("\t\t" + side + "        6 = Exit Program                 " + side);
            System.out.println("\t\t" + side + "                                         " + side);
            System.out.print("\t\t" + bl);
            for (int i = 0; i < 41; i++) {
                System.out.print(top);
            }
            //+"_________________________________________
            System.out.println(br);
            System.out.println("\t\tYour Selection?");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    for (int i = 0; i < 50; i++) {
                        if (i % 2 == 0) {
                            System.out.print("\u263A");
                        } else {
                            System.out.print("\u263B");
                        }
                    }
                    System.out.println("");

                    System.out.println("             Display Students");
                    for (int i = 0; i < 50; i++) {
                        if (i % 2 == 0) {
                            System.out.print("\u263A");
                        } else {
                            System.out.print("\u263B");
                        }
                    }
                    System.out.println("");
                    System.out.println("Name\t\t\tQuizzes\t\tAverage");
                    System.out.println("----\t\t\t----\t\t---------");
                    System.out.println(s1.getName() + "\t\t\t" + s1.getTotalScore() + "\t\t" + s1.getAverageScore());
                    System.out.println(s2.getName() + "\t\t\t" + s2.getTotalScore() + "\t\t" + s2.getAverageScore());
                    System.out.println(s3.getName() + "\t\t\t" + s3.getTotalScore() + "\t\t" + s3.getAverageScore());
       //FINISH
                    for (int i = 0; i < 50; i++) {
                        if (i % 2 == 0) {
                            System.out.print("\u263A");
                        } else {
                            System.out.print("\u263B");
                        }
                    }
                    System.out.println("");
                    break;
                case 2:
                    for (int i = 0; i < 45; i++) {

                        System.out.print("\u2206");

                    }
                    System.out.println("_____________Recreate Student____________");
                    System.out.println("Which student? 1 2 or 3:");
                    int which = input.nextInt();
                    input.skip("\n");
                    System.out.println("Please enter the name of your student.");
                    String aName = input.nextLine();
                    switch(which){
                        case 1:
                            s1.recreate(aName);
                            break;
                        case 2:
                            s2.recreate(aName);
                            break;
                        case 3:
                            s3.recreate(aName);
                            break;
                    }
          //FINISH
                    System.out.println("((((((((((((()))))))))))))))))");
                    System.out.println("Student " + which + " Updated");
                    System.out.println("((((((((((((()))))))))))))))))");
                    break;
                case 3:
                    System.out.println("%^%^%^%^%^ Add Quiz %^%^%^%^%^");
                    System.out.println("Which student? 1 2 or 3:");
                    int whichOne = input.nextInt();
                    System.out.println("Enter Quiz Grade");
                    int score = input.nextInt();
                    switch(whichOne){
                        case 1:
                            s1.addQuiz(score);
                            break;
                        case 2:
                            s2.addQuiz(score);
                            break;
                        case 3:
                            s3.addQuiz(score);
                            break;                        
                    }
          //FINISH
                    System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
                    System.out.println("Student " + whichOne + " added quiz");
                    System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
                    break;
                case 4:
                    System.out.println("============Clear Student===========");
                    System.out.println("Which student? 1 2 or 3:");
                    int whichStu = input.nextInt();
                    switch(whichStu){
                        case 1:
                            s1.clearGrades();
                            break;
                        case 2:
                            s2.clearGrades();
                            break;
                        case 3:
                            s3.clearGrades();
                            break;
                    }
                    System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
                    System.out.println("Student " + whichStu + " cleared");
                    System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
                    break;

                case 6:
                    System.exit(0);
            }
            if (choice == 5) {
                break;
            }
        }
    }

    public void studentModuleWithMods() {
        //FINISH Assignment 8
    }
}