package myArrayList.test;

import myArrayList.MyArrayList;
import myArrayList.util.Results;
import java.util.Random;

public class MyArrayListTest {

	private int genenrateRandomNumber() {
		Random randomNumber = new Random();
		return randomNumber.nextInt(1000);
	}

	/**
	 * Method to verify actual size of the array list with expected size 15
	 * 
	 * @param myList
	 *            the array list
	 * @param output
	 *            Empty Results
	 */
	private void verifySize(MyArrayList myList, Results output) {
		for (int i = 0; i < 15; i++) {
			myList.insertSorted(genenrateRandomNumber());
		}
		int expectedSize = 15;
		int actualListSize = myList.size();
		String result;
		if (expectedSize == actualListSize)
			result = "Testcase 'verifySize' Passed";
		else
			result = "Testcase 'verifySize' Failed:Expected 15, got " + actualListSize;
		output.storeNewResult(result);
		output.writeToFile(result);
		output.writeToStdout(result);

	}

	/**
	 * Method to verify if the array list is empty or not
	 * 
	 * @param myList
	 *            the array list
	 * @param output
	 *            Empty Results
	 */
	private void verifyEmptyList(MyArrayList myList, Results output) {
		myList.clearArrayList();
		String result;
		if ((myList.size()) == 0)
			result = "Testcase 'verifyEmptyList' Passed";
		else
			result = "Testcase 'verifyEmptyList' Failed:Expected 0," + " got " + myList.size();
		output.storeNewResult(result);
		output.writeToFile(result);
		output.writeToStdout(result);
	}

	/**
	 * Method to return index of a number in the list which is present one time
	 * in the list
	 * 
	 * @param myList
	 *            Empty array list
	 * @param output
	 *            Empty Results
	 */
	private void verifyIndexOfSingleValue(MyArrayList myList, Results output) {
		myList.insertSorted(10);
		myList.insertSorted(20);
		myList.insertSorted(30);
		myList.insertSorted(30);
		myList.insertSorted(40);
		myList.insertSorted(50);
		myList.insertSorted(60);
		myList.insertSorted(70);
		String result;
		if ((myList.indexOf(20)) == 1)
			result = "Testcase 'verifyIndexOfSingleValue' Passed";
		else
			result = "Testcase 'verifyIndexOfSingleValue' Failed. " 
		+ "Expected 1, got " + myList.indexOf(30);
		output.storeNewResult(result);
		output.writeToFile(result);
		output.writeToStdout(result);
	}

	/**
	 * Method to return index of first occurrence of a number in the 
	 * list which is present multiple time in the list
	 * 
	 * @param myList
	 *            Empty array list
	 * @param output
	 *            Empty Results
	 */
	private void verifyIndexOfMultipleValue(MyArrayList myList, Results output) {
		myList.insertSorted(10);
		myList.insertSorted(20);
		myList.insertSorted(30);
		myList.insertSorted(30);
		myList.insertSorted(40);
		myList.insertSorted(50);
		String result;
		if ((myList.indexOf(30)) == 2)
			result = "Testcase 'verifyIndexOfMultipleValue' Passed";
		else
			result = "Testcase 'verifyIndexOfMultipleValue' Failed. "
					+ "Expected 2, got " + myList.indexOf(30);
		output.storeNewResult(result);
		output.writeToFile(result);
		output.writeToStdout(result);
	}

	/**
	 * Method to return -1 if the number is not present in the list
	 * 
	 * @param myList
	 *            Empty array list
	 * @param output
	 *            Empty Results
	 */
	private void verifyValueNotFound(MyArrayList myList, Results output) {
		myList.insertSorted(10);
		myList.insertSorted(20);
		myList.insertSorted(30);
		myList.insertSorted(30);
		myList.insertSorted(40);
		myList.insertSorted(50);
		String result;
		if ((myList.indexOf(300)) == -1)
			result = "Testcase 'verifyValueNotFound' Passed";
		else
			result = "Testcase 'verifyValueNotFound' Failed. "
					+ "Expected -1, got " + myList.indexOf(300);
		output.storeNewResult(result);
		output.writeToFile(result);
		output.writeToStdout(result);
	}

	/**
	 * Method to enter 70 random values in the array list and to verify whether
	 * size of the array list extends or not
	 * 
	 * @param myList
	 *            Empty array list
	 * @param output
	 *            Empty Results
	 */
	private void verifyExtendedSize(MyArrayList myList, Results output) {
		for (int i = 0; i < 70; i++) {
			int randomValue = genenrateRandomNumber();
			myList.insertSorted(randomValue);
		}
		int expectedValue = 70;
		int actualExtendedValue = myList.size();
		String result;
		if (actualExtendedValue == expectedValue)
			result = "Testcase 'verifyExtendedSize' Passed";
		else
			result = "Testcase 'verifyExtendedSize' Failed. "
					+ "Expected 70, got " + myList.size();
		output.storeNewResult(result);
		output.writeToFile(result);
		output.writeToStdout(result);
	}

	/**
	 * Method to find sum of all the elements in the array list
	 * 
	 * @param myList
	 *            Empty array list
	 * @param output
	 *            Empty Results
	 */
	private void verifySum(MyArrayList myList, Results output) {
		int expectedSum = 0;
		for (int i = 0; i < 5; i++) {
			int randomValue = genenrateRandomNumber();
			expectedSum = expectedSum + randomValue;
			myList.insertSorted(randomValue);
		}
		String result;
		if (myList.sum() == expectedSum)
			result = "Testcase 'verifySum' Passed";
		else
			result = "Testcase 'verifySum' Failed. "
					+ "Expected 50, got " + myList.sum();
		output.storeNewResult(result);
		output.writeToFile(result);
		output.writeToStdout(result);
	}

