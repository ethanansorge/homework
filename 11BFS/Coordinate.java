public class Coordinate implements Comparable<Coordinate>{
    private int endX, endY;
    private int x, y;
    private Coordinate previous;
    private int distanceFromStart;
    public Coordinate(){
    }
     public Coordinate(int x, int y, Coordinate previous, int endX, int endY){
	 this(x,y,previous,endX,endY,0);
     }
    public Coordinate(int x, int y, Coordinate previous, int endX, int endY, int distanceFromStart){
	this.x = x;
	this.y = y;
	this.previous = previous;
	this.endX = endX;
	this.endY = endY;
	this.distanceFromStart = distanceFromStart;
    }
    public static int distance (Coordinate c){
	return ( Math.abs(c.getX() - c.getEndX()) + Math.abs(c.getY() - c.getEndY()));
    }
    public int getDistanceFromStart(){
	return distanceFromStart;
    }
    
    public int compareTo(Coordinate other){
	return ((distance(this) + this.getDistanceFromStart())- (other.getDistanceFromStart() + distance(other)));
    }
    public String toString(){
	return x + ", " + y;
    }
    
    public Coordinate getPrevious(){
	return previous;
    }
    public int getX(){
	return x;
    }
    public int getY(){
	return y;
    }
    public void setPrevious(Coordinate c){
	previous = c;
    }
    public void setX(int newX){
	x = newX;
    }
    public void setY(int newY){
	y = newY;
    }
    public int getEndX(){
	return endX;
    }
    public int getEndY(){
	return endY;
    }
}
