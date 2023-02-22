import java.io.*;
import java.util.*;
adfad:
public class JoinString {
	public static void main(String[] args) throws IOException {
		Kattio io = new Kattio(System.in, System.out);

		int numOfStrings = io.getInt();
		MyListNode[] wordList = new MyListNode[numOfStrings+2];

		for (int counter = 1; counter <= numOfStrings; counter++) {
			wordList[counter] = new MyListNode(io.getWord());
		}

		MyListNode head = wordList[1];
		for (int ithOperation = 1; ithOperation < numOfStrings; ithOperation++) {
			int a = io.getInt();
			int b = io.getInt();
			wordList[a].addBack(wordList[b]);
			head = wordList[a];
		}

		for (; head.next != null; head = head.next) {
			io.print(head.word);
		}
		io.print(head.word);
		io.println("");
		io.close();
	}
}
