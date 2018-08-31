import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.*;   // instead of  import org.junit.Test;


public class HuffmanEncodingTest {

	@Test
	public void testGetFrequencies() {
		String result = "";
		HuffmanEncoder myHuff = new HuffmanEncoder();
		File file = new File("randTest.txt");
		try {
		  result = myHuff.getFrequencies(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String expected = "1 16\n= 64\nG 2\nQ 32\n_ 1\na 128\nw 4\nz 8";
		assertEquals(expected,result);
	}
	
	@Test
	public void testTraverseHuffmanTree() {
		File file = new File("randTest.txt");
		HuffTree myTree = null;
		try {
			myTree = new HuffTree(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HuffmanEncoder myHuff = new HuffmanEncoder();
		
		String result = "";
		try {
			result = myHuff.traverseHuffmanTree(myTree);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String expected = "1 0001\n= 01\nG 0000001\nQ 001\n_ 0000000\na 1\nw 000001\nz 00001";

		assertEquals(expected,result);
	}

	@Test
	public void testEncodeFile() {
		File file = new File("randTest.txt");
		HuffmanEncoder myHuff = new HuffmanEncoder();
		HuffTree myTree = null;
		String result = "";
		try {
		  myTree= new HuffTree(file);
		  result = myHuff.encodeFile(file, myTree);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String expected = "0110110000101101111111100111010100000100110000000111100111111"
				+ "111011011001100101111010110010110100110000001100100010110111000"
				+ "1000011000011010001001000011000010110100101101001101111011001101"
				+ "11010000100000111011111000011101001100010001001111101110101111010"
				+ "01101100111111011010101010001000101100010011010001100100101011001010"
				+ "0011111100001001000100000111101011011010100011101100"
				+ "000100100101000100110110100110011011101111110010110001111001011"
				+ "01111111101000000110111011100100011001010101010010001010111001111";
		assertEquals(expected, result);
		
	}

	@Test
	public void testDecodeFile() {
		File file = new File("randTest.txt");
		HuffmanEncoder myHuff = new HuffmanEncoder();
		HuffTree myTree = null;
		String result = "";
		String codeString = "0110110000101101111111100111010100000100110000000111100111111"
				+ "111011011001100101111010110010110100110000001100100010110111000"
				+ "1000011000011010001001000011000010110100101101001101111011001101"
				+ "11010000100000111011111000011101001100010001001111101110101111010"
				+ "01101100111111011010101010001000101100010011010001100100101011001010"
				+ "0011111100001001000100000111101011011010100011101100"
				+ "000100100101000100110110100110011011101111110010110001111001011"
				+ "01111111101000000110111011100100011001010101010010001010111001111";
		try {
		  myTree= new HuffTree(file);
		  result = myHuff.decodeFile(codeString, myTree);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String expected = "=a=az=a=aaaaaaaQaa==wQa_aaaaQaaaaaaaa=a=aQaQ=aaa==aQ=a=QaGaQ1=a=aa1zaza=1Qzaz=a=Q=a=Qa=aaa=aQa=aa=zwaa=aaaazaa=Qa11Qaaaa=aa==aaa=Qa=aQaaaaa=a====11=a1Qa=1aQQ==aQ=1aaaaazQ1waaa==a=a==1aa=awQQ=1Qa=a=QaQa=aa=aaaaaQ=a1aaaQ=a=aaaaaaa=Ga=aa=aaQ1aQ====Q1==aaQaaa";
		assertEquals(expected, result);
	}

	@Test
	public void testGetFrequencies2() {
		String result = "";
		HuffmanEncoder myHuff = new HuffmanEncoder();
		File file = new File("sample.txt");
		try {
		  result = myHuff.getFrequencies(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String expected = "  10\n* 2\n@ 1\nB 4\nU 7\ni 3\nk 8\nn 6\nw 5";
		assertEquals(expected,result);
	}
	
	@Test
	public void testTraverseHuffmanTree2() {
		File file = new File("sample.txt");
		HuffTree myTree = null;
		try {
			myTree = new HuffTree(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HuffmanEncoder myHuff = new HuffmanEncoder();
		
		String result = "";
		try {
			result = myHuff.traverseHuffmanTree(myTree);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String expected = "  01\n* 10011\n@ 10010\nB 000\nU 110\ni 1000\nk 111\nn 101\nw 001";
		assertEquals(expected,result);
	}

	@Test
	public void testEncodeFile2() {
		File file = new File("sample.txt");
		HuffmanEncoder myHuff = new HuffmanEncoder();
		HuffTree myTree = null;
		String result = "";
		try {
		  myTree= new HuffTree(file);
		  result = myHuff.encodeFile(file, myTree);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String expected = "10100010111101111111100100111111010000110111000110101011100001110011101000111011001110110000111011111000110101111110011001100000101001000";
		assertEquals(expected, result);
		
	}

	@Test
	public void testDecodeFile2() {
		File file = new File("sample.txt");
		HuffmanEncoder myHuff = new HuffmanEncoder();
		HuffTree myTree = null;
		String result = "";
		String codeString = "10100010111101111111100100111111010000110111000110101011100001110011101000111011001110110000111011111000110101111110011001100000101001000";
		try {
		  myTree= new HuffTree(file);
		  result = myHuff.decodeFile(codeString, myTree);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String expected = "nBnk kk@ kUi nUwn  UBkwUik *ni UkUwn kU *Bw wB";
		assertEquals(expected, result);
	}
}
