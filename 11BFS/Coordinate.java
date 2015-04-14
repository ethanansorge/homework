public class Coordinate{
    public  int x, y;
    public Coordinate next;
    
    public Coordinate(int x, int y){
	Coordinate(x, y, null);
    }
    public Coordinate(int x, int y, Coordinate next){
	this.x = x;
	this.y = y;
	this.next = next;
    }
}
