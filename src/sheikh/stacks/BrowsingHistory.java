package sheikh.stacks;

import sheikh.objects.Link;

public class BrowsingHistory {
	StackObject history;
	StackObject helper;

	public BrowsingHistory() {
		super();
		history = new StackObject(1000);
		helper = new StackObject(1000);
	}

	public BrowsingHistory(int s) {
		super();
		history = new StackObject(s);
		helper = new StackObject(s);
	}

	public void add(String url) {
		while (!history.isEmpty()) {
			Link link = (Link) history.pop();
			if (link.getUrl().equals(url)) {
				link.setFrequency(link.getFrequency() + 1);
				break;
			}
			helper.push(link);
		}
		while (!helper.isEmpty())
			history.push(helper.pop());
	}

	public void removeLast() {
		history.pop();
	}

	public void remove(String date) {
		while (!history.isEmpty()) {
			Link link = (Link) history.pop();
			if (!link.getDate().equals(date)) {
				helper.push((Link) link);
			}
		}
		while (!helper.isEmpty())
			history.push((Link) helper.pop());
	}

	public int getNumberOfLinks() {
		return history.size();
	}

	public String search() {
		int max = 0;
		String mostVisited = "";
		while (!history.isEmpty()) {
			Link link = (Link) history.pop();
			if (link.getFrequency() > max) {
				max = link.getFrequency();
				mostVisited = link.getUrl();
			}
			helper.push(link);
		}
		while (!helper.isEmpty())
			history.push(helper.pop());
		return mostVisited;
	}

	public void printAll() {
		history.printStack();
	}
}
