import java.util.ArrayList;

/**
 * Author:  Sydney Walker
 * Period:  9
 * Class:   ArrayListLab.java
 * Purpose: practice ArrayLists
 */

public class ArrayListLab {
    static ArrayList<Employee> emps = new ArrayList<>();
    public static void main(String[] args) {
        emps.add(new Employee("Rockel Rice", 80000));
        emps.add(new Employee("Edward Zu", 75000));
        print();
        System.out.println("");
        emps.add(1, new Employee("Sydney Werner", 90000));
        print();
        System.out.println("");
        emps.remove(0);
        print();
        System.out.println("");
        emps.remove(0);
        emps.add(new Employee("Paul Kane", 100000));
        print();
        System.out.println("");
        Employee T1 = emps.get(0);
        Employee T2 = emps.get(1);
        if(T1.getSalary() == T2.getSalary()){
            System.out.println("They have equal salaries");
        } else if (T1.getSalary() > T2.getSalary()){
            System.out.println("First employee has a higher salary");
        } else {
            System.out.println("Second employee has a higher salary");
        }
    }
    
    public static void print(){
        for(int i = 0; i < emps.size(); i++){
            System.out.println(emps.get(i));
        }
    }
}
