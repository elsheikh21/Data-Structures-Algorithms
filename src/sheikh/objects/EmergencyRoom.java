package sheikh.objects;

import sheikh.queues.PriorityQueue;

public class EmergencyRoom {
	private PriorityQueue pq;

	public EmergencyRoom(int size) {
		pq = new PriorityQueue(size);
	}

	public void newPatient(String name, int severity) {
		if (!pq.isFull()) {
			pq.insert(new Patient(name, severity));
			return;
		} else {
			System.out.println("The ER is full.");
		}
	}

	public Patient nextPatient() {
		if (!pq.isEmpty())
			return (Patient) pq.remove();
		return null;
	}

	public static void main(String[] args) {
		EmergencyRoom r = new EmergencyRoom(5);
		r.newPatient("John", 3);
		r.newPatient("Erick", 5);
		r.newPatient("Jessica", 1);
		r.newPatient("Michael", 2);
		r.newPatient("Mona", 4);
		for (Patient p = r.nextPatient(); p != null; p = r.nextPatient())
			System.out.println(p.getName());
	}
}
