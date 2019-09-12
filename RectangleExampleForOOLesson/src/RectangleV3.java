
/**
 * ---------------------------------------------------------------------------
 * S-h-e-n-e-n-d-e-h-o-w-a--H-i-g-h--S-c-h-o-o-l--T-e-c-h-n-o-l-o-g-y--D-e-p-t
 * ---------------------------------------------------------------------------
 * FILE: RectangleV3.java    .     .     .     .     .     .     .     .    .   
 * DATE: 12/10/2013                                                    .
 *
 * PURPOSE: Demonstrate Rectangle that extends Shape
 *
 * @author mr Hanley
 * @version 1.0
 * ----------------------------------------------------------------------------
 *
 * h-a-n-l-e-y.c-o-.-n-r------t-e-a-m-2-0-.-c-o-m----------------------------
 */
import java.awt.Color;
import java.awt.Graphics;

public class RectangleV3 extends Shape {
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //++++++++++++   S T A T I C  V A R I A B L E S   ++++++++++++++++
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static int rectCount = 0;
    //----------------------------------------------------------------
    //---------------- I N S T A N C E  V A R I A B L E S ------------
    //----------------------------------------------------------------
    private int width, height;

    ////////////////////////////////////////////////////////////////// 
    ////////      C O N S T R U C T O R S      ///////////////////////   
    //////////////////////////////////////////////////////////////////
    public RectangleV3() {
      
    }

    public RectangleV3(Color outColIn, Color fillCollIn) {
     super(outColIn, fillCollIn);  //pass it up to parent class
    }
    public RectangleV3(int xIn, int yIn, int w, int h, Color outCin, Color fillCin) {
       super(xIn, yIn,outCin, fillCin);      
        
        width = w;
        height = h;
        rectCount++;
    }
    //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    //AAAAAAAAAAAAAAA  A C C E S S O R S  AAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    public int getW() {
        return width;
    }

    public int getH() {
        return height;
    }
    //Compareto is based on position, row major
     public int compareTo(Object other){
        Rectangle otherR = (Rectangle)other;  //typecast
        if(getY() != otherR.getY()){
            return getY() - otherR.getY();
        }
        //Else go to the column
        return getX() - otherR.getX();
    }
    public void draw(Graphics g){
        //Draw the first rectangle
        System.out.println("Here");
        g.setColor(getOutCol());
        System.out.println("x = "+getX()+"width"+width);
        g.drawRect(getX(), getY(), width, height);
        g.setColor(getFillCol());
        g.fillRect(getX()+1, getY()+1, width-1, height-1);
    }
    //MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
    //MMMMMMMMMMMMMMM  M U T A T O R S   MMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
    //MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
    public void setWidth(int w){
        width = w;
    }
    public void setHeight(int h){
        height = h;
    }
}


