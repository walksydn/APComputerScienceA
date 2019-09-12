/**
 * Author:  Sydney Walker
 * Period:  9
 * Sauce Code: 16
 * Class:   Tester.java
 * Purpose: creates three students and three instructors and uses their toString() methods
 *          to test inheritance
 */

public class Tester {
    public static void main(String[] args) {
        Student s1 = new Student("Jimmy", 2000, "Mechanical Engineering");
        Student s2 = new Student("Susan", 2005, "Liberal Arts");
        Student s3 = new Student("Adam", 1999, "Music Performance Arts");
        Instructor i1 = new Instructor("Matt", 1980, 100000);
        Instructor i2 = new Instructor("Chris", 1978, 40000);
        Instructor i3 = new Instructor("Bobby", 1956, 70000);
        System.out.println("Students: \n" + s1.toString());
        System.out.println(s2.toString());
        System.out.println(s3.toString());
        System.out.println("");
        System.out.println("Instructors: \n" + i1.toString());
        System.out.println(i2.toString());
        System.out.println(i3.toString());
    }
}