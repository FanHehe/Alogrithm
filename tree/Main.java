public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();

        tree.insert(1);
        tree.insert(2);
        tree.insert(8);
        tree.insert(4);
        tree.remove(2);
        tree.insert(7);
        tree.insert(3);
        tree.insert(6);
        tree.remove(7);
        tree.insert(9);
        tree.insert(5);
        tree.insert(-1);
        tree.remove(1);

        tree.prevTraversalRecursion(tree.root);
        System.out.println("");
        tree.midTraversalRecursion(tree.root);
        System.out.println("");
        tree.tailTraversalRecursion(tree.root);
    }
}
