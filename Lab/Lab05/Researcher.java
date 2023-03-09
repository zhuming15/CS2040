import java.util.*;

class Researcher {
	int arrivalTime;
	int workingTime;

	Researcher(int at, int wt) {
		this.arrivalTime = at;
		this.workingTime = wt;
	}

	int computeFinishTime() {
		return arrivalTime + workingTime;
	}
}
