import java.util.HashMap;
import java.io.*;

class T9Spelling {
	private static HashMap<Character, String> T9Table;
	private static final String outputTitle = "Case #%d : ";

	T9Spelling() {
		HashMap<Character, String> hm = new HashMap<Character, String>();
		hm.put(' ', "0");
		hm.put('a', "2");
		hm.put('b', "22");
		hm.put('c', "222");
		hm.put('d', "3");
		hm.put('e', "33");
		hm.put('f', "333");
		hm.put('g', "4");
		hm.put('h', "44");
		hm.put('i', "444");
		hm.put('j', "5");
		hm.put('k', "55");
		hm.put('l', "555");
		hm.put('m', "6");
		hm.put('n', "66");
		hm.put('o', "666");
		hm.put('p', "7");
		hm.put('q', "77");
		hm.put('r', "777");
		hm.put('s', "7777");
		hm.put('t', "8");
		hm.put('u', "88");
		hm.put('v', "888");
		hm.put('w', "9");
		hm.put('x', "99");
		hm.put('y', "999");
		hm.put('z', "9999");
		
		this.T9Table = hm;
	}

	private static StringBuilder convert(String word) {
		StringBuilder result = new StringBuilder();

		for (int index = 0; index < word.length(); index++) {
			char currChar = word.charAt(index);
			String charT9Value = T9Spelling.T9Table.get(currChar);

			if (result.length() != 0 && (charT9Value.charAt(0) == result.charAt(result.length()-1)))
				result.append(" ");

			result.append(charT9Value);
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		//Initialize Class
		T9Spelling convertor = new T9Spelling();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		int numOfWords = Integer.parseInt(br.readLine());

		for (int counter = 1; counter <= numOfWords; counter++) {
			String currWord = br.readLine();
			StringBuilder result = new StringBuilder();
			result.append("Case #").append(counter).append(": ").append(convertor.convert(currWord));
			pw.println(result);
		}
		pw.flush();
		pw.close();
	}
}
