public class Coordinate implements Comparable<Coordinate>{
    private int endX, endY;
    private int x, y;
    private Coordinate previous;

    public Coordinate(){
    }

    public Coordinate(int x, int y, Coordinate previous){
	this.x = x;
	this.y = y;
	this.previous = previous;
    }
    public static int distance (Coordinate c){
	return ( Math.abs(c.x - endX) + Math.abs(c.y = endY));
    }

    public int compareTo(Coordinate other){
	return (distance(this) - distance(other));
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
    public void setEndX(int newEndX){
	endX = newEndX;
    }
    public void setEndY(int newEndY){
	endY = newEndY;
    }
}
