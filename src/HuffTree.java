import java.io.*;
import java.util.*;


/* A Huffman coding tree */
public class HuffTree implements Comparable<Object> {
  //needed variables for HuffTree instance
  private Node root;
  private HashMap<Character, Integer> charFrequencyMap;
  private HashMap<Character, String> charLocationMap;
  
  //default constructor
  public HuffTree() {
	  
  }
 
  //This constructor initializes the HuffMan Tree
  public HuffTree(File inputFile) throws FileNotFoundException{
	 	 
	  	 //needed temporary nodes for the building process
	  	 Node temp1, temp2, temp3 = null;
	  	 
	  	 //initializes the HashMap for the location of chars
	 	 charLocationMap = new HashMap<Character, String>();
	 	 
	     //checks for existence of file
		 if (inputFile.exists() == false) {
			 throw new FileNotFoundException( "File not found!");
		 }
		 
		 try {
			 FileReader reader = new FileReader(inputFile);
			 this.charFrequencyMap = HuffmanEncoder.freqMap(reader);
		 } catch (Exception e) {
			 System.out.println(e);
		 }
		 
		 //create arrayList of nodes
		 ArrayList<Node> listOfNodes = generateTrees();
		 
		 //create a priority queue
		 Comparator<Node> comparator = new TreeWeightComparator();
		 PriorityQueue<Node> queue = new PriorityQueue<Node>(this.charFrequencyMap.size(), comparator);
		 
		 //iterate through array and enter each node into queue
		 for (Node node: listOfNodes) {
			 queue.add(node);
		 }
		 
		 while (queue.size() > 1) { //as long as there are 2 items
		 //setting the temps to the two lowest weighted nodes
		 temp1 = queue.remove();
		 temp2 = queue.remove();
		 
		 //creating a node out of the weights of the two lowest nodes
		 temp3 = new Node(temp1.weight() + temp2.weight());
		 
		 //setting pointers to correct nodes, building the tree
		 temp3.leftSetter(temp1);
		 temp3.rightSetter(temp2);
		 
		 //add new tree to queue
		 queue.add(temp3);
		 }
		 //the root is set to the only element in the queue, which is the full tree!
		 this.root = queue.remove();
  }
  
  //helper method to generate the arrayList of nodes
  public ArrayList<Node> generateTrees() {
      ArrayList<Node> forest = new ArrayList<Node>(this.charFrequencyMap.size());
      
      //iterates through the HashMap
	  for (Map.Entry<Character, Integer> m:this.charFrequencyMap.entrySet()) {
		    Node temp = new Node(m.getKey(), m.getValue());
		    forest.add(temp);
	  }
	  
	  return forest;
  }
  
  //generates the codes for the chars
  public void findCode(Node root, String s) {
	  
      // base case; if the root is now a leaf, return and place the data into the charLocationMap
      if (root.left() == null && root.right()== null) {
          this.charLocationMap.put(root.data(), s);
          return;
      }

      // if we go to left then add "0" to the code.
      // if we go to the right add"1" to the code.

      // recursive calls for left and right sub-tree of the generated tree.
      findCode(root.left(), s + "0");
      findCode(root.right(), s + "1");
  }

  //simple return methods
  public Node root() {
	  return this.root;
  }
  public HashMap<Character, String> getLocationMap(){
	  return this.charLocationMap;
  }
  

@Override
public int compareTo(Object o) {
	// TODO Auto-generated method stub
	return 0;
}


}