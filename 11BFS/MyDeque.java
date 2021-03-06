import java.util.*;

public class MyDeque <T extends Comparable<T>>{
    ArrayList<T> elements = new ArrayList<T>();

    public void add (T value){
	int i = elements.size();
	elements.add(null);
	while( i > 0 && elements.get(i - 1).compareTo(value) < 0){
	    elements.set(i, elements.get(i - 1));
	    i = i - 1;
	}
	elements.set(i, value);
    }
	// Loop through elements starting at back
	   // Continue if the element you are adding is greater than the one before
	   // Shift elements over
        // Add element to apporpriate spot 
    public String toString(){
	return elements.toString();
    }

    public T remove(){
	return elements.remove(elements.size() - 1);
    }
    
    public boolean isEmpty(){
	return elements.isEmpty();
    }

    public static void main(String [] args){
	MyDeque<Integer> test = new MyDeque<Integer>();
	int i = 0;
	while (i < 10){
	    test.add((int) (Math.random() * 100 ));
	    i = i + 1;
	}
	System.out.println(test.toString());
    }
}
