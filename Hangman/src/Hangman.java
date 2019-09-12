
import java.util.ArrayList;
import java.util.Random;

/**
 * Author:  Sydney Walker
 * Period:  9
 * Class:   Hangman.java
 * Purpose: creates a hangman board
 */

public class Hangman {
    private ArrayList<String> answers;
    private String word ;
    private String[] found;
    private int numWrong = 0;
    private ArrayList<Integer> used;
    
    public Hangman(){
        answers = new ArrayList<>();
        used = new ArrayList<>();
    }

    public void addAnswer(String answer){
        answer = answer.toLowerCase();
        answers.add(answer);
    }
    
    public boolean selectAnswer(){
        if(used.size() == answers.size()){
            return false;
        }
        boolean good = true;
        Random r = new Random();
        int i = r.nextInt(answers.size());
        for(int j = 0; j < used.size(); j++){
            if(i == used.get(j)){
                good = false;
            }
        }
        if(good){
            used.add(i);
            word = answers.get(i);
            found = new String[word.length()];
            return true;
        } else {
            selectAnswer();
        }
        return true;
    }

    public void reset(){
        numWrong = 0;
    }
    
    public boolean guessALetter(String letter){
        boolean goodLetter = false;
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == letter.toCharArray()[0]){
                goodLetter = true;
                found[i] = letter;
            }
        }
        if(!goodLetter){
            numWrong++;
        }
        if(check()){
            return true;
        }
        return false;
    }
    
    private boolean check(){
        String got = "";
        for(int i = 0; i < found.length; i++){
            got += found[i];
        }
        return word.equals(got);
    }
    
    public int getNumWrong(){
        return numWrong;
    }

    public String getMan(){
        String out = "";
        switch(numWrong){
            case 1:
                out += "     -----     \n";
                out += "     |   |     \n";
                out += "     -----     \n";
                break;
            case 2:
                out += "     -----     \n";
                out += "     |   |     \n";
                out += "     -----     \n";
                out += "       |       \n";
                out += "       |       \n";
                out += "       |       \n";
                out += "       |       \n";
                out += "       |       \n";
                break;
            case 3:
                out += "     -----     \n";
                out += "     |   |     \n";
                out += "     -----     \n";
                out += "       |       \n";
                out += "       |       \n";
                out += " ------|       \n";
                out += "       |       \n";
                out += "       |       \n";
                break;
            case 4:
                out += "     -----     \n";
                out += "     |   |     \n";
                out += "     -----     \n";
                out += "       |       \n";
                out += "       |       \n";
                out += " ------|------ \n";
                out += "       |       \n";
                out += "       |       \n";
                break;                
            case 5:
                out += "     -----     \n";
                out += "     |   |     \n";
                out += "     -----     \n";
                out += "       |       \n";
                out += "       |       \n";
                out += " ------|------ \n";
                out += "       |       \n";
                out += "       |       \n";
                out += "      /        \n";
                out += "     /         \n";
                out += "    /          \n";
                out += "   /           \n";
                break;                
            case 6:
                out += "     -----     \n";
                out += "     |   |     \n";
                out += "     -----     \n";
                out += "       |       \n";
                out += "       |       \n";
                out += " ------|------ \n";
                out += "       |       \n";
                out += "       |       \n";
                out += "      /\\      \n";
                out += "     /  \\       \n";
                out += "    /    \\       \n";
                out += "   /      \\      \n";
                break;
        }
        return out;
    }
    public String toString(){
        String out = "";
        for(int i = 0; i < found.length; i++){
            if(found[i] == null){
                out += " _ ";
            } else {
                out += found[i];
            }
        }
        return out;
    }
}