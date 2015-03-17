public class MyLinkedList<T>{
    LNode<T> firstNode;
    LNode<T> lastNode;
    int size;

    public MyLinkedList(){
	size = 0;
	firstNode = null;
	lastNode = null;
    }
    
    public void set(int index, T value){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	LNode<T> a = get(index);	
	a.setData(value);
    }

    public void add(T value){
	LNode<T> a = new LNode<T> (value);
	if (size == 0){
	    firstNode = a;
	    lastNode = a;
	}else{
	    lastNode.setNextNode(a);
	    lastNode = a;
	}
	size = size + 1;
    }

    public LNode<T> get(int index){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	int i = 0;
	LNode<T> temp = firstNode;
	while (i < index){
	    temp = temp.getNextNode();
	    i = i + 1;
	}
	return temp;
    }
    
    public void add(int index, T value){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	LNode<T> a = new LNode<T> (value);
	if (size == 0){
	    lastNode = a;
	}else{
	    LNode<T> oneBefore = get(index - 1);
	    LNode<T> current = oneBefore.getNextNode();
	    oneBefore.setNextNode(a);
	    a.setNextNode(current);
	}
	size = size + 1;
    }

    public void remove(int index){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	LNode<T> oneBefore = get(index - 1);
	LNode<T> current = oneBefore.getNextNode();
	LNode<T> oneAfter = current.getNextNode();
	try{
	    oneBefore.setNextNode(oneAfter);
	}catch(NullPointerException e){
	    current.setNextNode(null);
	    lastNode = current;
	}
	size = size - 1;
    }

    public int size(){
	return size;
    }

    public String toString(){
	String ans = "[ ";
	LNode<T> temp = firstNode;
	while (temp != null){
	    ans = ans + temp.getData() + ",";
	    temp = temp.getNextNode();
	}
	return ans + " ]";
    }

    public int indexOf(T value){
	int i = 0;
	LNode<T> a = firstNode;
	while (a.getNextNode() != null){
	    if(value == a.getData()){
		break;
	    }else{
		i = i + 1;
	    }
	}
	return i;
    }

    public String name(){
	return "Ansorge.Ethan";
    }

    public static void main (String[]args){
    }
}
