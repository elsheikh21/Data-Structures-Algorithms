package sheikh.objects;

import java.util.*;

public class YoghurtProduct implements Comparable<Object> {
	private int id;
	private double price;
	private Date expiryDate;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double newPrice) {
		this.price = newPrice;
	}

	public Date getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public int compareTo(Object o) {
		YoghurtProduct y = (YoghurtProduct) o;
		return (expiryDate.compareTo(y.expiryDate));
	}

	public YoghurtProduct(int id, double price, Date expiryDate) {
		this.id = id;
		this.price = price;
		this.expiryDate = expiryDate;
	}

}
