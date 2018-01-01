package myArrayList.util;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import myArrayList.util.FileDisplayInterface;
import myArrayList.util.StdoutDisplayInterface;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	private String[] results;
	private String inputFile;
	private int tailIndex;

	/**
	 * To create an instance to write in output file
	 * 
	 * @param fileName
	 */
	public Results(String fileName) {
		results = new String[10];
		inputFile = fileName;
		tailIndex = 0;
		try {
			emptyFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Helper function to make file empty
	 * 
	 * @throws IOException
	 */
	private void emptyFile() throws IOException {
		FileWriter fwriter = new FileWriter(inputFile);
		fwriter.write("");
		fwriter.close();
	}

	/**
	 * Method to increase the array size by double
	 */
	private void increaseSize() {
		String[] tempArray = new String[results.length * 2];
		for (int i = 0; i < results.length; i++) {
			tempArray[i] = results[i];
		}
		results = tempArray;
	}

	/**
	 * Write each line from file to output file.
	 * 
	 * @param inputLine
	 *            String to be written
	 */
	@Override
	public void writeToFile(String inputLine) {
		try {
			BufferedWriter wtr = new BufferedWriter(new FileWriter(inputFile, true));
			wtr.write(inputLine);
			wtr.newLine();
			wtr.close();
		} catch (IOException e) {
			System.err.println("Exception caught. Exiting.");
			System.exit(1);
		}
	}

	/**
	 * Write each line from file to standard output
	 * 
	 * @param inputLine
	 *            String to be written
	 */
	@Override
	public void writeToStdout(String inputLine) {
		System.out.println(inputLine);
	}

	public void storeNewResult(String line) {
		if (tailIndex == results.length) {
			increaseSize();
		}
		results[tailIndex++] = line;
	}
}