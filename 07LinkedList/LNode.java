public class LNode <T>{
    T data;
    LNode<T> nextNode;

    public LNode(){
    }
    
    public LNode(T value){
	data = value;
    }

    public LNode(T value, LNode<T> next){
	data = value;
	nextNode = next;
    }
    
    public T getData(){
	return data;
    }
    
    public void setData(T value){
	data = value;
    }
    
    public LNode<T> getNextNode(){
	return nextNode;
    }
    
    public void setNextNode(LNode<T> node){
	nextNode = node;
    }

    public String toString(){
	return " " + getData();
    }
}
