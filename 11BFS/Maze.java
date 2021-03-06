import java.util.*;
import java.io.*;

public class Maze{
    private char[][] maze;
    private int maxx,maxy;
    private int startx,starty;
    private int endx, endy;
    private String clear =  "\033[2J";
    private String hide =  "\033[?25l";
    private String show =  "\033[?25h";
    private Coordinate[] solutionCoordinates;
    private int solutionCoordsLength = 0;
    private int distanceFromStart;
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }

    public Maze(String filename){
	distanceFromStart = 0;
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
	    if (c == 'E'){
		endx = i % maxx;
		endy = i / maxx;
	    }
	}
	solutionCoordinates = new Coordinate[maxx * maxy];
	
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

    public boolean solveBFS(){
	return solveBFS(false);
    }
    public boolean solveDFS(){
	return solveDFS(false);
    }
    public boolean solveBestFirstSearch(){
	return solveBestFirstSearch(false);
    }
    public boolean solveAStart(){
	return solveDFS(false);
    }
    public boolean solveBFS(boolean animate){  
	return solve(animate, false, false, false);
    }
    public boolean solveDFS(boolean animate){
	return solve(animate, false, true, false);
    }
    public boolean solveAStar(boolean animate){
	return solve(animate, true, false, false);
    }
    public boolean solveBestFirstSearch(boolean animate){
	return solve(animate, true, false, true);
    }    

    public boolean solve(boolean animate, boolean pQue, boolean stack, boolean best){
	Coordinate head = new Coordinate(0,0,null, endx, endy, 0);
	Coordinate first = new Coordinate(startx, starty, head,endx, endy, 0);
	boolean done;
	if (pQue){
	    PriorityQueue<Coordinate> queue = new PriorityQueue<Coordinate>();
	    queue.add(first);
	    while(!queue.isEmpty()){
		Coordinate current = queue.remove(best);
		done = checkAndAdd(true, stack, current, best, animate, queue, null);
		if(done){
		    return true;
		}
	    }
	}else{
	    ArrayDeque<Coordinate> deque = new ArrayDeque<Coordinate>();
	    deque.addLast(first);
	    while(!deque.isEmpty()){
		Coordinate current = deque.removeFirst();
		done = checkAndAdd(false, stack, current, best, animate, null, deque);
		if (done){
		    return true;
		}
	    }
	}
	return false;
    }
    
    private boolean checkAndAdd(boolean pQue, boolean stack, Coordinate current, boolean best, boolean animate, PriorityQueue<Coordinate> queue, ArrayDeque deque){
	if (maze[current.getX()][current.getY()] == 'E'){
	    while(current.getPrevious() != null){
		addCoordinateToSolutionArray(current);
		current = current.getPrevious();
	    }
	    return true;
	}
	maze[current.getX()][current.getY()] = '@';
	addNeighbors(queue, deque, pQue, stack, current, best);
	maze[current.getX()][current.getY()] = '.';
	if(animate){
	    System.out.println(this);
	    wait(20);
	    if (pQue){
		System.out.println(queue.toString());
	    }else{
		System.out.println(deque.toString());
	    }
	}
	return false;
    }
    private void addIfValid(PriorityQueue<Coordinate> queue, ArrayDeque deque, boolean pQue, boolean stack, int x, int y, Coordinate previous, boolean best){
	if (0 <= x && x < maze.length && 0 <= y && y < maze[0].length){
	    if (maze[x][y] == ' ' || maze[x][y] == 'E'){
		distanceFromStart = distanceFromStart + 1;
		Coordinate next;
		if (!best){
		    next = new Coordinate(x, y, previous, endx, endy, distanceFromStart);
		}else{
		    next = new Coordinate(x, y, previous, endx, endy);
		}
		if(pQue){
		    queue.add(next);
		    
		}else{
		    if (stack){
			deque.addFirst(next);
		    }else{
			deque.addLast(next);
		    }
		}
		
	    }
	}
    }
    
    private void addNeighbors(PriorityQueue<Coordinate> queue, ArrayDeque deque, boolean pQue, boolean stack, Coordinate current, boolean best){
	addIfValid(queue, deque, pQue, stack, current.getX() + 1, current.getY(), current, best);
	addIfValid(queue, deque, pQue, stack, current.getX() - 1, current.getY(), current, best);
	addIfValid(queue, deque, pQue, stack, current.getX(), current.getY() + 1, current, best);
	addIfValid(queue, deque, pQue, stack, current.getX(), current.getY() - 1, current, best);
    }
   

   
    public int[] solutionCoordinates(){
	int[] numberCoords = new int[solutionCoordsLength * 2];
	int i = 0;
	while (i < numberCoords.length -2){
	    numberCoords[i] = (solutionCoordinates[(numberCoords.length - 2) - i]).getX();
	    numberCoords[i + 1] = (solutionCoordinates[(numberCoords.length - 2) - i]).getY();
	    i = i - 2;
	}
	return numberCoords;
    }
    
    public void addCoordinateToSolutionArray(Coordinate current){
	solutionCoordinates[solutionCoordsLength] = current;
	solutionCoordsLength = solutionCoordsLength + 1;
    }

    public void printCoords(){
	int i = solutionCoordsLength - 1;
	while (i > 1 && solutionCoordinates[i] != null){
	    System.out.print("(" + (solutionCoordinates[i]).getX() + ", " + (solutionCoordinates[i]).getY() + ")" );
	    i = i - 1;
	}
    }

    public String name(){
	return "ansorge.ethan";
    }

    public static void main (String [] args){
	Maze a = new Maze("data1.dat");
	a.solve(true, true, false, false);
	a.printCoords();
	/*
	  int i = a.solutionCoordsLength - 1;
	  while (i > 1 && a.solutionCoordinates[i] != null){
	  System.out.print("(" + (a.solutionCoordinates[i]).x + ", " + (a.solutionCoordinates[i]).y + ")" );
	  i = i - 1;
	  }
	
	  int[] xycoords = a.solutionCoordinates();
	  int x = 0;
	  while (x < xycoords.length){
	  if (x % 2 == 0){
	  System.out.print("(" + xycoords[x] + ",");
	  }else{
	  System.out.print(" " + xycoords[x]);
	  }
	  x = x + 1;
	  }
	*/
    }
}

