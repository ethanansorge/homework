public MyLinkedList{
  
    LNode firstNode, lastNode;
    int size;

    public class MyLinkedList{
	size = 0;
	firstNode = null;
	lastNode = null;
    }
    
    public int get(int index){
	int x = 0;
	LNode returned = first;
	while (x < index){
	    returned = returned.getNextNode(); 
	    x = x + 1;
	}
	return returned;
    }

    public void set(int index, int  value){
	nodeArray
    }

    public void add(int value){
	size = size + 1;
    }
    
    public void add(int index, int value){
	size = size + 1;
    }

    public int remove(int index){
	size = size - 1;
    }

    public int size(){
	return size;
    }

    public String toString(){
	String ans = "[ ";
	LNode temp = head;
	while (temp != null){
	    ans = ans + temp.getData() + ",";
	    temp = temp.getNext();
	return ans + " ]";
    }
    
    public int indexOf(int value){
    }
    public static void main (String[]args){
	MyLinkedList c = new MyLinkedList();
	c.add(5);
	c.add(2);
	c.add(3);
	System.out.println(c);}
