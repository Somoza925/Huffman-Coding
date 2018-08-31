import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileMaker {
	
	//this method generates an example to work with in which the contents are explicitly made
	public static void example() {
		File file = new File ("Example.txt");
		PrintWriter writer;	
		
		try {
			writer = new PrintWriter(file);
		} catch( FileNotFoundException e ) {
			System.out.println("File not found");
			return;
		}
		for (int i = 0; i < 5; i++) {
			writer.println('a');
		}
		for (int i = 0; i < 9; i++) {
			writer.println('b');
		}
		for (int i = 0; i < 12; i++) {
			writer.println('c');
		}
		for (int i = 0; i < 13; i++) {
			writer.println('d');
		}
		for (int i = 0; i < 16; i++) {
			writer.println('e');
		}
		for (int i = 0; i < 45; i++) {
			writer.println('f');
		}
		writer.close();
	}
	//this method generates an example to work with in which the contents are explicitly made
		public static void exampleTA() {
			File file = new File ("Example.txt");
			PrintWriter writer;	
			
			try {
				writer = new PrintWriter(file);
			} catch( FileNotFoundException e ) {
				System.out.println("File not found");
				return;
			}
			//writer.print("nBnk kk@ kUi nUwn  UBkwUik *ni UkUwn kU *Bw wB");
			writer.print("nBnk kk@ kUi nUwn  UBkwUik *ni UkUwn kU *Bw wB");
			writer.close();
		}
}
