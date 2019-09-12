/**
 * Author:  Sydney Walker
 * Period:  9
 * Sauce Code: 16
 * Class:   SmileyFace.java
 * Purpose: creates a frame and handles mouse clicks, drawing smiley faces
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;

public class DrawSmileyFaceFrame extends JFrame{// implements MouseListener{
    
    SmileyFace face = new SmileyFace(50, 50, Color.BLACK, Color.WHITE);

    public DrawSmileyFaceFrame(){
//        addMouseListener(this);
    }
    
    @Override
    public void paint(Graphics g){
        //Cover the background in black
        g.setFont(new Font("Consolas",Font.BOLD,36));
        g.setColor(Color.blue);
        g.fillRect(0, 0, getWidth(), getHeight());
        //Draw the SmileyFace
        face.draw(g);
        System.out.println("Drew Face");
        //Let's print out the total number of objects
        g.setColor(Color.black);
        g.drawString(RectangleV3.rectCount+"",200,500);     
    }
    
//    //Mouse Stuff
//    public void mouseClicked(MouseEvent e){
//        Random r = new Random();
//        SmileyFace s = new SmileyFace(r.nextInt(1000), r.nextInt(1000));
//        s.draw(null);
//        repaint();
//    }
//    public void mousePressed(MouseEvent e){
//        
//    }
//    public void mouseReleased(MouseEvent e){
//        
//    }
//    public void mouseEntered(MouseEvent e){
//        
//    }
//    public void mouseExited(MouseEvent e){
//        
//    }
}
