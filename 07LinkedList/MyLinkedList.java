public MyLinkedList{
    
    LNode firstNode;
    
    public int get(int index){
	return nodeArray;
    }

    public void set(int index, int  value){
	nodeArray
    }

    public void add(int value){
    }
    
    public void add(int index, int value){
    }

    public int remove(int index){
    }

    public int size(){
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
	System.out.println(c);
}