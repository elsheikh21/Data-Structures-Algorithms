package sheikh.hashtables;

import java.util.HashSet;

public class HashTableUtilities {

	// depending upon that HashSet add will not change the cell entries if they
	// already exist
	public static Object[] removeDuplicates(int[] a) {
		HashSet<Integer> hashSet = new HashSet<>();
		for (int i = 0; i < a.length; i++)
			// if the cell contains this element it returns a false and do nothing
			hashSet.add(a[i]);
		return hashSet.toArray();
	}

	// NOT depending upon that HashSet add will not change the cell entries if they
	// already exist
	public static int[] removeDups(int[] a) {
		HashSet<Integer> hashSet = new HashSet<>();
		int[] Dups = new int[a.length];
		int[] withoutDups = new int[a.length];
		int countUnique = 0;
		int notUnique = 0;
		for (int i = 0; i < a.length; i++)
			if (hashSet.add(a[i]))
				withoutDups[countUnique++] = a[i];
			else
				Dups[notUnique++] = a[i];

		int[] res = new int[countUnique];
		for (int i = 0; i < countUnique; i++)
			res[i] = withoutDups[i];
		return res;
	}

	public static Object[] symmetricDifference(int[] a, int[] b) {
		HashSet<Integer> hashSet = new HashSet<>();
		int aSize = a.length;
		int bSize = b.length;
		if (aSize > bSize) {
			Object[] x = union(intersection1(a, b), intersection1(b, a));
			for (int i = 0; i < x.length; i++)
				hashSet.add((Integer) x[i]);
		} else {
			Object[] x = union(intersection(b, a), intersection(a, b));
			for (int i = 0; i < x.length; i++)
				hashSet.add((Integer) x[i]);
		}
		return hashSet.toArray();
	}

	private static Object[] union(Object[] a, Object[] b) {
		HashSet<Integer> hashSet = new HashSet<>();
		for (int i = 0; i < a.length; i++)
			hashSet.add((Integer) a[i]);
		for (int j = 0; j < b.length; j++)
			hashSet.add((Integer) b[j]);
		return hashSet.toArray();
	}

	// Quadratic
	private static Object[] intersection(int[] a, int[] b) {
		HashSet<Integer> hashSet = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			boolean found = false;
			for (int j = 0; j < b.length; j++) {
				if (a[i] == b[j]) {
					found = true;
					break;
				}
			}
			if (!found)
				hashSet.add(a[i]);
		}
		return hashSet.toArray();
	}

	// linear
	private static Object[] intersection1(int[] a, int[] b) {
		HashSet<Integer> hashSet = new HashSet<>();
		HashSet<Integer> hashSet1 = new HashSet<>();
		for (int i = 0; i < a.length; i++)
			hashSet.add(a[i]);
		for (int j = 0; j < b.length; j++)
			if (hashSet.contains(b[j]))
				hashSet1.add(b[j]);
		return hashSet1.toArray();
	}
}
