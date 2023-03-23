import java.util.*;

class Conformity {
	private HashMap<Course, Integer> table = new HashMap<Course, Integer>();
	private final int numOfStudents;
	private static Kattio io = new Kattio(System.in, System.out);

	Conformity(int n) {
		this.numOfStudents = n;
	}

	Course createCourse() {
		return new Course(io.getInt(), io.getInt(), io.getInt(), io.getInt(), io.getInt());
	}

	int computeHighestFrequency() {
		int highestFreq = 0;
		for (int ithStudents = 0; ithStudents < numOfStudents; ithStudents++) {
			Course course = createCourse();
			
			int key = table.containsKey(course) ? table.get(course) + 1 : 1;
			table.put(course, key);
			highestFreq = highestFreq < key ? key : highestFreq;
		}
		return highestFreq;
	}

	int computeNumOfStudentsTakingPopularCourse() {
		int highestFreq = computeHighestFrequency();
		int totalNumOfStudents = 0;
		for (Map.Entry<Course, Integer> entry : table.entrySet()) {
			int curr = entry.getValue();
			if (curr == highestFreq)
				totalNumOfStudents += highestFreq;
		}
		return totalNumOfStudents;
	}

	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		Conformity test = new Conformity(io.getInt());
		int output = test.computeNumOfStudentsTakingPopularCourse();
		io.println(output);
		io.close();
	}
}
