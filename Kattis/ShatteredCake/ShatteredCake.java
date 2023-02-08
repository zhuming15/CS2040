import java.io.*;

public class ShatteredCake {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int WIDTH = Integer.parseInt(br.readLine());
		int numOfCakes = Integer.parseInt(br.readLine());
		int totalArea = 0;

		while (numOfCakes-- > 0) {
			String[] strarr = br.readLine().split(" ");
			int width = Integer.parseInt(strarr[0]);
			int length = Integer.parseInt(strarr[1]);
			totalArea += width * length;
		}
		System.out.println(totalArea / WIDTH);
	}
}
