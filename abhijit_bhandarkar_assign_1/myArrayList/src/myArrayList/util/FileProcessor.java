package myArrayList.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileProcessor {
	private String inputFile;
	private BufferedReader br;

	/**
	 * Constructs a new FileProcessor which reads from the file specified by
	 * command line input
	 * 
	 * @param inputFile
	 *            name of the file to read
	 */
	public FileProcessor(String inputFile) {
		this.inputFile = inputFile;
		initBufferReader();
	}

	/**
	 * Function to initialize the BufferReader
	 */
	private void initBufferReader() {
		try {
			br = new BufferedReader(new FileReader(inputFile));
		} catch (FileNotFoundException e) {
			System.err.println("File not found. Program Terminated");
			System.exit(1);
		}
	}

	/**
	 * Read one line from the file
	 * 
	 * @return line read from the input file
	 */
	public String readLine() {
		try {
			return br.readLine();
		} catch (IOException e) {
			System.err.println("Line not read.");
			System.exit(1);
			return null;
		}
	}

	public String toString() {
		return "Reading File:" + inputFile;
	}

}