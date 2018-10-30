public class BinarySearchTree<K extends Comparable<K>, T> implements Tree<K, T> {

    Node<K, T> root;

    public void insert(K key) {
        insert(new Node<K, T>(key));
    }

    public void insert(Node<K, T> node) {

        Node<K, T> curr = root;
        Node<K, T> parent = null;

        while(curr != null) {
            parent = curr;
            if (curr.key.compareTo(node.key) > 0) {
                curr = curr.l;
            } else if (curr.key.compareTo(node.key) < 0) {
                curr = curr.r;
            } else {
                return;
            }
        }

        if (parent == null) {
            root = node;
            return;
        }

        node.p = parent;

        if (parent.key.compareTo(node.key) > 0) {
            parent.l = node;
        } else {
            parent.r = node;
        }

        return;
    }

    public void remove(K key) {

        Node<K, T> node = root;

        while(node != null) {
            if (node.key.compareTo(key) > 0) {
                node = node.l;
            } else if (node.key.compareTo(key) < 0) {
                node = node.r;
            } else {
                break;
            }
        }

        if (node == null) {
            return;
        }

        if (node.l == null) {
            replaceNode(node, node.r);
        } else if (node.r == null) {
            replaceNode(node, node.l);
        } else {
            Node<K, T> y = findMinFromRight(node);

            if (y.p != node) {
                replaceNode(y, y.r);
                y.r = node.r;
                y.r.p = y;
            }

            replaceNode(node, y);
            y.l = node.l;
            y.l.p = y;
        }
    }

    protected Node<K, T> findMinFromRight(Node<K, T> node) {
        Node<K, T> min = node.r;

        while(min.l != null) {
            min = min.l;
        }

        return min;
    }

    protected void replaceNode(Node<K, T> target, Node<K, T> node) {

        if (target == root) {
            root = node;
        } else if (target == target.p.l) {
            target.p.l = node;
        } else {
            target.p.r = node;
        }

        if (node != null) {
            node.p = target;
        }
    }
}
