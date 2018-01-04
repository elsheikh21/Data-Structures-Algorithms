package sheikh.arrays;

/**
 * Design a class "Linear Array" which is represented by 2 instance variables:
 * (Array of integers, integer) the integer represents the total number of
 * elements inserted in the array
 * 
 * @author Sheikh
 */
public class LinearArray {
	int[] array;
	int itemsCount;

	/**
	 * Empty constructor just gives you an instance of that object. You might use
	 * setters on it to set necessary properties. If you want to make sure that any
	 * instance created is always valid and any member variables are always
	 * initialized,then you would define the constructor which initializes all the
	 * required member variables.
	 */
	public LinearArray() {
		super();
	}

	/**
	 * If you want to make sure that any instance created is always valid and any
	 * member variables are always initialized,then you would define the constructor
	 * which initializes all the required member variables.
	 */
	public LinearArray(int maxSize) {
		array = new int[maxSize];
	}

	/**
	 * returns the position of a specific element and -1 if it is not found.
	 * 
	 * @param x
	 */
	public int isAtIndex(int x) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == x)
				return i;
		}
		return -1;
	}

	/**
	 * display the array elements
	 */
	public void printArrayElements() {
		if (array == null) {
			System.out.println("The array is empty.");
			return;
		}
		System.out.print("Array elements are: ");
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}

	/**
	 * creates elements to insert in the array
	 */
	public void createArray(int maxSize) {
		for (int i = 0; i < maxSize; i++) {
			array[i] = (int) ((Math.random() * 6) + 1);
		}
	}

	/**
	 * returns the position of a specific element and states if it is not found.
	 */
	public String linearSearch(int x) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == x)
				return String.format("This element %1$d is found at index of %2$d", x, i);
		}
		return String.format("This element %1$d is not found", x);
	}

	/**
	 * insertLast which inserts a new element at the end of the array first
	 * we need to check if the array is full or not, in case array is not full, add
	 * the element to the end of the array and increment the itemsCount var
	 */
	public String insertLast(int x) {
		
	}

	/**
	 * insertFirst which inserts a new element at the beginning of the array
	 * first, we need to check if the array is full or not, in case array is not
	 * full, add the element to the beginning of the array, after shifting the
	 * elements by one and increment the itemsCount var
	 */
	public String insertFirst(int x) {
		
	}

	/**
	 * deletes a specific element from the array
	 */
	public String delete(int x) {
		
	}

	// TODO: insert last/first & delete
	public static void main(String[] args) {
		// LinearArray linearArray = new LinearArray();
		LinearArray linearArray = new LinearArray(5);

		// linearArray.createArray(5);
		linearArray.printArrayElements();

		// System.out.println(linearArray.insertFirst(3));
		// System.out.println(linearArray.insertLast(5));

		// System.out.println(linearArray.linearSearch(3));
		// System.out.println(linearArray.linearSearch(18));
	}

}
