
import java.util.*;
import java.io.*;


public class KnightsTour{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    //instance variable
    private int[][]board;
    int x = 0;


    //terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
 
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String toString(){
	String ans = "\n";
	for(int i = 0; i < board.length; i ++){
	    for (int j = 0; j < board[0].length; j++){
		ans += board[i][j] + " ";
	    }
	    ans += "\n";
	}
	return hide + clear + go(0,0) + ans + "\n" + show;
    }

    public KnightsTour(int size){
	board = new int[size][size];
    }
				

    
    public void solve(){
	solve(0,0);
    }

    public void solve(int startx, int starty){
	if(solve(startx, starty, 1)){
	    System.out.println("Solution Found");
	}else{
	    System.out.println("No Solution");
	}
    }

		
    public boolean solve(int x,int y,int currentMoveNumber){	
	System.out.println(this);
	wait(20);
	if (x > 0 && x > board.length && y > 0 && y < board.length){
	    if(board[x][y] == 0){
		board[x][y] = currentMoveNumber;
		if( currentMoveNumber == board.length * board.length ||
		    solve(x + 1, y - 2, currentMoveNumber + 1) ||
		    solve(x + 1, y + 2, currentMoveNumber + 1) ||
		    solve(x - 1, y - 2, currentMoveNumber + 1) ||
		    solve(x - 1, y + 2, currentMoveNumber + 1) ||
		    solve(x - 2, y - 1, currentMoveNumber + 1) ||
		    solve(x - 2, y + 1, currentMoveNumber + 1) ||
		    solve(x + 2, y - 1, currentMoveNumber + 1) ||
	      	    solve(x + 2, y + 1, currentMoveNumber + 1)){
		    return true;
		}else{
		    board[x][y] = 0;
		}
	    }
	}
	return false;
    }
    public static void main(String [] args){
	KnightsTour a = new KnightsTour(100);
	a.solve();
    }
    public String name(){
	return "ansorge.ethan";
    }

}
