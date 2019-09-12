/**
 * Author:  Sydney Walker
 * Period:  9
 * Class:   RoundOffError.java
 * Purpose: see if a round off error will occur
 */

public class RoundOffError {
    public static void main(String[] args) {
        float one = numberOne()f;
        float one = numberOne();
        float one = numberOne();
    }
    
    public float numberOne(){
        float number = 123.45f;
        return number;
    }
    
    public float numberTwo(){
        float aNumber = 1.693f/10.0f;
        float original = 1000000.00f;
        int i, j;
        for(i = 0; i < 10; i++){
            original = original*aNumber;
        }
        for(j = 0; j < 10; j++){
            original = original/aNumber;
        }
        return original;
    }
    
    public double numberThree(){
        double aNumber = 1.693f/10.0f;
        double original = 1000000.00;
        int i, j;
        for(i = 0; i < 10; i++){
            original = original*aNumber;
        }
        for(j = 0; j < 10; j++){
            original = original/aNumber;
        }
        return original;
    }
}
