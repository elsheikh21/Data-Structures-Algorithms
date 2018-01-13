package sheikh.trees;

public class Topology {

	public static void main(String[] args) {
		int[] bstElems = { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 60, 65, 70, 75, 80, 95, 100 };
		BTree bst = idealTop(bstElems);
		bst.displayTree();
		// System.out.println(bst.getMax());
		// System.out.println(bst.size());
		// System.out.println(bst.numLeaves());
		// System.out.println(bst.sumOfNodes());
		// System.out.println(bst.isBST());
		// System.out.println(bst.numLeftChildNodes());
		// System.out.println(bst.countOccur(2));
		// System.out.println(bst.hasDups(2));
		// System.out.println(bst.oddNodes());
		// bst.mirror();
		// bst.displayTree();
		// System.out.println(bst.levelIter(100));
		// System.out.println(bst.levelRec(100));
		bst.doubleValues().displayTree();
		
	}

	public static BTree idealTop(int[] s) {
		BTree bst = new BTree();
		// amends the (t) BST
		addMiddle(0, s.length - 1, s, bst);
		return bst;
	}

	private static void addMiddle(int start, int end, int[] s, BTree bst) {
		if (end < start)
			return;
		int mid = start + (end - start) / 2;
		bst.add(s[mid]);
		// create sub trees for the node (t.add(s[mid])) as if it is the root
		addMiddle(start, mid - 1, s, bst);
		addMiddle(mid + 1, end, s, bst);
	}
}