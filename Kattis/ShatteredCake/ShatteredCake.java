import java.io.*;

public class ShatteredCake {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		int WIDTH = Integer.parseInt(br.readLine());
		int numOfCakes = Integer.parseInt(br.readLine());
		int totalArea = 0;

		for (int nthCake = 0; nthCake < numOfCakes; nthCake++) {
			String[] strarr = br.readLine().split(" ");
			int width = Integer.parseInt(strarr[0]);
			int length = Integer.parseInt(strarr[1]);
			totalArea += width * length;
		}

		int LENGTH = totalArea / WIDTH;
		pw.println(LENGTH);
		pw.flush();
		pw.close();
	}
}
