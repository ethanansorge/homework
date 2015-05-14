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
	int i = values.size();
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
	return 0;
    }
    public int peek(){
	return values.get(1);
    }
    public String toString(){
	return "";
    }
    
}
    
