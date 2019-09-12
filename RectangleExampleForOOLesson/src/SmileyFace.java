
import java.awt.Color;
import java.awt.Graphics;

/**
 * Author:  Sydney Walker
 * Period:  9
 * Sauce Code: 16
 * Class:   SmileyFace.java
 * Purpose: draws a smiley face to the screen
 */

public class SmileyFace extends Shape{
    ////////////////////////////////////////////////////////////////// 
    ////////      C O N S T R U C T O R S      ///////////////////////   
    //////////////////////////////////////////////////////////////////
    public SmileyFace() {
        super(0, 0, Color.BLACK, Color.CYAN);
    }

    public SmileyFace(Color outCin, Color fillCin) {
        super(outCin, fillCin);
    }

    public SmileyFace(int xIn, int yIn) {
        super(xIn, yIn);
    }

    public SmileyFace(int xIn, int yIn, Color outCin, Color fillCin) {
        super(xIn, yIn, outCin, fillCin);
        
    }

    @Override
    public void draw(Graphics g) {
        drawHead(g);
    }
    
    public void drawHead(Graphics g){
        System.out.println("Draw Head Run");
        g.fillOval(super.getX(), super.getY(), 30, 30);
        g.drawOval(super.getX(), super.getY(), 30, 30);
    }

}




