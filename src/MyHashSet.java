import java.util.NoSuchElementException;

public class MyHashSet<T> {

    private static final Integer INITIAL_CAPACITY = 1 << 4; // 16

    private Node<T>[] buckets;

    private int size;

    public MyHashSet(final int capacity) {
        this.buckets = new Node[capacity];
        this.size = 0;
    }

    public MyHashSet() {
        this(INITIAL_CAPACITY);
    }

    public void add(T t) {
        int index = hashCode(t) % buckets.length;

        Node bucket = buckets[index];

        Node<T> newNode = new Node<>(t);

        if (bucket == null) {
            buckets[index] = newNode;
            size++;
            return;
        }

        while (bucket.next != null) {
            if (bucket.data.equals(t)) {
                return;
            }
            bucket = bucket.next;
        }

        
        if (!bucket.data.equals(t)) {
            bucket.next = newNode;
            size++;
        }
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("[");
        for (Node node: buckets) {
            while (node != null) {
                sb.append(node);
                node = node.next;
            }
        }
        sb.append("]");
        return sb.toString();
    }



    private int hashCode(T t) {
        return t == null ? 0 : t.hashCode();
    }


    public T remove(T t) {
        int index = hashCode(t) % buckets.length;

        Node bucket = buckets[index];

        if (bucket == null) {
            throw new NoSuchElementException ("елементы где? нет их.");
        }

        if (bucket.data.equals(t)) {
            buckets[index] = bucket.next;
            size--;
            return t;
        }

        Node prev = bucket;

        while (bucket != null) {
            if (bucket.data.equals(t)) {
                prev.next = bucket.next;
                size--;
                return t;
            }
            prev = bucket;
            bucket = bucket.next;
        }
        return null;
    }


}
