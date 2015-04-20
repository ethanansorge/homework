public class Coordinate implements Comparable<Coordinate>{
    public static int endX, endY;
    public int x, y;
    public Coordinate previous;

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
}
