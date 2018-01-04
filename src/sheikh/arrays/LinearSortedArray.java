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

	public static void main(String[] args) {
		LinearSortedArray linearSortedArray = new LinearSortedArray(5);
		// linearSortedArray.displayArray();
		// System.out.println(linearSortedArray.orderedInsert(5));
		// System.out.println(linearSortedArray.orderedInsert(15));
		// System.out.println(linearSortedArray.orderedInsert(25));
		// System.out.println(linearSortedArray.orderedInsert(35));
		// linearSortedArray.displayArray();

	}
}
