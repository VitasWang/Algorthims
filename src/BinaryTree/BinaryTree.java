package BinaryTree;
public class BinaryTree {
	private Node root = null;
	
	public void insert(Node node){
		if(root == null){
			root = node;
			return;
		}
		insertElem(root, node);
	}
	private void insertElem(Node r, Node node){
			if(r.getValue() >= node.getValue()){
				if(r.left == null){
					r.left = node;
					node.parent = r;
				}
				else{
					insertElem(r.left, node);
				}
			}
			else{
				if(r.right == null){
					r.right = node;
					node.parent = r;
				}
				else{
					insertElem(r.right, node);
				}
			}
	}
	public void inorderTreeWalk(){
		treeWalk(root);
	}
	private void treeWalk(Node node) {
		if(node == null){
			return;
		}
		treeWalk(node.left);
		System.out.print(node.getValue() + " ");
		treeWalk(node.right);
	}
	
	public Node search(int data){
		return search(root, data);
	}
	private Node search(Node r, int data){
		if(r == null || r.getValue() == data){
			return r;
		}
		if(r.getValue() >= data){
			return search(r.left, data);
		}
		return search(r.right, data);
	}
	public Node getSuccessor(int data){
		Node d = search(data);
		if(d.right != null){
			return getMin(d.right);
		}
		else{
			while(d.parent != null && d.parent.left != d){
				d = d.parent;
			}
			return d.parent;
		}
		
	}
	public Node getMin(Node r2){
		Node r = r2;
		while(r.left != null){
			r = r.left;
		}
		return r;
	}
	public Node getMax(Node r1){
		Node r = r1;
		while(r.right != null){
			r = r.right;
		}
		return r;
	}
	public Node getRoot(){
		return root;
	}
	
	public static void main(String[] args){
		BinaryTree bt = new BinaryTree();
		int[] data = new int[]{	15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9 };
		for(int i = 0; i < data.length; i++){
			bt.insert(new Node(data[i]));
		}
		bt.inorderTreeWalk();
		System.out.println();
		Node n = bt.search(41);
		if(n == null){
			System.out.println("didn't find the data in tree");
		}
		else{
			System.out.println("find the data " + n.getValue());
		}
		
		Node min = bt.getMin(bt.getRoot());
		System.out.println("min value is: " + min.getValue());
		
		Node max = bt.getMax(bt.getRoot());
		System.out.println("max value is: " + max.getValue());
		Node successor = bt.getSuccessor(15);
		System.out.println("17's successor is " + successor.getValue());
	}
}
