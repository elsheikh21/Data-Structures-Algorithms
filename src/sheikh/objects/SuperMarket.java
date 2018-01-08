package sheikh.objects;

import java.util.Date;
import sheikh.queues.PriorityQueue;
import sheikh.stacks.StackObject;

public class SuperMarket {
	PriorityQueue priorityQueue;

	public SuperMarket(int maxSize) {
		priorityQueue = new PriorityQueue(maxSize);
	}

	public void addProduct(YoghurtProduct yoghurtProduct) {
		if (!priorityQueue.isFull())
			priorityQueue.insert(yoghurtProduct);
		else
			System.out.println("You can not add more yoghurts.");
	}

	public double newPrice(int productID) {
		double newPrice = -1.0;
		if (priorityQueue.isEmpty()) {
			System.out.println("Your SuperMarket is already empty.");
			return -1.0;
		} else {
			YoghurtProduct y = searchFor(productID);
			if (y == null) {
				System.out.println("There is no such product.");
				return -1.0;
			}
			newPrice = y.getPrice() * (1.0 - (0.5 - ((atIndex(productID) - 1) * 0.05)));
			y.setPrice(newPrice);
		}
		return newPrice;
	}

	private int atIndex(int productID) {
		int index = -1;
		StackObject stack = new StackObject(priorityQueue.size());
		while (!priorityQueue.isEmpty()) {
			YoghurtProduct y = (YoghurtProduct) priorityQueue.remove();
			if (y.getId() == productID) {
				break;
			}
			stack.push(y);
			index++;
		}
		while (!stack.isEmpty()) {
			priorityQueue.insert((YoghurtProduct) stack.pop());
		}
		return index;
	}

	private YoghurtProduct searchFor(int productID) {
		StackObject stack = new StackObject(priorityQueue.size());
		YoghurtProduct y = null;
		while (!priorityQueue.isEmpty()) {
			y = (YoghurtProduct) priorityQueue.remove();
			stack.push(y);
			if (y.getId() == productID) {
				break;
			}
		}
		while (!stack.isEmpty())
			priorityQueue.insert((YoghurtProduct) stack.pop());
		return y;
	}

	@SuppressWarnings("deprecation") // this suppression to be removed, and fixed.
	public static void main(String[] args) {
		YoghurtProduct p1 = new YoghurtProduct(1, 2.0, new Date(2014, 10, 30));
		YoghurtProduct p2 = new YoghurtProduct(2, 3.0, new Date(2014, 10, 27));
		YoghurtProduct p3 = new YoghurtProduct(3, 8.0, new Date(2014, 10, 26));
		YoghurtProduct p4 = new YoghurtProduct(4, 4.0, new Date(2014, 10, 27));
		YoghurtProduct p5 = new YoghurtProduct(5, 5.0, new Date(2014, 10, 27));
		YoghurtProduct p6 = new YoghurtProduct(6, 6.0, new Date(2014, 10, 26));
		SuperMarket s = new SuperMarket(6);
		s.addProduct(p1);
		s.addProduct(p2);
		s.addProduct(p3);
		s.addProduct(p4);
		s.addProduct(p5);
		s.addProduct(p6);
		System.out.println("The new price is: $" + s.newPrice(4)); // 45% 2.2
	}

}
