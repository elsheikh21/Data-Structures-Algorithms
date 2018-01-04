package sheikh.arrays;

public class LinearSortedArray {
	private int[] array;
	private int itemsCount;

	/**
	 * Empty constructor just gives you an instance of that object. You might use
	 * setters on it to set necessary properties. If you want to make sure that any
	 * instance created is always valid and any member variables are always
	 * initialized,then you would define the constructor which initializes all the
	 * required member variables.
	 */
	public LinearSortedArray() {
		super();
	}

	/**
	 * If you want to make sure that any instance created is always valid and any
	 * member variables are always initialized,then you would define the constructor
	 * which initializes all the required member variables.
	 */
	public LinearSortedArray(int maxSize) {
		itemsCount = 0;
		array = new int[maxSize];
	}

	/**
	 * getters and setters for the instance variables of the class
	 */
	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}

	public int getItemsCount() {
		return itemsCount;
	}

	public void setItemsCount(int itemsCount) {
		this.itemsCount = itemsCount;
	}

	/**
	 * ordered Insert, inserts a new element in its correct position
	 */
	public String orderedInsert(int x) {
		// if array is full
		if (itemsCount == array.length)
			return "The array is full";
		// if array is empty
		if (itemsCount == 0) {
			array[0] = x;
			itemsCount++;
			return String.format("The number (%1$d) is inserted successfully", x);
		}
		// if array is not empty
		for (int i = 0; i < itemsCount; i++) {
			if (array[i] > x) {
				continue;
			}
		}
		array[itemsCount] = x;
		itemsCount++;
		return String.format("The number (%1$d) is inserted successfully", x);
	}

	/**
	 * Display all of the array elements
	 */
	public void displayArray() {
		System.out.print("Sorted Array Elements are: ");
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}

	/**
	 * Returns index of a certain element if found, else return -1
	 */
	public int linearSearch(int x) {
		for (int i = 0; i < itemsCount; i++)
			if (array[i] == x)
				return i;
		return -1;
	}

	/**
	 * Returns index of a certain element if found binary, else return -1
	 */
	public String binarySearchIter(int x) {
		int lowerBound = 0;
		int upperBound = itemsCount - 1;
		int pos;
		while (lowerBound <= upperBound) {
			pos = (lowerBound + upperBound) / 2;
			if (array[pos] == x)
				return String.format("The element (%1$d) is found at index of (%2$d).", x, pos);
			else if (x > array[pos])
				lowerBound = pos + 1;
			else
				upperBound = pos - 1;
		}
		return String.format("The element (%1$d) is not found.", x);
	}

	/**
	 * Returns index of a certain element if found recursively, else return -1
	 */
	public int binarySearchRec(int x) {
		return binary(0, itemsCount - 1, x);
	}

	public int binary(int lowerBound, int upperBound, int x) {
		int pos = lowerBound + (upperBound - lowerBound) / 2;
		if (lowerBound > upperBound)
			return -1;
		else if (array[pos] == x)
			return pos;
		else if (x > array[pos])
			return binary(pos + 1, upperBound, x);
		else
			return binary(lowerBound, pos - 1, x);
	}

	/**
	 * Deletes an element if found in array
	 */
	public String delete(int x) {
		int index = this.linearSearch(x);
		if (index == -1)
			return String.format("This number (%1$d) is not found", x);
		// shift the rest of the elements by one position
		for (int i = index; i < itemsCount - 1; i++)
			array[i] = array[i + 1];
		itemsCount--;
		return String.format("This number (%1$d) is deleted", x);
	}

	public static void main(String[] args) {
		LinearSortedArray linearSortedArray = new LinearSortedArray(5);
		linearSortedArray.orderedInsert(5);
		linearSortedArray.orderedInsert(15);
		linearSortedArray.orderedInsert(25);
		linearSortedArray.orderedInsert(35);
		linearSortedArray.displayArray();
		System.out.println(linearSortedArray.binarySearchIter(35));
		System.out.println(linearSortedArray.delete(35));
	}
}
