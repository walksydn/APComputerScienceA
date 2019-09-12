
/**
 * Author:  Sydney Walker
 * Period:  9
 * Class:   SRWUtilities.java
 * Purpose: contain the box string and square roots methods
 */

public class SRWUtilities {

    public void printSquareRoots() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(i + "\t" + Math.sqrt(i));
        }
    }

    public void outputBoxString(String message) {
//        if (message.length() > 20) {
//            message = message.substring(0, 20);
//        }
        
        int totalLength = message.length() + 6;
        int insideLength = message.length() + 2;
        for (int i = 0; i < 5; i++) {
            if (i == 0 || i == 4) {
                for (int j = 0; j < totalLength; j++) {
                    System.out.print("@");
                }
            } else if (i == 1 || i == 3) {
                System.out.print("@@");
                for (int p = 0; p < insideLength; p++) {
                    System.out.print(" ");
                }
                System.out.print("@@");
            } else {
                System.out.print("@@ " + message + " @@");
            }
            System.out.println("");
        }
    }

}
