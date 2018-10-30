import java.util.LinkedList;

interface Tree<K extends Comparable<K>, T> {

    void insert(Node<K, T> root);

    default void levelTraversal(Node<K, T> root) {
        LinkedList<Node<K, T>> queue = new LinkedList<>();

        while (root != null) {

            visitNode(root);
            if (root.l != null) queue.offer(root.l);
            if (root.r != null) queue.offer(root.r);
            root = queue.pop();
        }
    }

    default void prevTraversal(Node<K, T> root) {}
    default void prevTraversalRecursion(Node<K,T> root) {
        if (root != null) {
            visitNode(root);
            prevTraversalRecursion(root.l);
            prevTraversalRecursion(root.r);
        }
    }

    default void midTraversal(Node<K, T> root) {}
    default void midTraversalRecursion(Node<K, T> root) {
        if (root != null) {
            midTraversalRecursion(root.l);
            visitNode(root);
            midTraversalRecursion(root.r);
        }
    }

    default void tailTraversal(Node<K,T> root) {}
    default void tailTraversalRecursion(Node<K,T> root) {
        if (root != null) {
            tailTraversalRecursion(root.l);
            tailTraversalRecursion(root.r);
            visitNode(root);
        }
    }

    default void visitNode(Node<K, T> root) {
        System.out.print(root.key.toString() + " ");
    }
}
