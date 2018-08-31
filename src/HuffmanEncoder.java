import java.io.*;
import java.util.*;
	

public class HuffmanEncoder implements HuffmanCoding{

	public String getFrequencies(File inputFile) throws FileNotFoundException {
		//initializing needed variables
		HashMap<Character, Integer> map;
		FileReader reader;


		//checks for existence of file
		if (inputFile.exists() == false) {
			throw new FileNotFoundException("File not found!");
		}

		//handling potential error in initializing FileReader
		try{
			reader = new FileReader(inputFile);
		} catch (IOException e) {
			System.out.println("Invalid IO stream");
			return null;
		}

		//creates map with frequency and character values from file
		map = freqMap(reader);

		//initializes a string with the contents of the sorted map
		String frequencies = freqMapSort(map);


		return frequencies;
	}

	//this method is a helper method that returns a HashMap with values and frequencies
	public static HashMap<Character, Integer> freqMap(FileReader reader){

		HashMap<Character, Integer> map = new HashMap<>();	

		try (BufferedReader br = new BufferedReader(reader)) {
			String line;
			while ((line = br.readLine()) != null) {

				for (int i = 0; i < line.length(); i++) {

					char current = line.charAt(i);
					int value = 1;

					//checks if key is already in the HashMap
					if (map.containsKey(current)) {
						value = map.get(current);
						value++;
					}
					map.put(current, value);
				}
			}
			//handling errors
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			return null;
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		} 
		return map;
	}

	//this method is a helper method in which it sorts an existing HashMap by value
	public String freqMapSort(HashMap<Character, Integer> map){

		StringBuilder freqString = new StringBuilder();
		TreeMap<Character, Integer> sortedMap = new TreeMap<Character, Integer>();

		//copies all entries in map into the TreeMap in a sorted order
		sortedMap.putAll(map);

		//iterate over sorted map and append to the string builder
		for (Map.Entry<Character, Integer> m:sortedMap.entrySet()) {
			freqString.append( m.getKey() + " " + m.getValue() + "\n");
		}

		//removes the extra line at the end of the string
		freqString.deleteCharAt(freqString.length()-1);

		//returns the string
		return freqString.toString();
	}

	public HuffTree buildTree(File inputFile) throws FileNotFoundException, Exception {

		if( !inputFile.exists() ) {
			throw new FileNotFoundException("File not found!");
		}
		try {
			//returns an instance of HuffTree, utilizing its constructor in which it takes in the file
			return new HuffTree(inputFile);
		} catch (Exception e) {
			System.out.println(e);
		}
		throw new Exception( "Error!" );
	}


	public String traverseHuffmanTree(HuffTree huffTree) throws Exception{

		//handling potential exception
		if( huffTree == null || huffTree.root() == null ) {
			throw new Exception("No Tree!");
		} 
		//initializing needed variables
		String codeString = "";
		HuffTree myTree = huffTree;
		
		//sets up the HashMap with the correct location of each char
		myTree.findCode(myTree.root(), codeString);
		
		//retrieve the HashMap
		HashMap<Character, String> codeMap = huffTree.getLocationMap();
		
		//initializing a TreeMap so it becomes sorted
		TreeMap<Character, String> sortedMap = new TreeMap<Character, String>();

		//copies all entries in codeMap into the TreeMap in a sorted order
		sortedMap.putAll(codeMap);

		//iterate over sortedMap and append to the codeStrring
		for (Map.Entry<Character, String> m:sortedMap.entrySet()) {
			codeString += m.getKey() + " " + m.getValue() + "\n";
		}

		//removes the extra line
		codeString = codeString.substring(0, codeString.length() - 1);
		return codeString;
	}

	public String encodeFile(File inputFile, HuffTree huffTree) throws FileNotFoundException {
		
		//initializing needed variables
		HuffTree myTree = huffTree;
		String code = "";
		
		//sets up the HashMap with the correct location of each char
		myTree.findCode(myTree.root(), "");
		
		//retrieve the HashMap
		HashMap<Character, String> codeMap = huffTree.getLocationMap();


		try{ //handling any potential exceptions
			
			FileReader reader = new FileReader(inputFile);
			BufferedReader br = new BufferedReader(reader);
			String line;
			
			while ((line = br.readLine()) != null) {
				for (int i = 0; i < line.length(); i++) {
					char current = line.charAt(i);
					code += codeMap.get(current); //retrieves the code with the char key from the already made HashMap with the locations
				}
			}
			
			br.close();
			
			//handling errors
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			return null;
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
		return code;	
	}

	public String decodeFile(String code, HuffTree huffTree) throws Exception {
		
		//handling potential exception
		if( huffTree == null || huffTree.root() == null ) {
			throw new Exception( "No Tree!" );
		}
		
		//initializing needed variables
		String myCode = code;
		String decoded = "";
		HuffTree myTree = huffTree;
		Node root = myTree.root();
		Node current = myTree.root();


		for (int i = 0; i < myCode.length(); i++) {
			char c = myCode.charAt(i);
			if (c == '0') { //if 0, go left
				current = current.left(); 
			} else if (c == '1') { //if 1, go right
				current = current.right();
			}

			if (current.left() == null && current.right() == null) {
				decoded += current.data();
				current = root; //resets the current to the top of the HuffTree
			}

		}
		return decoded;
	}
}




