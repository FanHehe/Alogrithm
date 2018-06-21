import java.util.ArrayList;

public class Traversal {

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

}