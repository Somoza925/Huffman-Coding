import java.io.*;

public class Project3 {

	public static void main(String[] args) throws Exception {


		File file = new File("Illiad.txt");


		HuffmanEncoder myHuff = new HuffmanEncoder();
		String result = myHuff.getFrequencies(file);
		System.out.println(result);

		HuffTree myTree= new HuffTree(file);

		String returnString;
		try {
			System.out.println("The codes are: ");
			returnString = myHuff.traverseHuffmanTree(myTree);
			System.out.println(returnString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}
}