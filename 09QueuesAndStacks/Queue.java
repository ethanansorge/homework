public class Queue<T>{

    public Queue(){
	linkedList = new MyLinkedList<T>();
    }
    public void add(T node){
	lastNode.setNextNode(node);
	lastNode = node;
    }
    public T remove(){
	Node a = firstNode;
	firstNode = FirstNode.getNextNode();
	return a;
    }
}
