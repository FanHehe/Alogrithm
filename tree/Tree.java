import java.util.LinkedList;

interface Tree<K extends Comparable<K>, T> {

    void insert(Node<K, T> node);

    default void levelTraversal(Node<K, T> node) {
        LinkedList<Node<K, T>> queue = new LinkedList<>();

        while (node != null) {

            visitNode(node);
            if (node.l != null) queue.offer(node.l);
            if (node.r != null) queue.offer(node.r);
            node = queue.poll();
        }
    }

    default void prevTraversal(Node<K, T> node) {
        LinkedList<Node<K, T>> stack = new LinkedList<>();

        while(node != null || !stack.isEmpty()) {
            if (node == null) {
                node = stack.poll();
            }

            visitNode(node);
            if (node.r != null) stack.push(node.r);
            node = node.l;
        }
    }

    default void prevTraversalRecursion(Node<K,T> node) {
        if (node != null) {
            visitNode(node);
            prevTraversalRecursion(node.l);
            prevTraversalRecursion(node.r);
        }
    }

    default void midTraversal(Node<K, T> node) {
        LinkedList<Node<K, T>> stack = new LinkedList<>();

        while(node != null || !stack.isEmpty()) {

            if (node != null) {
                stack.push(node);
                node = node.l;
            } else {
                node = stack.poll();
                visitNode(node);
                node = node.r;
            }
        }
    }

    default void midTraversalRecursion(Node<K, T> node) {
        if (node != null) {
            midTraversalRecursion(node.l);
            visitNode(node);
            midTraversalRecursion(node.r);
        }
    }

    default void tailTraversal(Node<K, T> node) {
        Node<K, T> last = null;
        LinkedList<Node<K, T>> stack = new LinkedList<>();

        while(node != null || !stack.isEmpty()) {

            while (node != null) {
                stack.push(node);
                node = node.l;
            }

            node = stack.peek();

            if (node.r == null || node.r == last) {
                visitNode(node);
                last = node;
                stack.poll();
                node = null;
            } else {
                node = node.r;
            }
        }
    }

    default void tailTraversalRecursion(Node<K,T> node) {
        if (node != null) {
            tailTraversalRecursion(node.l);
            tailTraversalRecursion(node.r);
            visitNode(node);
        }
    }

    default void visitNode(Node<K, T> node) {
        System.out.print(node.key.toString() + " ");
    }
}
