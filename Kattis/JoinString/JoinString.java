import java.io.*;
import java.util.*;

public class JoinString {
	private final int numOfStrings;
	private MyListNode[] wordList;
	private static Kattio io = new Kattio(System.in, System.out);

	JoinString() {
		this.numOfStrings = io.getInt();
		this.wordList = new MyListNode[numOfStrings+2];
		for (int nthWord = 1; nthWord <= this.numOfStrings; nthWord++) {
			this.wordList[nthWord] = new MyListNode(io.getWord());
		}
	}

	MyListNode connectWords() {
		MyListNode startPoint = wordList[1];
		for (int ithOperation = 1; ithOperation < numOfStrings; ithOperation++) {
			int a = io.getInt();
			int b = io.getInt();
			wordList[a].addBack(wordList[b]);
			startPoint = wordList[a];
		}
		return startPoint;
	}

	void printSentence(MyListNode head) {
		for (; head.next != null; head = head.next) {
			io.print(head.word);
		}
		io.println(head.word);
	}
			

	public static void main(String[] args) throws IOException {
		JoinString test = new JoinString();
		MyListNode frontWord = test.connectWords();
		test.printSentence(frontWord);
		io.close();
	}
}
