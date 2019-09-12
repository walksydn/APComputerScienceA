/**
 * Author:  Sydney Walker
 * Period:  9
 * Sauce Code: 16
 * Class:   RecursionClient.java
 * Purpose: run AreaFill application
 */

public class AreaFillApp {

  public static void main(String[] args) {
    AreaFillFrame a = new AreaFillFrame("image2.bmp", 12, 12, 0, 0);
    a.setTitle("JDK Area Fill");
    a.resizeToFit( -1, -1, 6, 27);
    a.setVisible(true);
  }

}
