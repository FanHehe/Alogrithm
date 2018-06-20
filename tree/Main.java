import java.util.ArrayList;


public class Main {

	public static BinaryNode getTree () {

		BinaryNode A = new BinaryNode("A");
		BinaryNode B = new BinaryNode("B");
		BinaryNode C = new BinaryNode("C");
		BinaryNode D = new BinaryNode("D");
		BinaryNode E = new BinaryNode("E");
		BinaryNode F = new BinaryNode("F");
		BinaryNode G = new BinaryNode("G");

		A.setLeft(D);
		A.setRight(G);
		D.setLeft(F);
		D.setRight(B);
		G.setLeft(C);
		G.setRight(E);

		return A;

	}

	// public static BinaryNode buildTreePrevMid (String prev, String mid) {}

	// public static BinaryNode buildTreeMidTail (String mid, String tail) {}

	// public static BinaryNode buildTreePrevTail (String prev, String tail) {}

	public static void levelTraversal (Node tree) {

		if (tree == null) return ;

		BinaryNode temp;

		ArrayList<Node> list = new ArrayList<Node>();

		list.add(tree);

		while (!list.isEmpty()) {

			temp = (BinaryNode)list.remove(0);

			if (temp.getLeft() != null) list.add(temp.getLeft());
			if (temp.getRight() != null) list.add(temp.getRight());

			System.out.print(temp.getData());
		}
	}

	public static void prevTraversal (Node tree) {}

	public static void midTravelsal  (Node tree) {}

	public static void tailTravelsal (Node tree) {}

	public static void main (String[] args) {
		BinaryNode tree = Main.getTree();
		Main.levelTraversal(tree);
	}
}