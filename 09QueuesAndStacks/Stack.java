public class Stack<T>{

    public class Stack(){
	linkedList = new MyLinkedList<T>();
    }

    public void push(T item){
	LNode<T> newNode = new LNode<T> (value);
	LNode<T> a = firstNode;
	firstNode = newNode;
	newNode.setNextNode(a);
    }

    public T pop(){
	LNode<T> a = firstNode;
	firstNode.getNextNode() = firstNode;
	return a;
    }
    
    public T peek(){
	return firstNode;
    }
}
	
