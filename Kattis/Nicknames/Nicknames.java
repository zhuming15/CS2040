import java.util.*;

class Nicknames {
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		AVL nameTree = new AVL();
		int A = io.getInt();
		while (A-- > 0) { nameTree.insert(io.getWord()); }

		int B = io.getInt();
		while (B-- > 0) {
			String nickname = io.getWord();
			io.println(nameTree.countMatches(nickname));
		}
		io.flush();
		io.close();
	}
}
