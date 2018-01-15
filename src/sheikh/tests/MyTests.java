package sheikh.tests;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.*;

import sheikh.treesii.BST;

public class MyTests {

	@Test(timeout = 3000)
	public void recursivePathToItemTest() {
		BST bst = new BST(); // class to be tested
		bst.insert(22);
		bst.insert(5);
		bst.insert(1);
		bst.insert(12);
		bst.insert(24);
		bst.insert(52);
		bst.insert(11);
		bst.insert(23);
		assertTrue(3 == bst.path(12).size());
	}

	@Test(timeout = 3000)
	public void recursiveHeightBSTTest() {
		BST bst = new BST(); // class to be tested
		bst.insert(22);
		bst.insert(5);
		bst.insert(1);
		bst.insert(12);
		bst.insert(24);
		bst.insert(52);
		bst.insert(11);
		bst.insert(23);
		assertEquals(4, bst.height(), String.valueOf(bst.height()));
	}

	@Test(timeout = 3000)
	public void iterativeHeightBSTTest() {
		BST bst = new BST(); // class to be tested
		bst.insert(22);
		bst.insert(5);
		bst.insert(1);
		bst.insert(12);
		bst.insert(24);
		bst.insert(52);
		bst.insert(11);
		bst.insert(23);
		bst.insert(52);
		assertEquals(4, bst.heightIter(), String.valueOf(bst.heightIter()));
	}

	@Test(timeout = 3000)
	public void iterativePathToItemTest() {
		BST bst = new BST(); // class to be tested
		bst.insert(22);
		bst.insert(5);
		bst.insert(1);
		bst.insert(12);
		bst.insert(24);
		bst.insert(52);
		bst.insert(11);
		bst.insert(23);
		assertTrue(3 == bst.pathIter(12).size());
	}

	
}
