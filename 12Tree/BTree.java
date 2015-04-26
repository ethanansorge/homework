/*========== BTree.java ==========  
  Lab: Complete
  1. TreeNode.java
  2. add()
  3. pre/post/in Order()
  4. getHeight
  5. getLevel
  6. toString
  
  Basic binary tree.
  Uses TreeNode
  Stolen from Mr. K who stole it from DW.
  =========================*/

import java.io.*;
import java.util.*;

public class BTree<T> {

    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;
    

    private TreeNode<T> root;

    public BTree() {
	root = null;
    }

    /*======== public void add() ==========
      Inputs:   E d
      Returns: 
      
      Wrapper method for the recursive add()
      ====================*/     
    public void add( T d ) {
	if (root == null){
	    root = new TreeNode<T>(d);
	}else{
	    TreeNode<T> node = new TreeNode<T>(d);
	    add(root, node);
	}
    }

    /*======== public void add() ==========
      Inputs:   TreeNode<E> curr, TreeNode<E> bn  
      Returns: 
      
      Adds bn to the tree rooted at curr. If curr has 
      an available child space, then attach bn there.

      Otherwise, try to add at the subtree rooted at
      one of curr's children. Choose the child to be
      added to randomly.
      ====================*/
    private void add( TreeNode<T> curr, TreeNode<T> bn ){
	    if(curr.getLeft() == null){
		curr.setLeft(bn);
	    }else{
		if(curr.getRight() == null){
		    curr.setRight(bn);
		}
		Random rand = new Random();
		int randomNum = rand.nextInt(2); 
		if (randomNum == 0){
		    add(curr.getLeft(), bn);
		}else{
		    add(curr.getRight(), bn);
		}
	    }
    }
    
    public void traverse( int mode) {
	if ( mode == PRE_ORDER )
	    preOrder( root );
	else if ( mode == IN_ORDER )
	    inOrder( root );
	else
	    postOrder( root );
	//System.out.println();
    }
    /*======== public void preOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing an
      pre-order Traversal
      ====================*/
    public void preOrder( TreeNode<T> curr ) {
	if (curr == null){
	    return;
	}
	if(curr.isLeaf()){
	    System.out.println(curr.getValue());
	}else{  
	    System.out.println(curr.getValue() + " ");
	    preOrder(curr.getLeft());
	    preOrder(curr.getRight());
	}
    }


    /*======== public void inOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing an
      in-order Traversal
      ====================*/
    public void inOrder( TreeNode<T> curr ) {
	if (curr == null){
	    return;
	}
	if(curr.isLeaf()){
	    System.out.println(curr.getValue());
	}else{  
	inOrder(curr.getLeft());
	System.out.println(curr.getValue() + " ");
	inOrder(curr.getRight());
	}
    }
    
    /*======== public void postOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing a
      post-order Traversal    
      ====================*/
    public void postOrder( TreeNode<T> curr ){
	if (curr == null){
	    return;
	}
	if(curr.isLeaf()){
	    System.out.println(curr.getValue());
	}else{  
	postOrder(curr.getLeft());
	postOrder(curr.getRight());
        System.out.println(curr.getValue() + " ");
	}
    }
    
    /*======== public int getHeight()) ==========
      Inputs:   
      Returns: The height of the tree

      Wrapper for the recursive getHeight method
      ====================*/
    public int getHeight() {
	return getHeight( root );
    }
    /*======== public int getHeight() ==========
      Inputs:   TreeNode<E> curr  
      Returns:  The height of the tree rooted at node curr
      
      ====================*/
    public int getHeight( TreeNode<T> curr ) {
	if (curr == null){
	    return 0;
	}
	if (curr.getLeft() == null && curr.getLeft() == null){
	    return 1;
	}
	if(curr.getLeft() == null){
	    return getHeight(curr.getRight()) + 1;
	}
	if(curr.getRight() == null){
	    return getHeight(curr.getLeft()) + 1;
	}
	return Math.max(getHeight(curr.getRight()), getHeight(curr.getLeft())) + 1;
    }

    /*======== public String getLevel() ==========
      Inputs:   TreeNode<E> curr
      int level
      int currLevel  
      Returns: A string containing all the elements on the
      given level, ordered left -> right
      
      ====================*/
    private String getLevel( TreeNode<T> curr, int level, int currLevel) {
	if (curr == null || currLevel > level){
	    return "";
	}
        if (currLevel == level){
	    return curr.getValue() + " ";
	}
	return getLevel(curr.getLeft(), level, currLevel + 1) + getLevel(curr.getRight(), level, currLevel + 1);
	    
    }
    
    /*======== public String toString()) ==========
      Inputs:   
      Returns: A string representation of the tree
     
      This string should display each level as a separate line.
      A simple version might look something like this:

      0
      1 2
      3 4 5

      Note that you cannot tell exactly where 3, 4 and 5 lie.
      That is ok, but if you want a CHALLENGE, you can try to
      get the output to look nicer, something like this:
      0
      1      2
      3  4   5
      ====================*/
    public String toString() {
	String a = "" ;
	int i = 0;
	int x = getHeight();
	while (i < x){
	    a = a + getLevel(root,i,0) + "\n";
	    i = i + 1;
	}
	return a;
    }
	
    public String name(){
	return "ansorge.ethan";
    }

    public static void main( String[] args ) {

	BTree<Integer> t = new BTree<Integer>();
	int i = 0;
	while ( i < 8){
	    t.add(i);
	    i = i + 1;
	}
	System.out.println( "Pre-order: ");
	t.traverse( PRE_ORDER );
	System.out.println( "In-order: ");
	t.traverse( IN_ORDER );
	System.out.println( "Post-order: ");
	t.traverse( POST_ORDER );
	System.out.println( "Height: " + t.getHeight() ); 
	

    }
}
