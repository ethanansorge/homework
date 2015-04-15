public class Coordinate{
    public int x, y;
    public Coordinate previous;
    
    public Coordinate(int x, int y, Coordinate previous){
	this.x = x;
	this.y = y;
	this.previous = previous;
    }
}
