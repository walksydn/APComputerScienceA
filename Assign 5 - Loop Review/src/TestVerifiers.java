import java.io.File;
import java.util.Scanner;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Author:  Sydney Walker
 * Period:  9
 * Class:   Main.java
 * Purpose: runs all of the other classes
 */

public class TestVerifiers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SRWUtilities util = new SRWUtilities();
        Clip sighSnd = null;
        File sighF = new File("sounds/sigh.wav");
        try{
            sighSnd = AudioSystem.getClip();
            sighSnd.open(AudioSystem.getAudioInputStream(sighF));
        } catch(Exception e){
            System.out.println("Sound not working: " + e.toString());
        }
        //created for testing
        IntVerifier intIncInc = new IntVerifier(input, 1, true, 10, true, sighSnd);
        IntVerifier intNInc = new IntVerifier(input, -3, false, 10, true, sighSnd);
        IntVerifier intIncN = new IntVerifier(input, 0, true, 10, false, sighSnd);
        IntVerifier intNN = new IntVerifier(input, 1, false, 100, false, sighSnd);

        DoubleVerifier doubleIncInc = new DoubleVerifier(input, 0, true, 0.1, true, sighSnd);
        DoubleVerifier doubleNInc = new DoubleVerifier(input, 0, false, 0.1, true, sighSnd);
        DoubleVerifier doubleIncN = new DoubleVerifier(input, 0 , true, 1.7, false, sighSnd);
        DoubleVerifier doubleNN = new DoubleVerifier(input, -1.6, false, 198.2, false, sighSnd);
 
        //used for menu
        IntVerifier menu = new IntVerifier(input, 0, true, 10, true, sighSnd);
        while(true){
            System.out.println("______________________________________________________________");
            System.out.println("Choose from the activities below. \n0: Quit\n1: Square Roots\n2: String in a Box\n"
                    + "3: Int Verifier Inclusive Low and High\n4: Int Verifier Uinclusive Low, Inclusive High\n"
                    + "5: Int Verifier Inclusive Low, Uninclusive High\n6: Int Verifier Uninclusive Low and High\n"
                    + "7: Double Verifier Inclusive Low and High\n8: Double Verifier Uninclusive Low, Inclusive High\n"
                    + "9: Double Verifier Inclusive Low, Uninclusive High\n10: Double Verifier Uninclusive Low and High");
            System.out.println("______________________________________________________________");
            int choice = menu.readAndVerify();
            switch(choice){
                case 0: 
                    System.exit(0);
                    break;
                case 1:
                    util.printSquareRoots();
                    break;
                case 2: 
                    System.out.println("Enter the string you want in your box.");
                    String message = input.nextLine();
                    util.outputBoxString(message);
                    break;
                case 3:
                    intIncInc.readAndVerify();
                    break;
                case 4:
                    intNInc.readAndVerify();
                    break;
                case 5:
                    intIncN.readAndVerify();
                    break;
                case 6:
                    intNN.readAndVerify();
                    break;
                case 7: 
                    doubleIncInc.readAndVerify();
                    break;
                case 8: 
                    doubleNInc.readAndVerify();
                    break;
                case 9: 
                    doubleIncN.readAndVerify();
                    break;
                case 10: 
                    doubleNN.readAndVerify();
                    break;
            }
        }
    }
}
