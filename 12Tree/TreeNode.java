public class TreeNode{
    private Treenode right, left;
    private T value;
    
    public TreeNode(Treenode rightNode, Treenode leftNode, T valueOfNode){
	right = rightNode
	left = leftNode
	    value = valueOfNode;
    }
    public void setValue(T newValue){
	value = newValue;
    }
    public T getValue(){
	return value;
    }
    public TreeNode getLeft(){
	return left;
    }
    public TreeNode getRight(){
	return right;
    }
}
