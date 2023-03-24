import java.util.*;

class Set {
	public int[] root;
	public int[] cont;
	public int[] sum;
	public int N;

	Set(int N) {
		int temp = 2*N + 1;
		this.root = new int[temp];
		this.cont = new int [temp];
		this.sum = new int[temp];
		this.N = N;
		int j = N;
		for (int i = 1; i <= N; i++) {
			++j;
			root[i] = j;
			root[j] = j;
			cont[j] = 1;
			sum[j] = i;
		}
	}

	int findSet(int i) {
		if (root[i] == i) { return root[i]; }
		else {
			root[i] = findSet(root[i]);
			return root[i];
		}
	}

	void unionSet(int p, int q) {
		System.out.println("unionSet(" + p + ", " + q + ")");
		int x = findSet(p);
		int y = findSet(q);
		System.out.println("x = " + x + ", y = " + y);
		if (x != y) {
			cont[y] += cont[x];
			sum[y] += sum[x];
			root[x] = y;
		}
	}

	void move(int p, int q) {
		System.out.println("move(" + p + ", " + q + ")");
		int x = findSet(p);
		int y = findSet(q);
		System.out.println("x = " + x + ", y = " + y);
		if (x != y) {
			cont[x]--;
			cont[y]++;
			sum[x] -= p;
			sum[y] += p;
			root[p] = y;
		}
	}

	void printOutput(int p, Kattio io) {
		System.out.println("print(" + p + ")");
		int x = findSet(p);
		System.out.println("x = " + x);
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
		System.out.println("----------------------------------------");
		return "";
	}
}	
