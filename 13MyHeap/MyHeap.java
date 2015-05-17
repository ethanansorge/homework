import java.util.*;
import java.io.*;
public class MyHeap{
    public ArrayList<Integer> values;
    public boolean max;

    public MyHeap(){
	this(true);
    }
    public MyHeap(boolean isMax){
	values = new ArrayList<Integer>();
	values.add(0);
	max = isMax;
    }
    public void add(int value){
	values.add(value);
	int currIndex = values.size() - 1;
	int parIndex = currIndex / 2;
	while (parIndex >= 1 &&
	       ((!max && value < values.get(parIndex)) || 
		(max && value > values.get(parIndex)))){
	    values.set(currIndex, values.get(parIndex));
	    values.set(parIndex, value);
	    currIndex = parIndex;
	    parIndex = currIndex / 2;
	}
    }
    public int remove(){
	if (values.size() == 1){
	    throw new NoSuchElementException();
	}
	if (max){
	    return values.remove(1);
	}else{
	    return values.remove(values.size() - 1);
	}
    }
    public int peek(){
	return values.get(1);
    }
    /* public String toString(){
        int index = 1;
	int newLineCounter = 1;
	int positionOnLine = 1;
	String s = "";
	while (index < values.size()){
	    s = s + values.get(index) + " ";
	    if (positionOnLine == newLineCounter){
		s = s + "\n";
		newLineCounter = newLineCounter + 2;
		positionOnLine = 1;
	    }
	    index = index + 1;
	    positionOnLine = positionOnLine + 1;
	}
	return s;
    */
    public String toString(){
        return values.toString();
    }
    public static void main(String [] args){
	MyHeap heap = new MyHeap(true);
	heap.add(1);
	heap.add(7);
        heap.add(4);
	heap.add(9);
	heap.add(2);
	heap.add(3);
	System.out.println(heap.toString() + "\n" + "\n");
	heap.remove();
	System.out.println(heap.toString() + "\n" + "\n");
	heap.remove();
	System.out.println(heap.toString() + "\n" + "\n");
	heap.remove();
	System.out.println(heap.toString() + "\n" + "\n");
	heap.remove();
	System.out.println(heap.toString() + "\n" + "\n");
	MyHeap heap2 = new MyHeap(false);
	heap2.add(1);
	heap2.add(7);
        heap2.add(4);
	heap2.add(9);
	heap2.add(2);
	heap2.add(3);
	System.out.println(heap2.toString());
    }
    
}
    
