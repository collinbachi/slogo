
public abstract class Node {
	private Node prev;
	private Node left;
	private Node right;
	
	public Node(Node head){
		prev = head;
		left = null;
		right = null;
	}
	
	public Node getPrev(){
		return prev;
	}
	
	public Node getLeft(){
		return left;
	}
	
	public Node getRight(){
		return right;
	}
	
	public void setLeft(Node node){
		left = node;
	}
	
	public void setRight(Node node){
		right = node;
	}

}
