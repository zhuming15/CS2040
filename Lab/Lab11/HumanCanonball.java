import java.util.*;

class HumanCanonball {
	static final int RUN_SPEED = 5;
	static final int LAUNCH_DIST = 50;
	static final int LAUNCH_DURATION = 2;
	Point initialPos = null;
	Point finalPos = null;
	Point[] cannonList = null;
	int numOfCannons = -1;
	int numOfPoints = -1;

	void readInitialPosition(double x, double y) { this.initialPos = new Point(x, y, 0, 0); }
	void readFinalPosition(double x, double y)   { this.finalPos   = new Point(x, y, 1); }

	void readNumOfCannons(int numOfCannons) { 
		this.numOfCannons = numOfCannons;
		this.numOfPoints = numOfCannons + 2;
	}

	void readCannonList(Kattio io) {
		this.cannonList = new Point[numOfPoints];
		cannonList[0] = initialPos;
		cannonList[1] = finalPos;
		for (int i = 2; i < numOfPoints; i++) {
			cannonList[i] = new Point(io.getDouble(), io.getDouble(), i);
		}
	}

	double RunOnlyTimeFor(double dist)       { return dist / RUN_SPEED; }
	double LaunchThenRunTimeFor(double dist) { return Math.abs(dist-LAUNCH_DIST)/RUN_SPEED + LAUNCH_DURATION; }

	double[][] generateDistanceMatrix() {
		double[][] mat = new double[numOfPoints][numOfPoints];

		mat[0][1] = RunOnlyTimeFor(initialPos.distanceTo(finalPos));
		mat[1][0] = mat[0][1];

		for (int i = 0; i < numOfCannons; i++) {
			double initialToCannonDist = initialPos.distanceTo(cannonList[i+2]);
			mat[0][i+2] = RunOnlyTimeFor(initialToCannonDist);
			mat[i+2][0] = LaunchThenRunTimeFor(initialToCannonDist);
		}

		for (int i = 0; i < numOfCannons; i++) {
			double finalToCannonDist = finalPos.distanceTo(cannonList[i+2]);
			mat[1][i+2] = RunOnlyTimeFor(finalToCannonDist);
			mat[i+2][1] = LaunchThenRunTimeFor(finalToCannonDist);
		}

		for (int i = 0; i < numOfCannons; i++) {
			for (int j = i+1; j < numOfCannons; j++) {
				double distBetweenCannons = cannonList[i+2].distanceTo(cannonList[j+2]);
				mat[i+2][j+2] = LaunchThenRunTimeFor(distBetweenCannons);
				mat[j+2][i+2] = mat[i+2][j+2];
			}
		}
		return mat;
	}

	double dijkstraShortestTime(double[][] distMatrix) {
		double[] time = new double[numOfPoints];
		Arrays.fill(time, Double.MAX_VALUE);
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		pq.add(cannonList[0]);
		while (!pq.isEmpty()) {
			Point cur = pq.poll();
			if (!cur.visited) {
				cur.visited = true;
				for (int i = 0; i < numOfPoints; i++) {
					if (!cannonList[i].visited && cur.time + distMatrix[cur.index][i] < time[i]) {
						time[i] = cur.time + distMatrix[cur.index][i];
						cannonList[i].time = time[i];
						pq.add(cannonList[i]);
					}
				}
			}
		}
		return time[1];
	}

	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		HumanCanonball test = new HumanCanonball();
		test.readInitialPosition(io.getDouble(), io.getDouble());
		test.readFinalPosition(io.getDouble(), io.getDouble());
		test.readNumOfCannons(io.getInt());
		test.readCannonList(io);
		double[][] distMatrix = test.generateDistanceMatrix();
		double shortestTime = test.dijkstraShortestTime(distMatrix);
		io.println(shortestTime);
		io.flush();
		io.close();
	}
}
