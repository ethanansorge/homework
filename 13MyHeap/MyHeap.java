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
	int i = values.size() - 1;
	int temp;
	while (i > 1){
	    temp = values.get(i);
	    if (max){
		if (value < temp){		    
		    values.add(i, value);
		    return;
		}
	    }else{
		if (value > temp){		    
		    values.add(i, value);
		    return;
		}
	    }
	    i = i / 2;
	}
	values.add(i, value);
	values.remove(values.size() - 1);
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
    public String toString(){
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
    
