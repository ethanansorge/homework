import java.util.*;
import java.io.*;
public class MyHeap{
    public ArrayList<Integer> values;
    public boolean max;

    public MyHeap(){
	values = new ArrayList<Integer>();
	values.add(0);
	max = true;
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
		    break;
		}
	    }else{
		if (value > temp){		    
		    break;
		}
	    }
	    i = i / 2;
	}
	values.add(i, value);
    }
    public int remove(){
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
        int i = 1;
	String s = "";
	while (i < values.size()){
	    s = s + values.get(i) + ", ";
	    i = i + 1;
	}
	return s;
	    
    }
    public static void main(String [] args){
	MyHeap heap = new MyHeap(true);
	heap.add(1);
	heap.add(7);
	heap.add(6);
	heap.add(9);
	heap.remove();
	System.out.println(heap.peek());
    }
    
}
    
