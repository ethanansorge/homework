public class LNode{
    int data;
    LNode nextNode;

    public LNode(){
	data = 0;
    }
    
    public LNode(int value){
	data = value;
    }
    
    public int getData(){
	return data;
    }
    
    public void setData(int value){
	data = value;
    }
    
    public LNode getNextNode(){
	return nextNode;
    }
    
    public void setNextNode(LNode node){
	nextNode = node;
    }

    public String toString(){
	return "Data = " + getData() + " Next Node = " getNextNode();
    }
}