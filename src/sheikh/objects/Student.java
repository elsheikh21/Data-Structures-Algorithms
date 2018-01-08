package sheikh.objects;


/**
 * @author Sheikh Define a class Student (first name, last name and id)
 */
public class Student {
	private String firstName;
	private String lastName;
	private int id;
	private double gpa;

	/**
	 * getters and setters for instance variables of the class
	 */
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getGPA() {
		return gpa;
	}

	public void setGpa(int gpa) {
		this.gpa = gpa;
	}
	
	public Student (String firstName, String lastName, int id, double gpa) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.gpa = gpa;
	}
	
}
