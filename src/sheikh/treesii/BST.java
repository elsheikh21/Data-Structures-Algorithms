package sheikh.treesii;

import java.util.*;

import sheikh.linkedlists.LinkList;

class Node {
	public Object data;
	public Node left, right;
}

@SuppressWarnings({ "rawtypes", "unchecked" })
public class BST {
	private Node root;

	public Node search(Object target) {
		return searchHelper(target, root);
	}

	public Node searchHelper(Object target, Node n) {
		// base case
		if (n == null)
			return null;

		if (((Comparable) n.data).compareTo(target) == 0)
			return n;

		// recursive case
		if (((Comparable) n.data).compareTo(target) > 0)
			return searchHelper(target, n.left);

		return searchHelper(target, n.right);
	}

	public void insert(Object newObj) {
		if (root == null) {
			root = new Node();
			root.data = newObj;
			return;
		}
		insertHelper(newObj, root);
	}

	public void insertHelper(Object newObj, Node node) {

		if (((Comparable) node.data).compareTo(newObj) < 0) {
			if (node.right == null) {
				node.right = new Node();
				node.right.data = newObj;
			} else
				insertHelper(newObj, node.right);
		} else {
			if (node.left == null) {
				node.left = new Node();
				node.left.data = newObj;
			} else
				insertHelper(newObj, node.left);
		}

	}

	public void delete(Object target) {
		Node parent;
		Node node;

		node = search(target);
		if (node.equals(null))
			return;

		if (node.left == null && node.right == null) { // case 1: node with no children
			if (node.equals(root))
				root = null;
			else {
				parent = searchForNodeParent(node, root);
				deleteLeaf(parent, node);
			}
		} else {
			// case 2: node with 1 child
			if (node.left != null && node.right == null || node.left == null && node.right != null) {
				if (node.equals(root)) {
					deleteRootwith1Child();
				} else {
					parent = searchForNodeParent(node, root);
					deleteNodewith1Child(parent, node);
				}
			} else {
				deleteNodewith2Children(node); // case 3: node with 2 children
			}
		}
	}

	private Node searchForNodeParent(Node target, Node parent) {
		// base case
		if (parent.left != null && ((Comparable) parent.left.data).compareTo(target.data) == 0)
			return parent;
		if (parent.right != null && ((Comparable) parent.right.data).compareTo(target.data) == 0)
			return parent;
		// recursive cases
		if (((Comparable) parent.data).compareTo(target.data) > 0)
			return searchForNodeParent(target, parent.left);

		return searchForNodeParent(target, parent.right);
	}

	private void deleteLeaf(Node parent, Node node) { // handles case 1
		if (parent.left == node)
			parent.left = null;
		else
			parent.right = null;
	}

	private void deleteRootwith1Child() {
		if (root.left != null)
			root = root.left;
		else
			root = root.right;
	}

	private void deleteNodewith1Child(Node parent, Node node) { // handles case 2
		if (parent.left == node) {
			// node to be deleted must be left child of parent
			if (node.left != null)
				parent.left = node.left;
			else
				parent.left = node.right;
		} else { // node to be deleted must be right child of parent
			if (node.left != null)
				parent.right = node.left;
			else
				parent.right = node.right;
		}
	}

	private void deleteNodewith2Children(Node node) {
		Node current;
		current = node.right;
		while (current.left != null)
			current = current.left;

		Node parent = searchForNodeParent(current, root);
		if (current.right != null)
			deleteNodewith1Child(parent, current);
		else
			deleteLeaf(parent, current);

		node.data = current.data;
	}

	public void preOrder() {
		preOrderHelper(root);
		System.out.println();
	}

	private void preOrderHelper(Node n) {
		if (n == null)
			return;
		System.out.print(n.data + "   ");
		preOrderHelper(n.left);
		preOrderHelper(n.right);
	}

	public void inOrder() {
		inOrderHelper(root);
		System.out.println();
	}

	private void inOrderHelper(Node n) {
		if (n == null)
			return;
		inOrderHelper(n.left);
		System.out.print(n.data + "  ");
		inOrderHelper(n.right);
	}

	public void postOrder() {
		postOrderHelper(root);
		System.out.println();
	}

	private void postOrderHelper(Node n) {
		if (n == null)
			return;
		postOrderHelper(n.left);
		postOrderHelper(n.right);
		System.out.print(n.data + "  ");
	}

