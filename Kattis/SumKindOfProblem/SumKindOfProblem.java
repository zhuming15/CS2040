import java.io.*;

public class SumKindOfProblem {
	public static long computeAP(int n, int a, int d) {
		long res = (2 * a) + (n - 1) * d;
		res = (n * res) / 2;
		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int numOfInput = Integer.parseInt(br.readLine());
		
		for (int nthInput = 0; nthInput < numOfInput; nthInput++) {
			String[] strarr = br.readLine().split(" ");
			int K = Integer.parseInt(strarr[0]);
			int N = Integer.parseInt(strarr[1]);
			
			long s1 = SumKindOfProblem.computeAP(N, 1, 1);
			long s2 = SumKindOfProblem.computeAP(N, 1, 2);
			long s3 = SumKindOfProblem.computeAP(N, 2, 2);
			pw.println(K + " " + s1 + " " + s2 + " " + s3);
		}
		pw.flush();
		pw.close();
	}
}
