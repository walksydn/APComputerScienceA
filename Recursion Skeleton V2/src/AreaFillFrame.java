/**
 * Author:  Sydney Walker
 * Period:  9
 * Sauce Code: 16
 * Class:   RecursionClient.java
 * Purpose: represents a 2D image
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AreaFillFrame
    extends JFrame implements ActionListener, KeyListener {

  private int pixelWidth = 1, pixelHeight = 1, pixelMarginTop = 0,
  pixelMarginRight = 0;

  private GraphMap gm; //This contains the image we will be rendering

  private JButton buttons[][];

  private GridLayout gridLayout1;


  /*
     * **************************************************************
       public void copyMapToScreen() 
       pre: 
       post: Associates the global graphmap
             with the buttons on the screen using image icons, 
             boy I wish we could get
             this to update button by button.......
      
     ****************************************************************
     */
    private void copyMapToScreen() {
        //Colors are in RGB format 0..255 for each
        for (int y = 0; y < gm.getHeight(); y++) {
            for (int x = 0; x < gm.getWidth(); x++) {
                switch (gm.getPixel(x, y)) {

                    case '*':  //Wall or black
                        buttons[x][y].setBackground(Color.BLACK);
                        break;

                    case '@'://First Click of each fill
                        buttons[x][y].setBackground(new Color(0x99ff00));
                        break;

                    case '&': //Subsequent pixels after first click
                        buttons[x][y].setBackground(new Color(0xcccc00));
                        break;

                    case '.'://Space or white
                        buttons[x][y].setBackground(Color.RED);
                        break;
                }
            }
        }
    }



  /*****************************************************************
   * public void areaFill(int x, int y)
   *
   * pre:   Button clicked or a disturbance in the force
   * post:  Fill that pig
   *
   *****************************************************************/
 private void areaFill(int x, int y) {
    //if the point is in bounds and black, spread in all directions
    if(gm.isInBounds(x, y) && gm.getPixel(x, y) == '.'){
        gm.setPixel(x, y, '&');
        areaFill(x, y+1);
        areaFill(x+1, y);
        areaFill(x, y-1);
        areaFill(x-1, y);
    } 
    //updates the pixels on frame
    this.copyMapToScreen();
  }
  /*
     * ***************************************************************
     * public AreaFillFrame(String file,int w, int h, int x, int y) 
        pre: 
        post: Let's get this party started!!
     *
     ****************************************************************
     */
    public AreaFillFrame(String file, int w, int h, int x, int y) {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setResizable(false);

        gm = new GraphMap(file);

        this.setPixelSize(w, h);

        this.setPixelMargins(x, y);

        try {
            jbInit();
            copyMapToScreen();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

  /*****************************************************************
   *             public void actionPerformed(ActionEvent e)
   * pre:
   * post:  figures out which button was pressed and kicks off
   *        recursive areaFill
   *
   *****************************************************************/

  public void actionPerformed(ActionEvent e) {
    Point p = getButtonPos( (JButton) e.getSource()); //this tells us
    int x = p.x, y = p.y;
    if (gm.getPixel(x, y) == '.') {
      areaFill(x, y);
      gm.setPixel(x, y, '@'); //when done, over-write the click spot with a
                              //@ symbol so we know where we clicked!!!
    }
    this.copyMapToScreen();
  }

  /*****************************************************************
   *            private Point getButtonPos(JButton b) {
   *
   * pre:  pass in the mystery JButton that was clicked, (non null)
   * post: returns the Point x = col, y = row for the button clicked
   *       else returns -1,-1 if couldn't find a match
   *
   *****************************************************************/

  private Point getButtonPos(JButton b) {
    for (int y = 0; y < gm.getHeight(); y++) {
      for (int x = 0; x < gm.getWidth(); x++) {
        if (buttons[x][y] == b) {
          return new Point(x, y);
        }
      }
    }
    return new Point( -1, -1); //not found, shouldn't happen!
  }


  public void setPixelSize(int w, int h) {
    pixelWidth = w;
    pixelHeight = h;
  }

  public void setPixelMargins(int x, int y) {
    pixelMarginTop = y;
    pixelMarginRight = x;
  }

  public Point getGridSize() {
    return new Point(gm.getWidth(), gm.getHeight());
  }

  public void resizeToFit(int x, int y, int bx, int by) {
    Dimension Screen = Toolkit.getDefaultToolkit().getScreenSize();
    this.setSize(bx + (pixelWidth + pixelMarginRight) * gm.getWidth(),
                 by + (pixelHeight + pixelMarginTop) * gm.getHeight());
    Point Location = this.getLocation();
    this.setLocation(x == -1 ? (Screen.width - this.getWidth()) / 2 :
                     Location.x,
                     y == -1 ? (Screen.height - this.getHeight()) / 2 :
                     Location.y);
  }

  public void setFullscreen(boolean m) {
    Dimension Screen = Toolkit.getDefaultToolkit().getScreenSize();
    if (m && !this.isVisible()) {
      this.setUndecorated(true);
      this.setBounds(0, 0, Screen.width, Screen.height);
      this.setVisible(true);
    }

  }

  private void jbInit() throws Exception {

        //Make an array of JButtons the appropriate size
        buttons = new JButton[gm.getWidth()][gm.getHeight()];

        //Make a grid layout for each of the pixels
        //gridLayout1 = new GridLayout(gm.getWidth(), gm.getHeight());
        //Instanciate the individual buttons
        for (int y = 0; y < gm.getHeight(); y++) {
            for (int x = 0; x < gm.getWidth(); x++) {
                buttons[x][y] = new JButton();

            }
        }

        this.getContentPane().setLayout(null);

        for (int y = 0; y < gm.getHeight(); y++) {
            for (int x = 0; x < gm.getWidth(); x++) {
                this.getContentPane().add(buttons[x][y]);
                buttons[x][y].addActionListener(this);
                buttons[x][y].addKeyListener(this);
                buttons[x][y].setBorder(null);
                buttons[x][y].setBounds(x * (pixelWidth + pixelMarginRight),
                        y * (pixelMarginTop + pixelHeight), pixelWidth,
                        pixelHeight);
            }
        }
    }
  /*#################################################################
         public void clearFrame(){
     
       pre: 
       post: clear all components off this contentPane 
        
     
     ################################################################*/
    public void clearFrame(){
        getContentPane().removeAll();
    }

    //Key Listener
    @Override
    public void keyTyped(KeyEvent ke) {
        if (ke.getKeyChar() == KeyEvent.VK_SPACE) {
            String filename;
            JFileChooser fc = new JFileChooser();
            int rc = fc.showDialog(null, "Select Data File");

            if (rc == JFileChooser.APPROVE_OPTION) {
                //The user chose a file, let's see if we can open it
                File file = fc.getSelectedFile();
                filename = file.getAbsolutePath();
                gm = new GraphMap(filename, true);
                clearFrame();
                try {
                    jbInit();
                } catch (Exception ex) {
                    Logger.getLogger(AreaFillFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                resizeToFit(-1, -1, 4, 10);
                
                copyMapToScreen();
            }
        }

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
