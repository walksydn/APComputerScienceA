/**
 * Author:  Sydney Walker
 * Period:  9
 * Class:   ConnectBoard.java
 * Purpose: stores the information for a ConnectBoard
 */

public class ConnectBoard {
    private final String[][] board;
    private int numMoves = 0, lastRowDropped = 0;
    
    /**
     * initializes the board 2D array
     */
    public ConnectBoard(){
        board = new String[6][7];
    }
    
    /**
     * @param col: column to drop in
     */
    public void dropPiece(int col){
        boolean dropped = false;
        for(int r = board.length-1; r > -1; r--){
            if(board[r][col] == null){
                board[r][col] = getPlayerSymbol();
                lastRowDropped = r;
                numMoves++;
                dropped = true;
                break;
            }
        }
        if(!dropped)
            System.out.println("Error: Column " + col + " is full!");
    }

    /**
     * @param c: column entered
     * @return 0 = tie, 1 = player 1 win, 2 = player 2 win, 3 = nobody won
     */
    public int checkWin(int c){
        if(numMoves > 41){
            return 0;
        }
        if(winHorizontal(lastRowDropped, c)){
            if(numMoves%2 == 0){
                return 1;
            } else {
                return 2;
            }
        } else if(winVertical(lastRowDropped, c)){
            if(numMoves%2 == 0){
                return 1;
            } else {
                return 2;
            }
        } else if(winDiagonal(lastRowDropped, c)){
            if(numMoves%2 == 0){
                return 1;
            } else {
                return 2;
            }
        }
        return 3;
    }
    
    private boolean winHorizontal(int r, int c){
        int numInRow = 0;
        for(int i = c+1; i < board[0].length; i++){
            if(c == board[0].length){
                break;
            }
            if(board[r][i] != null && board[r][i].equals(board[r][c])){
                numInRow++;
            } else {
                break;
            }
        }
        for(int x = c-1; x > -1; x--){
            if(x == -1){
                break;
            }
            if(board[r][x] != null && board[r][x].equals(board[r][c])){
                numInRow++;
            } else {
                break;
            }
        }
        return numInRow > 3;
    }

    private boolean winVertical(int r, int c){
        int numInCol = 1;
        for(int i = r+1; i < board.length; i++){
            if(r == board.length){
                break;
            }
            if(board[i][c] != null && board[i][c].equals(board[r][c])){
                numInCol++;
            } else {
                break;
            }
        }
        for(int x = r-1; x > -1; x--){
            if(x == -1){
                break;
            }
            if(board[x][r] != null && board[x][r].equals(board[r][c])){
                numInCol++;
            } else {
                break;
            }
        }
        return numInCol > 3;
    }

    private boolean winDiagonal(int r, int c){
        int numInLine = 1;
        for(int i = 1; i < board.length-r; i++){
            if(r+i == board.length || c+i == board[0].length){
                break;
            }
            if(board[r+i][c+i] != null && board[r+i][c+i].equals(board[r][c])){
                numInLine++;
            } else {
                break;
            }
        }
        for(int j = 1; j < board.length-(board.length-r); j++){
            if(r-j == -1 || c-j == -1){
                break;
            }
            if(board[r-j][c-j] != null && board[r-j][c-j].equals(board[r][c])){
                numInLine++;
            } else {
                break;
            }
        }
        if(numInLine > 3){
            return true;
        }
        numInLine = 1;
        for(int i = 1; i < board.length-r; i++){
            if(r+i == board.length || c-i == -1){
                break;
            }
            if(board[r+i][c-i] != null && board[r+i][c-i].equals(board[r][c])){
                numInLine++;
            } else {
                break;
            }
        }
        for(int j = 1; j < board.length-(board.length-r); j++){
            if(r-j == -1 || c+j == board[0].length){
                break;
            }
            if(board[r-j][c+j] != null && board[r-j][c+j].equals(board[r][c])){
                numInLine++;
            } else {
                break;
            }
        }
        return numInLine > 3;
    }
    public void reset(){
        numMoves = 0;
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                board[r][c] = null;
            }
        }
    }
    
    /**
     * @return the symbol of the current player
     */
    public String getPlayerSymbol(){
        if(numMoves%2 == 0){
            return "X";
        } else {
            return "O";
        }
    }
    
    /**
     * @return a string containing the board, X is player 1, O is player 2, _ is a blank spot
     */
    public String toString(){
        String out = "";
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if(board[r][c] != null){
                    out += board[r][c] + " ";
                } else {
                    out += "_ ";
                }
            }
            out += "\n";
        }
        return out;
    }
}
