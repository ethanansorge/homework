public class Queue<T> extends MyLinkedList<T>{
    public boolean add(T node){
	lastNode = node;
	return true;
    }
    public T remove(){
	Node a = firstNode;
	firstNode = FirstNode.getNextNode();
	return a;
    }
}