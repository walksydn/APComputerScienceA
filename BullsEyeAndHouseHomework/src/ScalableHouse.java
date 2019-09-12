import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
 
/**
 * Author: Sydney Walker Period: 9 Sauce Code: 16 Class: ScalableHosue.java
 * Purpose: paints a scalable house in a separate window
 */
public class ScalableHouse extends JFrame {
 
    private int scale = 0, xInit = 0, yInit = 0;
 
    public ScalableHouse(int s, int x, int y) {
        setSize(2500, 1000);
        setVisible(true);
        xInit = x;
        yInit = y;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        scale = s;
    }
 
    public static void main(String[] args) {
        ScalableHouse h = new ScalableHouse(10, 100, 300);
        h.paint(null);
    }
 
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, 2500, 1000);
        g.setColor(Color.lightGray);
        int width = 50 * scale, length = 40 * scale;
        g.fillRect(xInit, yInit, width, length);
        paintRoof(g, width, length);
        g.setColor(Color.magenta);
        g.fillRect(xInit + 10 * scale, yInit + 10 * scale, 10 * scale, 10 * scale);
        g.fillRect(xInit + 30 * scale, yInit + 10 * scale, 10 * scale, 10 * scale);
        g.setColor(Color.BLACK);
        g.fillRect(xInit + 20 * scale, yInit + 25 * scale, 10 * scale, 15 * scale);
    }
 
    public void paintRoof(Graphics g, int width, int length) {
        g.setColor(Color.darkGray);
        int overhang = 5 * scale;
        int[] x = {(xInit - overhang), (xInit + width + overhang), (xInit + (width / 2))};
        int[] y = {yInit, yInit, yInit - width * 2 / 5};
        g.fillPolygon(x, y, 3);
    }
}