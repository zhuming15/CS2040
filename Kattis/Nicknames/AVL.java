import java.util.*;

class AVL {
	public Vertex root;

	public AVL() {
		this.root = null;
	}

	public void insert(String name) { root = insert(root, name); }

	public Vertex insert(Vertex v, String name) {
		if (v == null) { 
			Vertex res = new Vertex(name);
			res.height++;
			return res;
		}
		int temp = name.compareTo(v.key);
		v.height++;
		if (temp > 0) {
			v.right = insert(v.right, name);
			v.right.parent = v;
		} else {
			v.left = insert(v.left, name);
			v.left.parent = v;
		}
		rotateTree(v);
		return v;
	}

	public String search(String name) {
		Vertex res = search(root, name);
		return res == null ? "" : res.key;
	}

	public Vertex search(Vertex v, String name) {
		if (v == null) { return null; }
		int temp = name.compareTo(v.key);
			 if (temp == 0) { return v; }
		else if (temp > 0)  { return search(v.right, name); }
		else 				{ return search(v.left, name); }
	}

	public int countMatches(String nickname) {
		return countMatches(root, nickname);
	}

	public int countMatches(Vertex v, String nickname) {
		if (v == null) { return 0; }
		int diff = nickname.compareTo(v.key.substring(0,nickname.length()));
			 if (diff > 0) { return countMatches(v.right, nickname); }
		else if (diff < 0) { return countMatches(v.left, nickname); }
		else               { return 1 + countMatches(v.left, nickname) + countMatches(v.right, nickname); }
	}

	public int balanceFactorOf(Vertex v) { 
		if (v == null) { return 0; }
		int left = v.left == null ? 0 : v.left.height;
		int right = v.right == null ? 0 : v.right.height;
		return left - right;
	}

	public void rotateTree(Vertex v) {
		int bfValue = balanceFactorOf(v);
		int bfValueLeft = balanceFactorOf(v.left);
		int bfValueRight = balanceFactorOf(v.right);
		if (bfValue == 2) {
			if (0 <= bfValueLeft && bfValueLeft <= 1) {
				rightRotate(v);
			} else if (bfValueLeft == -1) {
				leftRotate(v.left);
				rightRotate(v);
			}
		} else if (bfValue == -2) {
			if (-1 <= bfValueRight && bfValueRight <= 0) {
				leftRotate(v);
			} else if (bfValueRight == 1) {
				rightRotate(v.right);
				leftRotate(v);
			}
		}
	}

	private Vertex leftRotate(Vertex v) {
		Vertex w = v.right;
		w.parent = v.parent;
		v.parent = w;
		v.right = w.left;
		if (w.left != null) { w.left.parent = v; }
		w.left = v;
		return w;
	}

	private Vertex rightRotate(Vertex v) {
		Vertex w = v.left;
		w.parent = v.parent;
		v.parent = w;
		v.left = w.right;
		if (w.right != null) { w.right.parent = v; }
		w.right = v;
		return w;
	}
}

