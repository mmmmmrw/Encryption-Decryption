package app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

abstract class tap {

	abstract void encrypt (int key, String text, String in, String out);
	abstract void decrypt (int key, String text, String in, String out);
	
	void writeToFile(String fileName, String text) throws FileNotFoundException {
		try(PrintWriter file = new PrintWriter(fileName)){
			file.write(text);
	}catch (FileNotFoundException e) {
		System.out.println("erro, file not found!");
	}
	 
}
	String readFile (String fileName) throws IOException {
		try {
	
		 return new String(Files.readAllBytes(Paths.get(fileName)));
		}catch (IOException e) {
		 System.out.println("File not found");
		}
		return null;
	}
}