	/**
	 * Method to verify the sum of the elements in the empty 
	 * array list is zero
	 * 
	 * @param myList
	 *            Empty array list
	 * @param output
	 *            Empty Results
	 */
	private void verifySumOfEmptyList(MyArrayList myList, Results output) {
		int expectedSum = 0;
		String result;
		if (myList.sum() == expectedSum)
			result = "Testcase 'verifySumOfEmptyList' Passed";
		else
			result = "Testcase 'verifySumOfEmptyList' Failed. "
					+ "Expected 0, got " + myList.sum();
		output.storeNewResult(result);
		output.writeToFile(result);
		output.writeToStdout(result);
	}

	/**
	 * Method to remove all occurrences of given number from the array list
	 * 
	 * @param myList
	 *            Empty array list
	 * @param output
	 *            Empty Results
	 */
	private void verifyRemoveValue(MyArrayList myList, Results output) {
		myList.insertSorted(10);
		myList.insertSorted(20);
		myList.insertSorted(30);
		myList.insertSorted(30);
		myList.insertSorted(40);
		String result;
		myList.removeValue(40);
		if (myList.size() == 4)
			result = "Testcase 'verifyRemovalValue' Passed";
		else
			result = "Testcase 'verifyRemovalValue' Failed. "
					+ "Expected 4, got " + myList.size();
		output.storeNewResult(result);
		output.writeToFile(result);
		output.writeToStdout(result);
	}

	/**
	 * Method to remove all numbers from the array list
	 * 
	 * @param myList
	 *            Empty array list
	 * @param output
	 *            Empty Results
	 */
	private void verifyRemoveAllValues(MyArrayList myList, Results output) {
		myList.insertSorted(10);
		myList.insertSorted(20);
		myList.insertSorted(50);
		myList.insertSorted(30);
		myList.insertSorted(40);
		String result;
		myList.removeValue(10);
		myList.removeValue(20);
		myList.removeValue(30);
		myList.removeValue(40);
		myList.removeValue(50);
		if (myList.size() == 0)
			result = "Testcase 'verifyRemoveAllValues' Passed";
		else
			result = "Testcase 'verifyRemoveAllValues' Failed. "
					+ "Expected 0, got " + myList.size();
		output.storeNewResult(result);
		output.writeToFile(result);
		output.writeToStdout(result);
	}

	/**
	 * Method to verify removeValue() works properly on empty array list
	 * 
	 * @param myList
	 *            Empty array list
	 * @param output
	 *            Empty Results
	 */
	private void verifyRemoveFromEmptyList(MyArrayList myList, Results output) {
		String result;
		myList.removeValue(40);
		if (myList.size() == 0)
			result = "Testcase 'verifyRemoveFromEmptyList' Passed";
		else
			result = "Testcase 'verifyRemoveFromEmptyList' Failed. "
					+ "Expected 0, got " + myList.size();
		output.storeNewResult(result);
		output.writeToFile(result);
		output.writeToStdout(result);
	}

	/**
	 * Method to verify whether the elements of array list are 
	 * sorted or not
	 * 
	 * @param myList
	 *            Empty array list
	 * @param output
	 *            Empty Results
	 */
	private void verifySorted(MyArrayList myList, Results output) {
		for (int i = 0; i < 5; i++) {
			int randomValue = genenrateRandomNumber();
			myList.insertSorted(randomValue);
		}
		String result;
		int[] tempNew = myList.getArray();
		int tempSize = myList.size();
		for (int j = 0; j < tempSize - 1; j++) {
			if (tempNew[j] > tempNew[j + 1]) {
				result = "Testcase 'verifySorted' Failed";
				output.storeNewResult(result);
				output.writeToFile(result);
				output.writeToStdout(result);
				break;
			}
		}
		result = "Testcase 'verifySorted' Passed";
		output.storeNewResult(result);
		output.writeToFile(result);
		output.writeToStdout(result);
	}

	/**
	 * Method for running all the test cases
	 * 
	 * @param myList
	 *            instance of array list
	 * @param output
	 *            empty results
	 */
	public void testMe(MyArrayList myList, Results output) {
		myList.clearArrayList();

		verifySorted(myList, output);
		myList.clearArrayList();

		verifySize(myList, output);
		myList.clearArrayList();

		verifyEmptyList(myList, output);
		myList.clearArrayList();

		verifyExtendedSize(myList, output);
		myList.clearArrayList();

		verifySum(myList, output);
		myList.clearArrayList();

		verifySumOfEmptyList(myList, output);
		myList.clearArrayList();

		verifyIndexOfSingleValue(myList, output);
		myList.clearArrayList();

		verifyIndexOfMultipleValue(myList, output);
		myList.clearArrayList();

		verifyValueNotFound(myList, output);
		myList.clearArrayList();

		verifyRemoveValue(myList, output);
		myList.clearArrayList();

		verifyRemoveFromEmptyList(myList, output);
		myList.clearArrayList();

		verifyRemoveAllValues(myList, output);
		myList.clearArrayList();
	}
}
