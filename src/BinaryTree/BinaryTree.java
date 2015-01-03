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
				}
				else{
					insertElem(r.left, node);
				}
			}
			else{
				if(r.right == null){
					r.right = node;
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
	public static void main(String[] args){
		BinaryTree bt = new BinaryTree();
		int[] data = new int[]{	15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9 };
		for(int i = 0; i < data.length; i++){
			bt.insert(new Node(data[i]));
		}
		bt.inorderTreeWalk();
	}
}
