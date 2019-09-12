/**
 * Author:  Sydney Walker
 * Period:  9
 * Sauce Code: 16
 * Class:   RecursionClient.java
 * Purpose: represents a 2D image
 */
import java.io.*;
import java.io.File;
import java.awt.image.BufferedImage;
import java.util.Scanner;
import javax.imageio.*;

public class GraphMap {

  private int width = 0, height = 0;

  private char[][] map; //two dimensional array of chars to represent image
  
    ////////////////////////////////////////////////////////////////// 
    ////////      C O N S T R U C T O R S      ///////////////////////   
    //////////////////////////////////////////////////////////////////

  /*****************************************************************
   *             public GraphMap(String file)
   * 
   * pre:    Get a valid filename
   * post:   Attempts to open file and read in a 50X50 map
   *         map has a sequence of .'s and *'s
   *
   *****************************************************************/

  public GraphMap(String file) {
    try {
      BufferedImage image = ImageIO.read(new File(file));
      setHeight(image.getHeight());
      setWidth(image.getWidth());
      map = new char[width][height];
      for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
          int pixel = image.getRGB(x, y);
          map[x][y] = pixel == 0xffffffff ? '.' : '*';
        }
      }
    }
    catch (IOException ex1) {
      System.out.println("IO EXCEPTION");
    }
  }
    public GraphMap(String file, boolean text) {
        try{
            //make file reader
            Scanner in = new Scanner(new File(file));
            //read in values to set width and height
            setWidth(in.nextInt());
            in.nextLine();
            setHeight(in.nextInt());
            in.nextLine();
            //initialize the map 2d array with width and height as indexes
            map = new char[width][height];
            //create variables to hold current line of the text file
            String line = "";
            char[] lineC = line.toCharArray();
            for (int y = 0; y < height; y++) {
                //get the next line of the text file
                if(in.hasNext()){
                    in.nextLine();
                    line = in.nextLine();
                    lineC = line.toCharArray();
                    System.out.println("Line: " + line + " Y: " + y);
                }
                //assign the char array values into the array
                for (int x = 0; x < width; x++) {
                    map[x][y] = lineC[x];
                }
                System.out.println("Y2: " + y);
            }
        } catch (FileNotFoundException e){
            System.out.println(e.toString());
        }
    }
    
  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  private void setHeight(int h) {
    height = h;
  }

  private void setWidth(int w) {
    width = w;
  }

  public boolean isInBounds(int x, int y) {
      if(x < 0 || y < 0 || x >= width || y >= height){
          return false;
      } else {
          return true;
      }
  }

  public char getPixel(int x, int y) {
      return map[x][y];
  }

  public char setPixel(int x, int y, char val) {
      //grab old character
      char temp = getPixel(x, y);
      map[x][y] = val;
      return temp;  
  }
}
