package sheikh.tests;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.*;

import sheikh.hashtables.*;
//import sheikh.treesii.BST;

public class MyTests {
	// Trees II

	// @Test(timeout = 3000)
	// public void recursivePathToItem() {
	// BST bst = new BST();
	// bst.insert(22);
	// bst.insert(5);
	// bst.insert(1);
	// bst.insert(12);
	// bst.insert(24);
	// bst.insert(52);
	// bst.insert(11);
	// bst.insert(23);
	// assertTrue(3 == bst.path(12).size());
	// }
	//
	// @Test(timeout = 3000)
	// public void recursiveHeightBST() {
	// BST bst = new BST();
	// bst.insert(22);
	// bst.insert(5);
	// bst.insert(1);
	// bst.insert(12);
	// bst.insert(24);
	// bst.insert(52);
	// bst.insert(11);
	// bst.insert(23);
	// assertEquals(4, bst.height(), String.valueOf(bst.height()));
	// }
	//
	// @Test(timeout = 3000)
	// public void iterativeHeightBST() {
	// BST bst = new BST();
	// bst.insert(22);
	// bst.insert(5);
	// bst.insert(1);
	// bst.insert(12);
	// bst.insert(24);
	// bst.insert(52);
	// bst.insert(11);
	// bst.insert(23);
	// bst.insert(52);
	// assertEquals(4, bst.heightIter(), String.valueOf(bst.heightIter()));
	// }
	//
	// @Test(timeout = 3000)
	// public void iterativePathToItem() {
	// BST bst = new BST();
	// bst.insert(22);
	// bst.insert(5);
	// bst.insert(1);
	// bst.insert(12);
	// bst.insert(24);
	// bst.insert(52);
	// bst.insert(11);
	// bst.insert(23);
	// assertTrue(3 == bst.pathIter(12).size());
	// }

	// Hash tables

	@Test
	public void removeDuplicates() {
		int test[] = { 10, 1, 2, 6, 5, 1, 10, 19, -3, -3, 1, 0, 20, 2 };
		assertEquals("[0, 1, 2, -3, 19, 20, 5, 6, 10]", Arrays.toString(HashTableUtilities.removeDuplicates(test)));
	}

	@Test
	public void removeDups() {
		int test[] = { 10, 1, 2, 6, 5, 1, 10, 19, -3, -3, 1, 0, 20, 2 };
		assertEquals("[10, 1, 2, 6, 5, 19, -3, 0, 20]", Arrays.toString(HashTableUtilities.removeDups(test)));
	}

	@Test
	public void size() {
		MyHashTable h = new MyHashTable();
		h.insert(4);
		h.insert(5);
		h.insert(1);
		h.insert(12);
		h.insert(2);
		assertEquals(4, h.size());
	}

	@Test
	public void findOnEmpty() {
		MyHashTable h = new MyHashTable();
		assertFalse(h.find(3));
	}

	@Test
	public void insertOnFull() {
		MyHashTable h = new MyHashTable();
		h.insert(12);
		h.insert(2);
		h.insert(4);
		h.insert(5);
		h.insert(1);
		h.insert(12);
		h.insert(2);
		h.insert(4);
		h.insert(5);
		h.insert(1);
		h.insert(12);
		h.insert(2);
		h.insert(13);
		assertFalse(h.insert(13));
	}

	@Test
	public void findNonExistingELement() {
		MyHashTable h = new MyHashTable();
		h.insert(4);
		h.insert(5);
		h.insert(1);
		h.insert(12);
		h.insert(2);
		assertFalse(h.find(3));
	}

	@Test
	public void findExistingELement() {
		MyHashTable h = new MyHashTable();
		h.insert(4);
		h.insert(5);
		h.insert(1);
		h.insert(12);
		h.insert(2);
		assertTrue(h.find(4));
	}

	@Test
	public void symmetricDifference() {
		int[] a = { 1, 2, 5, 3, 0, 8 };
		int[] b = { 3, 5, -2, 10, 8, 7 };
		Object[] actual = { 0, -2, 1, 2, 7, 10 };
		Object[] expected = HashTableUtilities.symmetricDifference(a, b);
		assertArrayEquals(actual, expected);
	}

}