import java.util.Scanner;
import javax.sound.sampled.Clip;

/**
 * Author:  Sydney Walker
 * Period:  9
 * Class:   DoubleVerifier.java
 * Purpose: verifies if integers are in range
 */

public class IntVerifier {
    private final Scanner input;
    private final int low, high;
    private final boolean lowInc, highInc;
    private final Clip errorSound;
    int num;
    public IntVerifier(Scanner in, int lo, boolean loInc, int hi, boolean hiInc, Clip sound){
        input = in;
        low = lo;
        high = hi;
        lowInc = loInc;
        highInc = hiInc;
        errorSound = sound;
    }
    
    public IntVerifier(Scanner in, int lo, boolean loInc, int hi, boolean hiInc){        
        input = in;
        low = lo;
        high = hi;
        lowInc = loInc;
        highInc = hiInc;
        errorSound = null;
    }
    
    public int readAndVerify(){
        while(true){
            boolean goodChar = true;
            System.out.println("Please enter a number.");
            try{
                num = input.nextInt();
            } catch(Exception e){
                System.out.println("************BAD CHARACTER************");
                goodChar = false;
                if(errorSound != null){
                    errorSound.setFramePosition(0);
                    errorSound.start();            
                }
            } finally {
                input.nextLine();
            }
            if(goodChar){
                if(((!lowInc && num > low) || (lowInc && num >= low)) && ((!highInc && num < high) || (highInc && num <= high))){
                    return num;
                } else {
                    System.out.println("************OUT OF RANGE************");
                    if(errorSound != null){
                        errorSound.setFramePosition(0);
                        errorSound.start();            
                    }
                }                
            }
        }
    }
}
