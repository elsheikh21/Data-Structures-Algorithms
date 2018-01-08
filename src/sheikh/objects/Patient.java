package sheikh.objects;

public class Patient implements Comparable<Object> {
	private String name;
	private int severity;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSeverity() {
		return severity;
	}

	public void setSeverity(int severity) {
		this.severity = severity;
	}

	public Patient(String name, int severity) {
		this.name = name;
		this.severity = severity;
	}

	@Override
	public int compareTo(Object o) {
		Patient p = (Patient) o;
		return this.getSeverity() - p.getSeverity();
	}

	@Override
	public String toString() {
		return String.format("The patient name is: %s, and severity is: %d", name, severity);
	}

}
