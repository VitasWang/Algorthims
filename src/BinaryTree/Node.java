package BinaryTree;
public class Node{
	int value;
	Node left;
	Node right; 
	Node parent;
	
	public Node(int value){
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
	
	public void setValue(int value){
		this.value = value;
	}
	
	public Node getLeft(){
		return left;
	}
	
	public Node getRigth(){
		return right;
	}
	
	public Node getParent(){
		return parent;
	}
}