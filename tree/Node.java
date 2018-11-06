public class Node<K extends Comparable<K>, T> {

    public K key;
    public T data;
    public int h;
    public Node<K, T> p;
    public Node<K, T> l;
    public Node<K, T> r;

    public boolean color = RED;

    public static final boolean RED = true;
    public static final boolean BLACK = false;

    public Node() {

    }

    public Node(K key) {
        this.key = key;
    }

    public Node(K key, T data) {
        this.key = key;
        this.data = data;
    }
}
