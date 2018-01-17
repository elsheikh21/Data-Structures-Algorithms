package sheikh.hashtables;

import java.util.Arrays;

public class MyHashTable {
	private int N;
	private int[] table;
	private int itemsCount;

	public MyHashTable() {
		itemsCount = -1;
		N = 11;
		table = new int[N];
		Arrays.fill(table, -1);
	}

	public int h(int key) {
		return (3 * key + 17) % N;
	}

	public boolean insert(int key) {
		if (table.length == itemsCount)
			return false;
		if (!find(key)) {
			int index = h(key);
			if (table[index] == -1)
				table[index] = key;
			else
				insertLinearly(key);
			itemsCount++;
			return true;
		} else {
			for (int i = 0; i < table.length; i++) {
				if (table[i] == -1) {
					table[i] = key;
					itemsCount++;
					return true;
				}
			}
		}
		return false;
	}

	private void insertLinearly(int key) {
		int index = h(key);
		for (int i = index; i < table.length; i++) {
			if (table[i] == -1) {
				table[i] = key;
				return;
			}
		}
		for (int i = 0; i < table.length; i++) {
			if (table[i] == -1) {
				table[i] = key;
				return;
			}
		}
	}

	public boolean find(int key) {
		if (itemsCount == 0)
			return false;
		for (int i = 0; i < table.length; i++)
			if (table[i] == key)
				return true;
		return false;
	}

	public int size() {
		return itemsCount;
	}

	public boolean isFull() {
		return itemsCount == N;
	}

	public boolean isEmpty() {
		return itemsCount == 0;
	}

	public String toString() {
		return Arrays.toString(table);
	}

	public static void main(String[] args) {
		MyHashTable h = new MyHashTable();
		h.insert(4);
		h.insert(5);
		h.insert(1);
		h.insert(12);
		h.insert(2);
		h.insert(2);
		System.out.println(h.size());
		System.out.println(h.toString());
	}
}