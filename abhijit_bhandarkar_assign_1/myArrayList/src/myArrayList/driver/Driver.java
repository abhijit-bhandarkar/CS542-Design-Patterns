package myArrayList.driver;

import myArrayList.MyArrayList;
import myArrayList.test.MyArrayListTest;
import myArrayList.util.FileProcessor;
import myArrayList.util.Results;

public class Driver {
	public static void main(String[] args) {
		if (args.length != 2) // Command line argument validation
		{
			System.err.println("Invalid arguments. "
					+ "Expected <input.txt> <output.txt>");
			System.exit(1);
		}

		FileProcessor myProcessor = new FileProcessor(args[0]);
		MyArrayList myList = new MyArrayList();
		Results results = new Results(args[1]);
		String inputLine;

		while ((inputLine = myProcessor.readLine()) != null) {
			try {
				int val = (Integer.parseInt(inputLine));
				if (val < 0 || val > 10000) {
					System.err.println("Input value must be between 0 and 10000 inclusive. Skipping input value \'" + val + "\' and moving to next line.");
					continue;
				}
				myList.insertSorted(val);
			} catch (NumberFormatException e) {
				System.err.println(
						"Invalid input value. Skipping input value \'" + inputLine + "\' and moving to next line.");
				continue;
			}
		}
		
		String output = "The sum of all the values in the array list is: " + myList.sum();
		results.writeToFile(output);
		results.writeToStdout(output);
		//results.writeToStdout(myList.toString());
		System.out.println("");
		MyArrayListTest test = new MyArrayListTest();
		test.testMe(myList, results);

	}
}
