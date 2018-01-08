package sheikh.objects;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Link {
	private String url;
	private String date; // Format YYYY -MM -DD
	private int frequency; // number of times a url has been visited

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public Link(String url) {
		this.url = url;
		this.frequency = 0;
		// gets the current date
		Calendar cal = Calendar.getInstance();
		Date calDate = cal.getTime();
		// and convert it into YYYY -MM -DD
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy -MM -dd");
		try {
			date = format1.format(calDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Link(String url, int frequency) {
		this(url);
		this.frequency = frequency;
	}
	
	public String toString() {
		return url + " " + date + "  frequency  " + frequency;
	}
	
}