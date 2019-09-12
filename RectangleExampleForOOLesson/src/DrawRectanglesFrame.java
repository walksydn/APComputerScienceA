
/**
 * ---------------------------------------------------------------------------
 * S-h-e-n-e-n-d-e-h-o-w-a--H-i-g-h--S-c-h-o-o-l--T-e-c-h-n-o-l-o-g-y--D-e-p-t
 * ---------------------------------------------------------------------------
 * FILE: DrawRectangles 
 *
 * DATE:  11/22/2013
 *
 * PURPOSE: Client of the Rectangle class, Triangle Class
 *          2/10/2016:  Updated so the ArrayList is a List of the Abstract
 *                      base class Shape
 *                      Increased Font for Displaying how many rectangles there
 *                      are via the static Rectangle Count
 *
 * @author mr Hanley
 * @version 2.0
 * ----------------------------------------------------------------------------
 *
 * h-a-n-l-e-y.c-o-.-n-r------t-e-a-m-2-0-.-c-o-m----------------------------
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;

public class DrawRectanglesFrame extends JFrame implements Runnable, MouseListener{
    
    ArrayList<Shape> shapes = new ArrayList<Shape>();
    RectangleV3 r1 = new RectangleV3();
    RectangleV3 r2 = new RectangleV3(Color.BLACK, Color.RED);
    RectangleV3 r3 = new RectangleV3(Color.GRAY, Color.white);
    
    Triangle t1 = new Triangle();
    
    public DrawRectanglesFrame(){
        r1.setX(30);
        r1.setY(100);
        r2.setX(300);
        r2.setY(350);
        r1.setWidth(100);
        r1.setHeight(50);
        r2.setWidth(200);
        r2.setHeight(150);
        r3.setWidth(50);
        r3.setHeight(70);
        r3.setX(700);
        r3.setY(550);
        //Set up triangle
        t1.setVertex(0, 50, 50);
        t1.setVertex(1, 25, 100);
        t1.setVertex(2, 75, 100);
        t1.setX(180);
        t1.setY(100);
        shapes.add(r1);
        shapes.add(r2);
        shapes.add(r3);
        shapes.add(t1);
        addMouseListener(this);
        //shapes.add(t1);
    }
    
    public void paint(Graphics g){
        //Cover the background in black
        g.setFont(new Font("Consolas",Font.BOLD,36));
        g.setColor(Color.yellow);
        g.fillRect(0,30,getWidth(),getHeight()-30);
        //Draw the first rectangle
        for(int i=0; i<shapes.size();i++){
            shapes.get(i).draw(g);
            System.out.println(shapes.get(i));
        }
        //Let's print out the total number of objects
        g.setColor(Color.black);
        g.drawString(RectangleV3.rectCount+"",200,500);     
    }
    
    //Mouse Stuff
    public void mouseClicked(MouseEvent e){
        Random r = new Random();
        RectangleV3 rect = new RectangleV3(10 + r.nextInt(500), 20 + r.nextInt(700), 20 + r.nextInt(100), 30 + r.nextInt(40),
        Color.gray,Color.blue);
        shapes.add(rect);
        repaint();
    }
    public void mousePressed(MouseEvent e){
        
    }
    public void mouseReleased(MouseEvent e){
        
    }
    public void mouseEntered(MouseEvent e){
        
    }
    public void mouseExited(MouseEvent e){
        
    }
    //Maybe when I get a chance...make this Frame animated... sighs
    public void run(){
        
        
        
    }
}
