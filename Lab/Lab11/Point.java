import java.util.*;

class Point implements Comparable<Point> {
	public double x;
	public double y;
	public int index;
	public double time;
	public boolean visited = false;

	Point(double x, double y, double time, int index) {
		this.x = x;
		this.y = y;
		this.time = time;
		this.index = index;
	}

	Point(double x, double y, int index) {
		this(x, y, Double.MAX_VALUE, index); 
	}

	double distanceTo(Point other) {
		double dx = this.x - other.x;
		double dy = this.y - other.y;
		return Math.hypot(dx, dy);
	}

	@Override
	public int compareTo(Point other) {
		if (this.time < other.time) { return -1; }
		else if (this.time > other.time) { return 1; }
		else { return 0; }
	}

	@Override
	public String toString() {
		return String.format("(%f, %f)", x, y);
	}
}
