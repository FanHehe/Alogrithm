public class Node<K extends Comparable<K>, T> {
    public K key;
    public T data;
    public Node<K, T> p;
    public Node<K, T> l;
    public Node<K, T> r;

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
