public class TreeNode<T>{
    private TreeNode<T> right, left;
    private T value;
    
    public TreeNode(TreeNode<T> rightNode, TreeNode<T> leftNode, T valueOfNode){
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
    public TreeNode<T> getLeft(){
	return left;
    }
    public TreeNode<T> getRight(){
	return right;
    }
    public void setLeft(TreeNode<T> node){
	left = node;
    }
    public void setRight(TreeNode<T> node){
	right = node;
    }
}
