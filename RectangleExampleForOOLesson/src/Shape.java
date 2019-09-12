
/**
 * ---------------------------------------------------------------------------
 * S-h-e-n-e-n-d-e-h-o-w-a--H-i-g-h--S-c-h-o-o-l--T-e-c-h-n-o-l-o-g-y--D-e-p-t
 * ----------------------------------------------------------------------------
 * FILE: Shape.java
 *
 * DATE: 12/10/2013
 *
 * PURPOSE: Abstract Base Class for Inheritance
 * Updated 2/10/2016: Added some constructors
 *
 * @author mr Hanley
 * @version 1.0
 * ----------------------------------------------------------------------------
 * h-a-n-l-e-y.c-o-.-n-r------t-e-a-m-2-0-.-c-o-m----------------------------
 */
import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements Comparable {

    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //++++++++++++   S T A T I C  V A R I A B L E S   ++++++++++++++++
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static int nextNum = 1;

    //----------------------------------------------------------------
    //---------------- I N S T A N C E  V A R I A B L E S ------------
    //----------------------------------------------------------------
    private int x, y;
    private Color outCol, fillCol;

    ////////////////////////////////////////////////////////////////// 
    ////////      C O N S T R U C T O R S      ///////////////////////   
    //////////////////////////////////////////////////////////////////
    public Shape() {
        x = y = 0;
        outCol = Color.BLACK;
        fillCol = Color.CYAN;
    }

    public Shape(Color outCin, Color fillCin) {
        outCol = outCin;
        fillCol = fillCin;
    }

    public Shape(int xIn, int yIn) {
        x = xIn;
        y = yIn;
    }

    public Shape(int xIn, int yIn, Color outCin, Color fillCin) {
        x = xIn;
        y = yIn;
        outCol=outCin;
        fillCol=fillCin;
        
    }

    //Compareto is based on position, row major

    public int compareTo(Object other) {
        Shape otherR = (Shape) other;  //typecast
        if (y != otherR.getY()) {
            return y - otherR.getY();
        }
        //Else go to the column
        return x - otherR.getX();
    }

    //.................................................................    
    //......   A B S T R A C T  M E T H O D S  ........................
    //.................................................................

    public abstract void draw(Graphics g);

    //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    //AAAAAAAAAAAAAAA  A C C E S S O R S  AAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getOutCol() {
        return outCol;
    }

    public Color getFillCol() {
        return fillCol;
    }

    public String toString() {
        return "[" + x + "," + y + "]";
    }

    //MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
    //MMMMMMMMMMMMMMM  M U T A T O R S   MMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
    //MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
    public void setX(int inX) throws IllegalArgumentException {
        if (inX < 0) {
            throw new IllegalArgumentException("Bad x value of " + inX);
        }
        x = inX;
    }

    public void setY(int inY) {
        y = inY;
    }

}
