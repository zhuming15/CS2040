import java.util.*;

class AVL {
	public Vertex root;

	public AVL() {
		this.root = null;
	}

	public void insert(String name) { root = insert(root, name); }

	private Vertex insert(Vertex v, String name) {
		if (v == null) { 
			v = Vertex.of(name); 
		} else if (name.compareTo(v.key) > 0) {
			v.right = insert(v.right, name);
			v.right.parent = v;
		} else {
			v.left = insert(v.left, name);
			v.left.parent = v;
		}
		v.updateSize();
		v.updateHeight();
		return rotateTree(v);
	}

	public String search(String name) {
		Vertex res = search(root, name);
		return res == null ? "" : res.key;
	}

	private Vertex search(Vertex v, String name) {
		if (v == null) { return null; }
		if (v.key.indexOf(name) == 0) { return v; }
		else if (name.compareTo(v.key) > 0)  { return search(v.right, name); }
		else { return search(v.left, name); }
	}

	public int countMatches(String nickname) {
		Vertex v = search(root, nickname);
		if (v == null) { return 0; }
		else { return 1 + countLeftMatches(v.left, nickname) + countRightMatches(v.right, nickname); }
	}

	private int countRightMatches(Vertex vr, String nickname) {
		if (vr == null) { return 0; }
		if (vr.key.indexOf(nickname) == 0) { return 1 + vr.getSize(vr.left) + countRightMatches(vr.right, nickname); }
		else { return countRightMatches(vr.left, nickname); }
	}

	private int countLeftMatches(Vertex vl, String nickname) {
		if (vl == null) { return 0; }
		if (vl.key.indexOf(nickname) == 0) {  
			return 1 + vl.getSize(vl.right) + countLeftMatches(vl.left, nickname); }
		else { return countLeftMatches(vl.right, nickname); }
	}

	public int balanceFactorOf(Vertex v) { return (v == null) ? 0 : (v.getBalanceFactor()); }

	public Vertex rotateTree(Vertex v) {
		int bfValue = balanceFactorOf(v);
		if (bfValue == 2) {
			int bfValueLeft = balanceFactorOf(v.left);
			if (bfValueLeft == -1) { v.left = leftRotate(v.left); }
			v = rightRotate(v);
		} else if (bfValue == -2) {
			int bfValueRight = balanceFactorOf(v.right);
			if (bfValueRight == 1) { v.right = rightRotate(v.right); }
			v = leftRotate(v);
		}
		return v;
	}

	private Vertex leftRotate(Vertex v) {
		Vertex r = v.right;
		r.parent = v.parent;
		v.parent = r;
		v.right = r.left;
		if (r.left != null) { r.left.parent = v; }
		r.left = v;

		v.updateHeight();
		v.updateSize();
		r.updateHeight();
		r.updateSize();
		return r;
	}

	private Vertex rightRotate(Vertex v) {
		Vertex l = v.left;
		l.parent = v.parent;
		v.parent = l;
		v.left = l.right;
		if (l.right != null) { l.right.parent = v; }
		l.right = v;

		v.updateHeight();
		v.updateSize();
		l.updateHeight();
		l.updateSize();
		return l;
	}
}

