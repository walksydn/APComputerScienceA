/**
 * ---------------------------------------------------------------------------
 * S-h-e-n-e-n-d-e-h-o-w-a--H-i-g-h--S-c-h-o-o-l--T-e-c-h-n-o-l-o-g-y--D-e-p-t
 * ---------------------------------------------------------------------------
 * FILE: Rectangle.java
 *
 * DATE: 11/23/2013
 *
 * PURPOSE: Demonstrate OO Programming via a Rectangle
 *
 * @author mr Hanley
 * @version 1.0
 * ----------------------------------------------------------------------------
 *
 * h-a-n-l-e-y.c-o-.-n-r------t-e-a-m-2-0-.-c-o-m------------------------------
 */
import java.awt.Color;

public class Rectangle {
    
    //static variables
    public static int nextNum=1;
    
    //----------------------------------------------------------------
    //---------------- I N S T A N C E  V A R I A B L E S ------------
    //----------------------------------------------------------------
    private int x, y, width, height, rotation; //rotation is 0 deg
    private Color outCol, fillColl;
    private boolean filled;
    private FillType ft;
    
    ////////////////////////////////////////////////////////////////// 
    ////////      C O N S T R U C T O R S      ///////////////////////   
    //////////////////////////////////////////////////////////////////
    public Rectangle() {
        x = y = 0;
        width = 50;
        height = 25;
        outCol = Color.BLACK;
        fillColl = Color.CYAN;
        filled = true;
        ft = FillType.solid;
    }
     public Rectangle(Color outColIn, Color fillCollIn) {
        x = y = 0;
        width = 50;
        height = 25;
        outCol = outColIn;
        fillColl = fillCollIn;
        filled = true;
        ft = FillType.solid;
    }
    //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    //AAAAAAAAAAAAAAA  A C C E S S O R S  AAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getW(){
        return width;
    }
    public int getH(){
        return height;
    }
    public Color getOutCol(){
        return outCol;
    }
     public Color getFillCol(){
        return fillColl;
    }
    public int getArea() {
        return width * height;
    }
    
    public String toString(){
        return super.toString() + "\nRect"+" WIDTH "+ width+","+" HEIGHT " +height+".";
    }
    //MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
    //MMMMMMMMMMMMMMM  M U T A T O R S   MMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
    //MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
    public void setX(int inX) throws IllegalArgumentException{
        if (inX < 0){
            throw new IllegalArgumentException("Bad x value of " + inX);
        }
        x = inX;
    }
     public void setY(int inY){
        y = inY;
    }
    public void setWidth(int w){
        width = w;
    }
    public void setHeight(int h){
        height = h;
    }
}
