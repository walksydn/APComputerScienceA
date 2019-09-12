/**
 * Author:  Sydney Walker
 * Period:  9
 * Sauce Code: 16
 * Class:   RecursionMethods.java
 * Purpose: find the GCF of two numbers and raise a number to a power
 */

public class RecursionMethods {
    //prevents user from having to enter the candidate
    public static int greatestCommonFactor(int num1, int num2){
        return greatestCommonFactor(num1, num2, Math.max(num1, num1));
    }
    private static int greatestCommonFactor(int num1, int num2, int candidate){
        //checks if num1 and num2 both divide evenly into the candidate
        if(num1%candidate == 0 && num2%candidate == 0){
            return candidate;
        } else {
            return greatestCommonFactor(num1, num2, candidate-1);
        }
    }
    public static double raiseToPower(double base, int exponent){
        if(exponent == 1){
            return base;
        } else {
            //if the exponent is negative, the base is inverted
            if(exponent < 1){
                return base*raiseToPower(1/base, Math.abs(exponent - 1));
            } else {
                return base*raiseToPower(base, exponent-1);                
            }
        }
    }
}




