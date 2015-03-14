public class MyLinkedList{
    LNode firstNode, lastNode;
    int size;

    public MyLinkedList(){
	size = 0;
	firstNode = null;
	lastNode = null;
    }
    
    public void set(int index, int  value){
	LNode a = get(index);	
	a.setData(value);
    }

    public void add(int value){
	LNode a = new LNode(value);
	if (size == 0){
	    lastNode = a;
	}else{
        lastNode.setNextNode(a);
	lastNode = a;
	}
	size = size + 1;
    }

    public LNode get(int index){
	int i = 0;
	LNode temp = firstNode;
	while (i < index){
	    temp = temp.getNextNode();
	    i = i + 1;
	}
	return temp;
    }
    
    public void add(int index, int value){
	LNode a = new LNode(value);
	if (size == 0){
	    lastNode = a;
	}else{
	LNode oneBefore = get(index - 1);
	LNode current = get(index);
	oneBefore.setNextNode(a);
	a.setNextNode(current);
	}
	size = size + 1;
    }

    public int remove(int index){
	LNode oneBefore = get(index - 1);
	LNode oneAfter = get(index + 1);
	LNode current = get(index);
	int a = current.getData();
	oneBefore.setNextNode(oneAfter);
	size = size - 1;
	return a;
    }

    public int size(){
	return size;
    }

    public String toString(){
	String ans = "[ ";
	LNode temp = firstNode;
	while (temp != null){
	    ans = ans + temp.getData() + ",";
	    temp = temp.getNextNode();
	}
	return ans + " ]";
    }
    
    public int indexOf(int value){
	int i = 0;
	LNode a = firstNode;
	while (a.getNextNode() != null){
	    if(value == a.getData()){
		break;
	    }else{
		i = i + 1;
	    }
	}
	return i;
    }

    public static void main (String[]args){
	MyLinkedList c = new MyLinkedList();
	c.add(5);
	c.add(2);
	c.add(3);
	System.out.println(c);
    }
}
