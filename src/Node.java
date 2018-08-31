
public class Node {
	//initializing needed variables
	private Node leftNode = null;
	private Node rightNode = null;
	private int weight;
	private char data;
	
	//constructor for a leaf node
	public Node(char data, int weight) {
		this.data = data;
		this.weight = weight;
	}
	
	//constructor for a internal node
	public Node(int weight) {
		this.weight = weight;
	}
	
	//setters and getters
	public Node left() {
		return this.leftNode;
	}
	
	public void leftSetter(Node node) {
		this.leftNode = node;
	}
	
	public Node right() {
		return this.rightNode;
	}
	
	public void rightSetter(Node node) {
		this.rightNode = node;
	}
	
	public char data() {
		return this.data;
	}
	
	public void dataSetter(char data) {
		this.data = data;
	}
	
	public int weight() {
		return this.weight;
	}
	
	public void weightSetter(int weight) {
		this.weight = weight;
	}

	
}
