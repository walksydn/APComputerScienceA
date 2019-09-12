
/**
 * ---------------------------------------------------------------------------
 * S-h-e-n-e-n-d-e-h-o-w-a--H-i-g-h--S-c-h-o-o-l--T-e-c-h-n-o-l-o-g-y--D-e-p-t
 * ----------------------------------------------------------------------------
 * FILE: Triangle.java
 *
 * DATE:  1/7/2014
 *
 * PURPOSE: Extends Shape and has a polymorphic draw method 
 *
 * @author mr Hanley
 * @version 1.0
 * ----------------------------------------------------------------------------
 *
 * h-a-n-l-e-y.c-o-.-n-r------t-e-a-m-2-0-.-c-o-m----------------------------
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


public class Triangle extends Shape {
    //----------------------------------------------------------------
    //---------------- I N S T A N C E  V A R I A B L E S ------------
    //----------------------------------------------------------------
    private Point [] vertices;  //list of X,Y points relative to 0,0 upper left

    ////////////////////////////////////////////////////////////////// 
    ////////      C O N S T R U C T O R S      ///////////////////////   
    //////////////////////////////////////////////////////////////////
    public Triangle() {
        vertices = new Point[3];
        for (int i = 0; i < 3; i++) {
            vertices[i] = new Point(0,0);
        }
    }

    public Triangle(Color outColIn, Color fillCollIn) {
     super(outColIn, fillCollIn);  //pass it up to parent class
    }
    //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    //AAAAAAAAAAAAAAA  A C C E S S O R S  AAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    
    
    public void draw(Graphics g){
        //Draw the first rectangle
        g.setColor(getOutCol());
        //Must pass in an array of points for a polygon
        //This array is relative to where in the canvas the shape is
        int[]xpts = new int[vertices.length];
        int[]ypts = new int[vertices.length];
        //Loop and copy x points to x
        for (int i = 0; i < vertices.length; i++) {
            ypts[i] = (int)vertices[i].getX();
            xpts[i] = (int)vertices[i].getY();
            
        }
        g.translate(getX(), getY());
        g.drawPolygon(xpts, ypts, vertices.length);
        //g.setColor(getFillCol());
        //g.fillRect(getX()+1, getY()+1, width-1, height-1);
    }
    //MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
    //MMMMMMMMMMMMMMM  M U T A T O R S   MMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
    //MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
    public void setVertex(int which, int x, int y){
        vertices[which].x=x;
        vertices[which].y=y;
    }

}
