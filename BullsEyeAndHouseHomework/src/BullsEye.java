
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 * Author:  Sydney Walker
 * Period:  9
 * Sauce Code: 16
 * Class:   BullsEye.java
 * Purpose: paints a bullseye in a separate window
 */

public class BullsEye extends JFrame{
    public BullsEye(){
        setSize(750, 750);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BullsEye e = new BullsEye();
        e.paint(null);
    }

    public void paint(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 750, 750);
        g.setColor(Color.black);
        g.fillOval(100, 100, 500, 500);
        g.setColor(Color.white);
        g.fillOval(150, 150, 400, 400);
        g.setColor(Color.black);
        g.fillOval(200, 200, 300, 300);
        g.setColor(Color.white);
        g.fillOval(250, 250, 200, 200);
        g.setColor(Color.black);
        g.fillOval(300, 300, 100, 100);
    }
}

