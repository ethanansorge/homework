import java.util.*;
import java.io.*;
public class Maze{
    private char[][] maze;
    private int maxx,maxy;
    private int startx,starty;
    private String clear =  "\033[2J";
    private String hide =  "\033[?25l";
    private String show =  "\033[?25h";
    
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }

    public Maze(String filename){
	startx = -1;
	starty = -1;
	//read the whole maze into a single string first
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));

	    //keep reading next line
	    while(in.hasNext()){
		String line = in.nextLine();
		if(maxy == 0){
		    //calculate width of the maze
		    maxx = line.length();
		}
		//every new line add 1 to the height of the maze
		maxy++;
		ans += line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: " + filename + " could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}

	//copy from the single string to a 2D array
	maze = new char[maxx][maxy];
	for(int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    maze[i % maxx][i / maxx] = c;
	    if(c == 'S'){
		startx = i % maxx;
		starty = i / maxx;
	    }
	}
    }	    

    private String color(int foreground,int background){
	return ("\033[0;" + foreground + ";" + background + "m");
    }

    public void clearTerminal(){
	System.out.println(clear);
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }
    public String toString(){
	return toString(false);
    }
    public String toString(boolean animate){
	String ans = "Solving a maze that is " + maxx + " by " + maxy + "\n";
	for(int i = 0; i < maxx * maxy; i++){
	    if(i % maxx == 0 && i != 0){
		ans += "\n";
	    }
	    char c =  maze[i % maxx][i / maxx];
	    if(c == '#'){
		ans += color(38,47)+c;
	    }else{
		ans += color(32,40)+c;
	    }
	}
	return hide + go(0,0) + ans + "\n" + show + color(37,40);
    }

    public boolean solveBFS(boolean animate){  
	return solve(animate, true);
    }
    public boolean solveDFS(boolean animate){
	return solve(animate, false);
    }
    private boolean solve(boolean animate, boolean stack){
	ArrayDeque<Coordinate> deque = new ArrayDeque<Coordinate>();
	deque.addLast(new Coordinate(startx, starty));
	while(!deque.isEmpty()){
	    Coordinate current = deque.removeFirst();
	    
	    if (maze[current.x][current.y] == 'E'){
		return true;
	    }
	    maze[current.x][current.y] = '@';
	    addNeighbors(deque, stack, current);
	    maze[current.x][current.y] = '.';
	    System.out.println(this);
	    wait(20);
	}
	return false;
    }

    private void addIfValid(ArrayDeque<Coordinate> deque, int x, int y, boolean stack){
	if (0 <= x && x < maze.length && 0 <= y && y < maze[0].length){
	    if (maze[x][y] == ' '){
		if (stack){
		    deque.addFirst(new Coordinate(x, y));
		}else{
		    deque.addLast(new Coordinate(x, y));
		}
	    }
	}
    }
    
    private void addNeighbors(ArrayDeque<Coordinate> deque, boolean stack, Coordinate current){
	addIfValid(deque, current.x + 1, current.y, stack);
	addIfValid(deque, current.x - 1, current.y, stack);
	addIfValid(deque, current.x, current.y + 1, stack);
	addIfValid(deque, current.x, current.y - 1, stack);
    }
   

    public boolean solveBFS(){
	return solveBFS(false);
    }
    public boolean solveDFS(){
	return solveDFS(false);
    }
    /*public int[] solutionCoordinates(){
      }
    */
    public String name(){
	return "ansorge.ethan";
    }
    public static void main (String [] args){
	Maze a = new Maze("data1.dat");
	a.solveBFS(true);
	System.out.println(a);
    }
}

// BFS keeps adding possible moves to a queue, it takes each one and adds the next possible moves to the end//
