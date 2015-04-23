public class TreeNode<T>{
    private TreeNode<T> right, left;
    private T value;
    
    public TreeNode(TreeNode rightNode, TreeNode leftNode, T valueOfNode){
	right = rightNode;
	left = leftNode;
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
    public void setLeft(TreeNode node){
	left = node;
    }
    public void setRight(TreeNode node){
	right = node;
    }
}
