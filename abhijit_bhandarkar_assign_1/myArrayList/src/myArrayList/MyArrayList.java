package myArrayList;

import java.util.Arrays;

public class MyArrayList {
	private int array[];
	private int numberOfElements = 0;

	/**
	 * Creating initial array of size 50
	 */
	public MyArrayList() {
		setArray(new int[50]);
	}

	/**
	 * Returns the array allocated
	 */
	public int[] getArray() {
		return array;
	}

	/**
	 * @param array
	 * 
	 */
	public void setArray(int[] array) {
		this.array = array;
	}

	/**
	 * Function to make array list empty
	 */
	public void clearArrayList() {
		setArray(new int[50]);
		numberOfElements = 0;
	}

	/**
	 * Method to insert new element in the array list and sort the list in
	 * ascending order
	 * 
	 * @param newValue
	 *            value to be inserted
	 */
	public void insertSorted(int newValue) {
		if (numberOfElements == array.length) {
			extendArraySize();
		}
		array[numberOfElements] = newValue;
		numberOfElements = numberOfElements + 1;
		Arrays.sort(getArray(), 0, numberOfElements);
	}

	/**
	 * Method to resize the arrayList
	 */
	public int extendArraySize() {
		int newSize = (int) (1.5 * array.length);
		int tempArray[] = new int[newSize];
		for (int i = 0; i < array.length; i++) {
			tempArray[i] = array[i];
		}
		setArray(tempArray);
		return newSize;
	}

	/**
	 * Method to remove all occurrences of a value, if it exists, and then move
	 * the remaining values so that the array list has all values in ascending
	 * order.
	 * 
	 * @param value
	 *            number to be removed from array list
	 */
	public void removeValue(int value) {
		int[] tempArray;
		int counter = numberOfElements;
		tempArray = new int[array.length];
		for (int i = 0, j = 0; i < counter; i++) {
			// for(int j=0; i<counter; i++)
			// {
			if (array[i] != value) {
				tempArray[j] = array[i];
				j++;
				continue;
			}
			numberOfElements = numberOfElements - 1;
			// }
		}
		setArray(tempArray);
	}

	/**
	 * Function to search the first occurrence of given value in the array list
	 * 
	 * @param value
	 * @return the index at which the value is found
	 */
	public int indexOf(int value) {
		int indexValue = -1;
		for (int i = 0; i < numberOfElements; i++) {
			if (array[i] == value) {
				indexValue = i;
				break;
			}
		}
		if (indexValue != -1)
			return indexValue;
		else
			return -1;
	}

	/**
	 * Function to return sum all the elements of the array list
	 * 
	 * @return sum of the elements of the array list
	 */
	public int sum() {
		int sumValue = 0;
		for (int i = 0; i < numberOfElements; i++) {
			sumValue = sumValue + array[i];
		}
		return sumValue;
	}

	/**
	 * Function to return number of values stored in the array list
	 * 
	 * @return the size of the array list
	 */
	public int size() {
		int arraySize = numberOfElements;
		return arraySize;
	}

	@Override
	public String toString() {
		int resultArray[];
		resultArray = new int[numberOfElements];
		resultArray = array;
		return Arrays.toString(resultArray);
	}
}