import java.io.*;

public class SumKindOfProblem {
	public static int computeAP(int n, int a, int d) {
		int res = (2 * a) + (n - 1) * d;
		res = (n * res) / 2;
		return res;
	}

	public static void main(String[] args) throws IOException {
		Kattio io = new Kattio(System.in, System.out);
		int numOfInput = io.getInt();
		
		for (int nthInput = 0; nthInput < numOfInput; nthInput++) {
			io.print(io.getInt());
			int N = io.getInt();
			
			int s1 = SumKindOfProblem.computeAP(N, 1, 1);
			int s2 = N * N;
			int s3 = s2 + N;
			io.print(" ");
			io.print(s1);
			io.print(" ");
			io.print(s2);
			io.print(" ");
			io.println(s3);
		}
		io.close();
	}
}
