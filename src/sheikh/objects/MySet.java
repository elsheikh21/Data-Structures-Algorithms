package sheikh.objects;

public class MySet {
	private int[] arr;
	private int itemsCount;

	public MySet() {
		arr = new int[100];
		itemsCount = -1;
	}

	public int cardinality() {
		return itemsCount;
	}

	public void insert(int element) {
		if (itemsCount == arr.length - 1)
			return;
		if (!contains(element)) {
			itemsCount++;
			arr[itemsCount] = element;
		}
	}

	public void remove(int element) {
		int index = atIndex(element);
		if (index == -1)
			return;
		for (int i = index; i < itemsCount; i++) {
			arr[i] = arr[i + 1];
		}
	}

	public int atIndex(int element) {
		int index = -1;
		for (int i = 0; i < itemsCount; i++)
			if (arr[i] == element) {
				index = i;
				break;
			}
		return index;
	}

	public boolean contains(int element) {
		for (int i = 0; i < arr.length; i++)
			if (arr[i] == element)
				return true;
		return false;
	}

	public void replace(int x, int y) {
		if (!contains(x)) {
			insert(y);
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == x) {
				arr[i] = y;
				break;
			}
		}
	}

	public boolean isEmpty() {
		return itemsCount == -1;
	}

	public void displayMySet() {
		System.out.print("My Set contains: ");
		for (int i = 0; i < itemsCount; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		MySet s = new MySet();
		s.insert(1);
		s.insert(1);
		s.insert(2);
		s.insert(4);
		System.out.println("Original State: ");
		s.displayMySet();
		s.remove(2);
		System.out.println("After Delete: ");
		s.displayMySet();
		System.out.println("Does Set contain 4? ");
		System.out.println(s.contains(4));
		System.out.println("Does Set contain 2? ");
		System.out.println(s.contains(2));
		s.replace(1, 5);
		System.out.println("After replace 1 with 5");
		s.displayMySet();
		System.out.println(s.isEmpty());
	}

}
