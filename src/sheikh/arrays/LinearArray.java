package sheikh.arrays;

/**
 *  Design a class "Linear Array" which is represented by 2
 *  instance variables: (Array of integers, integer) the integer represents
 *  the total number of elements inserted in the array
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

	public LinearArray(int maxSize) {
		array = new int[maxSize];
	}

	/**
	 * insertLast(int x) which inserts a new element at the end of the array first
	 * we need to check if the array is full or not, in case array is not full, add
	 * the element to the end of the array and increment the itemsCount var
	 */
	public String insertLast(int x) {
		if (array.length == itemsCount) {
			return "The array is full.";
		} else {
			array[array.length + 1] = x;
			itemsCount++;
			return String.format("Element is %1$d inserted at the end of the array", String.valueOf(x));
		}
	}

	/**
	 * insertFirst(int x) which inserts a new element at the beginning of the array
	 * first we need to check if the array is full or not, in case array is not
	 * full, add the element to the beginning of the array, after shifting the
	 * elements by one and increment the itemsCount var
	 */
	public String insertFirst(int x) {
		if (array.length == itemsCount) {
			return "The array is full.";
		} else {
			for (int i = 0; i < array.length; i++) {
				array[i] = array[i + 1];
			}
			array[0] = x;
			itemsCount++;
			return String.format("Element is %1$d inserted at the beginning of the array", String.valueOf(x));
		}
	}

	public static void main(String[] args) {

	}

}