	public void printLevel(int level) {
		printLevel(root, level);
		printLevelAcc(root, level, 0);
	}

	private void printLevelAcc(Node node, int level, int soFar) {
		if (node == null) {
			return;
		}
		if (level == 0) {
			System.out.println(node.data);
		} else {
			printLevelAcc(node.left, level, soFar + 1);
			printLevelAcc(node.right, level, soFar + 1);
		}
	}

	public void printLevel(Node n, int level) {
		if (n == null)
			return;
		if (level == 0) {
			System.out.print(n.data + " ");
		} else {
			printLevel(n.left, level - 1);
			printLevel(n.right, level - 1);
		}
	}

	public void breadthTraversal() {
		breadthTraversal(root);
	}

	public void breadthTraversal(Node node) {
		if (node == null)
			return;
		int h = this.height();
		for (int i = 0; i < h; i++)
			printLevel(i);
	}

	public int height() {
		return treeHeight(root);
	}

	public int heightIter() {
		if (root == null)
			return -1;
	
		int countLeft = 0;
		int countRight = 0;
		Node nL = root.left;
		Node nR = root.right;
		while (nL != null) {
			countLeft++;
			nL = nL.left;
		}
		while (nR != null) {
			countLeft++;
			nR = nR.right;
		}
		return Math.max(countLeft, countRight);
	}

	public int treeHeight(Node root) {
		if (root == null)
			return 0;
		return (1 + Math.max(treeHeight(root.left), treeHeight(root.right)));
	}

	public void descOrder() {
		Stack s = descOrder(root, new Stack());
		while (!s.isEmpty())
			System.out.print(s.pop() + " ");
		System.out.println();
	}

	private Stack descOrder(Node node, Stack s) {
		if (node == null)
			return s;
		descOrder(node.left, s);
		s.push(node.data);
		descOrder(node.right, s);
		return s;
	}

	public String descendingOrder() {
		return descendingOrder(root);
	}

	// reversed post order traversal
	public String descendingOrder(Node current) {
		if (current == null)
			return "";
		else
			return (descendingOrder(current.right) + " " + current.data + " " + descendingOrder(current.left));
	}

	public void printRange(int lowerBound, int upperBound) {
		printRange(root, lowerBound, upperBound);
	}

	private void printRange(Node node, int lowerBound, int upperBound) {
		if (node != null) {
			if (((int) node.data) >= lowerBound && ((int) node.data) <= upperBound) {
				System.out.println(node.data + " ");
				printRange(node.left, lowerBound, upperBound);
				printRange(node.right, lowerBound, upperBound);
			} else if (((int) node.data) < lowerBound) {
				printRange(node.left, lowerBound, upperBound);
			} else {
				printRange(node.right, lowerBound, upperBound);
			}
		}
	}

	public void preorderIter() {
		if (root == null)
			return;
		Stack stack = new Stack();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node n = (Node) stack.pop();
			System.out.print(n.data + " ");
			if (n.right != null)
				stack.push(n.right);
			if (n.left != null)
				stack.push(n.left);
		}
	}

	public LinkList path(Comparable key) {
		if (search(key) != null)
			return path(root, key, new LinkList());
		return null;
	}

	public LinkList path(Node node, Comparable key, LinkList linkList) {
		if (node == null)
			return linkList;
		Comparable item = ((Comparable) node.data);
		if (item.compareTo(key) < 0) {
			linkList.insertLast(node.data);
			return path(node.right, key, linkList);
		} else if (item.compareTo(key) > 0) {
			linkList.insertLast(node.data);
			return path(node.left, key, linkList);
		} else {
			linkList.insertLast(node.data);
			return linkList;
		}
	}

	public LinkList pathIter(Comparable key) {
		if (root == null)
			return null;

		LinkList linkList = new LinkList();
		Node node = root;
		while (node != null) {
			Comparable item = (Comparable) node.data;
			if (item.compareTo(key) < 0) {
				linkList.insertLast(node.data);
				node = node.right;
			} else if (item.compareTo(key) > 0) {
				linkList.insertLast(node.data);
				node = node.left;
			} else {
				linkList.insertLast(node.data);
				break;
			}
		}
		return linkList;
	}
	
}
