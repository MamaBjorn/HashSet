
class Node<T> {
    T data;
    Node next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "(" + this.data + ")";
    }
}
