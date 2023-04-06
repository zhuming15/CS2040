import java.util.*;
import java.io.*;

class LostMap {
	PriorityQueue<Edge> edgeList = new PriorityQueue<Edge>();
	int numOfEdgesRequired;
	int numOfVillages;

	LostMap(int numOfVillages) {
		this.numOfVillages = numOfVillages;
		this.numOfEdgesRequired = numOfVillages - 1;
	}

	void readInput(BufferedReader br) throws IOException {
		for (int i = 1; i <= numOfVillages; i++) {
			String[] strArr = br.readLine().split(" ");
			for (int j = i; j < numOfVillages; j++) {
				edgeList.add(new Edge(i, j+1, Integer.parseInt(strArr[j])));
			}
		}
		System.out.println(edgeList.toString());
	}

	void KruskalMST(PrintWriter pw) {
		UFDS set = new UFDS(numOfVillages);
		while (numOfEdgesRequired != 0) {
			Edge currEdge = edgeList.poll();
			int source = currEdge.getSource();
			int dest   = currEdge.getDestination();
			if (set.canUnion(source, dest)) { 
				--numOfEdgesRequired;
				pw.print(source);
				pw.print(" ");
				pw.println(dest);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int numOfVillages = Integer.parseInt(br.readLine());
		LostMap test = new LostMap(numOfVillages);
		test.readInput(br);
		test.KruskalMST(pw);
		pw.flush();
		pw.close();
	}
}
