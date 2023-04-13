import java.util.*;

class Point {
	public double x;
	public double y;

	Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	double distanceTo(Point other) {
		double dx = this.x - other.x;
		double dy = this.y - other.y;
		return Math.hypot(dx, dy);
	}

	@Override
	public String toString() {
		return String.format("(%f, %f)", x, y);
	}
}
