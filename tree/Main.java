public class Main {

/*
	     	  A
	   		↙   ↘
	   	  D       G
	    ↙   ↘    ↙   ↘
	  F      B  C     E

	层次遍历顺序：ADGFBCE
	前序遍历顺序：ADFBGCE
	中序遍历顺序：FDBACGE
	后序遍历顺序：FBDCEGA
 */


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

	public static void main (String[] args) {
		BinaryNode tree = Main.getTree();
		Traversal.levelTraversal(tree);
	}
}