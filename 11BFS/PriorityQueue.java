import java.util.*;

public class PriorityQueue <T extends Comparable<T>>{
    ArrayList<T> elements = new ArrayList<T>();

   
    public String toString(){
	return elements.toString();
    }
    
    public void add (T value){
	elements.add(value);
    }
    
    public T remove(){
	int i = elements.size();
	if (i == 1){
	    return elements.remove(0);
	}
	int smallestIndex = i - 1;
	while( i > 0){
	    if (elements.get(i - 1).compareTo(elements.get(smallestIndex)) < 0){
		smallestIndex = i - 1;
		/*	temp = elements.get(i - 1);
		elements.set(i - 1, smallest);
		smallest = temp;
		*/
	    }
	    i = i - 1;
	}
	return elements.remove(smallestIndex);
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
	test.remove();
	System.out.println(test.toString());
	test.remove();
	System.out.println(test.toString());
	test.remove();
	System.out.println(test.toString());
	test.remove();
	System.out.println(test.toString());
	test.remove();
	System.out.println(test.toString());
	test.remove();
	System.out.println(test.toString());
	test.remove();
	System.out.println(test.toString());

    }
}
