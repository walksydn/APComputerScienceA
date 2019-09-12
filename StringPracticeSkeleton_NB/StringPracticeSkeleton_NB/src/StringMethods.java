/**
 * ---------------------------------------------------------------------------
 * S-h-e-n-e-n-d-e-h-o-w-a--H-i-g-h--S-c-h-o-o-l--T-e-c-h-n-o-l-o-g-y--D-e-p-t
 * ---------------------------------------------------------------------------
 * FILE: StringMethods.java
 *
 * DATE:  9/29/08 Original
 *
 * PURPOSE: Logic for String Project, Shenendehowa H
 *
 * @author mr Hanley
 * @version 2.0
 * ---------------------------------------------------------------------------
 *
 * h-a-n-l-e-y.c-o-.-n-r------t-e-a-m-2-0-.-c-o-m-----------------------------
 */
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class StringMethods {

    /*****************************************************************
     *     public String pascalsTri(int levels) {
     * pre:  levels >= 3
     * post: returns a String consisting of Pascals' triangle with
     *       \t and \n as appropriate
     * example
     * levels = 3
     * \t\t1
     * \t1\t\t1
     * 1\t\t2\t\t1
     * 
     * @param levels levels of Pascal's triangle desired
     * 
     *
     *****************************************************************/
    public String pascalsTri(int levels) {
        //generate triangle values
        int[][] tri = new int[levels][levels];
        int numInRow = 1;
        for(int r = 0; r < levels; r++){
            for(int c = 0; c < numInRow; c++){
                try{
                    tri[r][c] = tri[r-1][c-1] + tri[r-1][c+1];
                } catch (Exception e){
                    System.out.println("First or Last");
                } finally {
                    
                }
            }
            numInRow++;
        }
        String output = "";
        int tabs = levels - 1;
        for(int r = 0; r < levels; r++){
            for(int i = 0; i < tabs; i++){
                output += "\t";
            }
            tabs--;
            for(int c = 0; c < levels; c++){
                if(tri[r][c] == 0){
                    output += "\n";
                } else {
                    output += tri[r][c] + "\t";
                }                    
            }
        }
        return output;
    }

    /*****************************************************************
     *       public int numWords(String word) {
     * pre: there can only be one space between words, no characters 
     *      outside of the alphabet
     * post: returns the number of words in the song title
     *
     *****************************************************************/
    public int numWords(String word) {
        int num = 0, index = 0;        
        while(word.indexOf(" ", index) > 0){
            index = word.indexOf(" ", index);
            num++;
        }
        return num;            
    }
    
    /*****************************************************************
     *       public String findTitle(String html)
     * pre: pass an html script for a website into the method
     * post: returns the title of the website
     *
     *****************************************************************/
    public String findTitle(String html) {
        int start = html.indexOf("<title>");
        int end = html.indexOf("</title>");
        if(start == -1 && end == -1){
            return "No Title";
        }
        return html.substring(start+7, end); 
    }

    /*****************************************************************
     *       public String findLinks(String html, String title)
     * pre: pass a complete html script for a website into the method
     * post: returns an ArrayList<String> of the links
     *
     *****************************************************************/
    public ArrayList<String> findLinks(String html) {
        //count all hyperlinks
        ArrayList<String> links = new ArrayList<>();
        int index = 0; //last found index of a beginning of the link
        while(html.indexOf("<link href = \"", index) != -1){
            index = html.indexOf("<link href = \"");
            int start = index;
            int end = html.indexOf("\"", index);
            links.add(html.substring(start, end + 1));
        }
        return links;
    }
    /*****************************************************************
     *       public boolean passwordVerify(String text)
     * pre:  pass in pw
     * post: true if len>=6 and one non letter
     *
     *****************************************************************/
    public boolean passwordVerify(String text) {
        boolean notChar = false; //indicates if there is a character other than a letter
        for(int i = 0; i < text.length(); i++){
            if(text.charAt(i) < 65 || (text.charAt(i) > 90 && text.charAt(i) < 97) || text.charAt(i) > 122){
                notChar = true;
            }
        }
        if(text.length() >= 6 && notChar){
            return true;
        } else {
            return false;
        }
    }
    /*****************************************************************
     *      public String openURL(String url) props to Josh Komoroske
     * pre:  pass in a url with http:// in front
     * post: returns the page source if possible
     *
     *****************************************************************/
    public String openURL(String url) throws Exception {
        URL server = null;
        try {
            server = new URL(url); //connect to the target URL
        } catch (MalformedURLException m) {
            throw new Exception(m);
        }

        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(server.openStream())); //open a new stream buffer
        } catch (IOException i) {
            throw new Exception(i);
        }

        String pageSource = "", sourceLine;
        try {
            while ((sourceLine = in.readLine()) != null) { //keep building the string until there is no more to read
                pageSource += sourceLine + "\n";
            }

        } catch (IOException i) {
            throw new Exception(i);
        }

        try {
            in.close(); //close the connection to the server
        } catch (IOException i) {
            throw new Exception(i);
        }
        return pageSource;
    }
}