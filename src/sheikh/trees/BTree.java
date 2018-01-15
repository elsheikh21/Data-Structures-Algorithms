package sheikh.trees;

import java.util.*;

@SuppressWarnings("rawtypes")
class Node {
	public Comparable data;
	public Node left, right;

	public Node(Comparable data) {
		this(data, null, null);
	}

	public Node(Comparable data, Node left, Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

@SuppressWarnings({ "unchecked", "rawtypes" })
public class BTree {
	private Node root;

	public BTree() {
		root = null;
	}

	public void add(Comparable key) {
		Node current = root;
		Node parent = null;
		while (current != null) {
			if (key.compareTo(current.data) < 0) {
				parent = current;
				current = current.left;
			}

			else {
				parent = current;
				current = current.right;
			}
		}

		if (parent == null)
			root = new Node(key);

		else {
			if (key.compareTo(parent.data) < 0)
				parent.left = new Node(key);

			else
				parent.right = new Node(key);
		}
	}

	public boolean delete(Comparable key) {
		if (root == null)
			return false;
		Node current = root;
		Node parent = root;
		boolean right = true;
		// searching for the node to be deleted
		while (key.compareTo(current.data) != 0) {
			if (key.compareTo(current.data) < 0) {
				right = false;
				parent = current;
				current = current.left;
			} else {
				right = true;
				parent = current;
				current = current.right;
			}
			if (current == null)
				return false;
		}

		Node substitute = null;
		// case 1: Node to be deleted has no children
		if (current.left == null && current.right == null)
			substitute = null;

		// case 2: Node to be deleted has one child
		else if (current.left == null)
			substitute = current.right;
		else if (current.right == null)
			substitute = current.left;
		else // case 3: Node to be deleted has two children
		{
			Node successor = current.right;
			Node successorParent = current;
			// searching for the inorder successor of the node to be deleted
			while (successor.left != null) {
				successorParent = successor;
				successor = successor.left;
			}
			substitute = successor;
			if (successorParent.equals(current)) {
				if (successor.right == null)
					successorParent.right = null;
				else
					successorParent.right = successor.right;
			} else {
				if (successor.right == null)
					successorParent.left = null;
				else
					successorParent.left = successor.right;
			}
			successor.right = current.right;
			successor.left = current.left;
			substitute = successor;
		} // case 3 done
		if (current.equals(root)) // Replacing the deleted node
			root = substitute;
		else if (right)
			parent.right = substitute;
		else
			parent.left = substitute;
		return true;

	}

	public void displayTree() {
		Stack<Node> globalStack = new Stack<Node>();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println("......................................................");
		while (!isRowEmpty) {
			Stack<Node> localStack = new Stack<Node>();
			isRowEmpty = true;

			for (int j = 0; j < nBlanks; j++)
				System.out.print(' ');

			while (!globalStack.isEmpty()) {
				Node temp = globalStack.pop();
				if (temp != null) {
					System.out.print(temp.data);
					localStack.push(temp.left);
					localStack.push(temp.right);

					if (temp.left != null || temp.right != null)
						isRowEmpty = false;
				} else {
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for (int j = 0; j < nBlanks * 2 - 2; j++)
					System.out.print(' ');
			} // end while globalStack not empty
			System.out.println();
			nBlanks /= 2;
			while (!localStack.isEmpty())
				globalStack.push(localStack.pop());
		} // end while isRowEmpty is false
		System.out.println("......................................................");
		System.out.println();
	}

	public static BTree idealTopology(int[] a) {
		BTree b = new BTree();
		// returns a node to be the root of the BST
		// start(0) and the end(a.length - 1) 
		b.root = idealTopology(a, 0, a.length - 1);
		return b;
	}

	private static Node idealTopology(int[] a, int start, int end) {
		// Stopping step
		if (start > end)
			return null;
		// change the mid instance to have another element
		int mid = start + (end - start) / 2;
		// insert the middle element of the array
		Node n = new Node(a[mid]);
		// Node (n) is treated as the root and created with right and left nodes
		n.left = idealTopology(a, start, mid - 1);
		n.right = idealTopology(a, mid + 1, end);
		return n;
	}

	// BST stands for Binary Search Tree
	public Comparable maxKeyBST() {
		// start with the root
		Node curr = root;
		// go down till the end (null val of the next right node
		while (curr.right != null)
			curr = curr.right;
		// according to the BST property that the farthest right node is the largest
		// value
		return (Comparable) curr.data;
	}

	// BT stands for Binary Tree
	public Comparable maxKeyBT() {
		return maxKeyBT(root);
	}

	private Comparable maxKeyBT(Node curr) {
		if (curr == null)
			return -1;
		int maxLeft = (int) maxKeyBT(curr.left);
		int maxRight = (int) maxKeyBT(curr.right);
		return Math.max((int) curr.data, Math.max(maxLeft, maxRight));
	}

	public int size() {
		return size(this.root);
	}

	private int size(Node curr) {
		if (curr == null)
			return 0;
		return 1 + size(curr.right) + size(curr.left);
	}

	public int numLeaves() {
		return numLeaves(root);
	}

	private int numLeaves(Node curr) {
		if (curr.right == null && curr.left == null)
			return 1;
		return numLeaves(curr.right) + numLeaves(curr.left);
	}

	public int sumOfNodes() {
		return sumOfNodes(root);
	}

	private int sumOfNodes(Node curr) {
		if (curr == null)
			return 0;
		return ((int) curr.data) + sumOfNodes(curr.right) + sumOfNodes(curr.left);
	}

	public boolean isBST() {
		return isBST(root);
	}

	private boolean isBST(Node node) {
		if (node == null)
			return true;
		if (node.left != null && maxValue(node.left).compareTo(node.data) > 0)
			return false;
		if (node.right != null && minValue(node.right).compareTo(node.data) <= 0)
			return false;
		return isBST(node.left) && isBST(node.right);
	}

	private Comparable minValue(Node node) {
		Node curr = node;
		while (curr.left != null)
			curr = curr.left;
		return curr.data;
	}

	private Comparable maxValue(Node node) {
		Node curr = node;
		while (curr.right != null)
			curr = curr.right;
		return curr.data;
	}

	public int numLeftChildNodes() {
		return numLeftChildNodes(root);
	}

	private int numLeftChildNodes(Node node) {
		if (node == null)
			return 0;
		if (node.right == null && node.left != null)
			return 1 + numLeftChildNodes(node.left);
		return numLeftChildNodes(node.right) + numLeftChildNodes(node.left);
	}

	public int countOccur(Comparable key) {
		return countOccur(root, key);
	}

	private int countOccur(Node node, Comparable key) {
		if (node == null)
			return 0;
		if (node.data.compareTo(key) == 0)
			return 1 + countOccur(node.left, key) + countOccur(node.right, key);
		return countOccur(node.left, key) + countOccur(node.right, key);
	}

	public boolean hasDups(Comparable key) {
		return (countOccur(root, key) < 2);
	}

	public String oddNodes() {
		return oddNodes(root, "");
	}

	private String oddNodes(Node node, String odd) {
		String str = odd;
		if (node == null)
			return "";
		if (((int) node.data) % 2 != 0)
			return str+= node.data + " " + oddNodes(node.left, str) + oddNodes(node.right, str);
		else
			return oddNodes(node.left, str) + oddNodes(node.right, str);
	}
	
	
	public void mirror() {
		mirror(root);
	}

	public void mirror(Node node) {
		if (node == null)
			return;
		Node temp = node.right;
		node.right = node.left;
		node.left = temp;
		mirror(node.right);
		mirror(node.left);
	}

	public int levelIter(Comparable key) {
		Node node = root;
		int levelCount = 0;
		while (node != null) {
			if (key.compareTo(node.data) < 0) {
				node = node.left;
				levelCount++;
			} else if (key.compareTo(node.data) > 0) {
				node = node.right;
				levelCount++;
			} else {
				return levelCount;
			}
		}
		return -1;
	}

	public int levelRec(Comparable key) {
		return level(root, key);
	}

	private int level(Node node, Comparable key) {
		if (node == null)
			return -1;
		if (key.compareTo(node.data) < 0) {
			return 1 + level(node.left, key);
		} else if (key.compareTo(node.data) > 0) {
			return 1 + level(node.right, key);
		} else
			return 0;
	}

	public int noOfIterationsTill(Comparable key) {
		return noOfIterationsTill(root, key);
	}

	public int noOfIterationsTill(Node node, Comparable key) {
		if (node == null)
			return 0;
		if (node.data.compareTo(key) == 0)
			return 1;
		return 1 + noOfIterationsTill(node.left, key) + noOfIterationsTill(node.right, key);
	}

	public BTree doubleValues() {
		return doubleValuesRec(this, this.root);
	}

	private BTree doubleValuesRec(BTree bTree, Node node) {
		if (node == null)
			return bTree;
		node.data = (int) node.data * 2;
		doubleValuesRec(bTree, node.left);
		doubleValuesRec(bTree, node.right);
		return bTree;
	}

	public boolean isEqual(BTree t) {
		return isEqual(this.root, t.root);
	}

	private boolean isEqual(Node bT, Node t) {
		if (bT == null && t == null)
			return true;
		else if (bT == null || t == null)
			return false;
		else
			return (bT.data.compareTo(t.data) == 0) && isEqual(bT.left, t.left) && isEqual(bT.right, t.right);
	}
}