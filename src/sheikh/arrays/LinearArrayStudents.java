package sheikh.arrays;

public class LinearArrayStudents {
	private Student[] array;
	private int itemsCount;

	/**
	 * Empty constructor just gives you an instance of that object. You might use
	 * setters on it to set necessary properties. If you want to make sure that any
	 * instance created is always valid and any member variables are always
	 * initialized,then you would define the constructor which initializes all the
	 * required member variables.
	 */
	public LinearArrayStudents() {
		super();
	}

	/**
	 * If you want to make sure that any instance created is always valid and any
	 * member variables are always initialized,then you would define the constructor
	 * which initializes all the required member variables.
	 */
	public LinearArrayStudents(int maxSize) {
		itemsCount = 0;
		array = new Student[maxSize];
	}

	/**
	 * getters and setters for the instance variables of the class
	 */
	public Student[] getArray() {
		return array;
	}

	public void setArray(Student[] array) {
		this.array = array;
	}

	public int getItemsCount() {
		return itemsCount;
	}

	public void setItemsCount(int itemsCount) {
		this.itemsCount = itemsCount;
	}

	/**
	 * returns the position of a specific element and -1 if it is not found.
	 * 
	 * @param x
	 */
	public int isAtIndex(Student student) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].getId() == student.getId())
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
			System.out.println("Student's First Name: " + array[i].getFirstName() + "Student's Last Name: "
					+ array[i].getLastName() + "Student's ID: " + array[i].getId());
		System.out.println();
	}

	/**
	 * returns the position of a specific element and states if it is not found.
	 */
	public String linearSearch(Student student) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].getId() == student.getId())
				return String.format("This element %1$d is found at index of %2$d", student.getId(), i);
		}
		return String.format("This element %1$d is not found", student.getId());
	}

	/**
	 * insertLast which inserts a new element at the end of the array first we need
	 * to check if the array is full or not, in case array is not full, add the
	 * element to the end of the array and increment the itemsCount var
	 */
	public String insertLast(Student student) {
		if (array.length == itemsCount)
			return "The array is full";
		for (int i = 0; i < itemsCount; i++)
			array[i + 1] = array[i];
		array[itemsCount + 1] = student;
		itemsCount++;
		return String.format("The student with ID: %1$d is inserted at the end of the array", student.getId());
	}

	/**
	 * insertFirst which inserts a new element at the beginning of the array first,
	 * we need to check if the array is full or not, in case array is not full, add
	 * the element to the beginning of the array, after shifting the elements by one
	 * and increment the itemsCount var
	 */
	public String insertFirst(Student student) {
		if (array.length == itemsCount)
			return "The array is full";
		for (int i = itemsCount; i > 0; i++)
			array[i] = array[i - 1];
		array[0] = student;
		itemsCount++;
		return String.format("The student with ID: %1$d is inserted at the beginning of the array", student.getId());
	}

	/**
	 * deletes a specific element from the array
	 */
	public String delete(Student student) {
		int index = this.isAtIndex(student);
		if (index == -1)
			return String.format("The student with ID: %1$d is not found.", student.getId());
		for(int i = index; i < itemsCount - 1; i++) {
			array[i] = array[i + 1];
		}
		array[itemsCount] = student;
		itemsCount--;
		return String.format("The student with ID: %1$d is deleted.", student.getId());
	}

}
