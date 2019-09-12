import java.util.Scanner;
import javax.sound.sampled.Clip;

/**
 * Author:  Sydney Walker
 * Period:  9
 * Class:   DoubleVerifier.java
 * Purpose: verifies if doubles are in range
 */

public class DoubleVerifier {
    private final Scanner input;
    private final double low, high;
    private final boolean lowInc, highInc;
    private final Clip errorSound;
    double num;
    
    public DoubleVerifier(Scanner in, double lo, boolean loInc, double hi, boolean hiInc, Clip sound){
        input = in;
        low = lo;
        high = hi;
        lowInc = loInc;
        highInc = hiInc;
        errorSound = sound;
    }
    
    public double readAndVerify(){
        while(true){
            boolean goodChar = true;
            System.out.println("Please enter a number.");
            try{
                num = input.nextDouble();
            } catch(Exception e){
                System.out.println("************BAD CHARACTER************");
                goodChar = false;
                errorSound.setFramePosition(0);
                errorSound.start();
            } finally {
                input.nextLine();
            }
            if(goodChar){
                if(((!lowInc && num > low) || (lowInc && num >= low)) && ((!highInc && num < high) || (highInc && num <= high))){
                    return num;
                } else {
                    System.out.println("************OUT OF RANGE************");
                    errorSound.setFramePosition(0);
                    errorSound.start();
                }
            }
        }
    }
}
