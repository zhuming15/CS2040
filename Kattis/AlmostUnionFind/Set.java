import java.util.*;

class Set {
	public int[] root;
	public int[] cont;
	public int[] sum;
	public int[] rank;

	Set(int N) {
		this.root = new int[N+1];
		this.cont = new int [N+1];
		this.sum = new int[N+1];
		for (int i = 0; i < N + 1; i++) {
			root[i] = i;
			cont[i] = 1;
			sum[i] = i;
		}
	}

	int findSet(int i) {
		if (root[i] == i) { return i; }
		else {
			root[i] = findSet(root[i]);
			return root[i];
		}
	}

	void unionSet(int p, int q) {
		int x = findSet(p);
		int y = findSet(q);
		if (x != y) {
			cont[y] += cont[x];
			sum[y] += sum[x];
			root[x] = y;
		}
		findSet(p);
		findSet(q);
	}

	void move(int p, int q) {
		int x = findSet(p);
		int y = findSet(q);
		if (x != y) {
			cont[x]--;
			cont[y]++;
			sum[x] -= p;
			sum[y] += p;
			root[p] = y;
		}
		findSet(p);
		findSet(q);
	}

	void printOutput(int p, Kattio io) {
		int x = findSet(p);
		io.print(cont[x]);
		io.print(" ");
		io.print(sum[x]);
		io.println("");
	}

	@Override
	public String toString() {
		System.out.println("root   : " + Arrays.toString(root));
		System.out.println("cont   : " + Arrays.toString(cont));
		System.out.println("sum    : " + Arrays.toString(sum));
		return "end";
	}
}	
