package sheikh.objects;

import sheikh.queues.PriorityQueue;

public class University implements Comparable<Object> {
	private int rank;
	private String name;

	public University(String name, int rank) {
		this.name = name;
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String toString() {
		return "University name is " + name + ", and its rank is: " + rank;
	}

	@Override
	public int compareTo(Object arg0) {
		// Best practice
		University other = (University) arg0;
		if (rank == other.rank)
			return name.compareTo(other.name);
		return rank - other.rank;
		/*
		 * // The way I did it 
		 * University uni = (University) arg0; if (this.getRank()
		 * > uni.getRank()) return 1; else if (this.getRank() < uni.getRank()) return
		 * -1; else if (this.getName().compareTo(uni.getName()) < 0) return -1; else if
		 * (this.getName().compareTo(uni.getName()) > 0) return 1; else return 0;
		 */
	}

	public static void main(String[] args) {
		PriorityQueue x = new PriorityQueue(5);
		x.insert(new University("FCIC", 4));
		x.insert(new University("GUC", 3));
		x.insert(new University("BUE", 4));
		x.insert(new University("AUC", 2));
		x.insert(new University("FCIS", 1));
		while (!x.isEmpty())
			System.out.println(x.remove());
	}
}
