
public class Queue<E> {
    private Node<E> head;
    private int size;

    public int size() {
        return this.size;
    }

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e) {
            this.element = e;
        }
    }

    public Queue() {
        this.size = 0;
        this.head = null;
    }

    public void offer(E element) {
        Node<E> newNode = new Node<E>(element);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node<E> current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        this.size++;
    }

    public E poll() {
        ensureNotEmpty();
        E element = this.head.element;
        if (this.size == 1) {
            this.head = null;
        } else {
            Node<E> next = this.head.next;
            this.head.next = null;
            this.head = next;
        }
        this.size--;
        return element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureNotEmpty() {
        if (this.size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
    }

    private E getFirst() {
        return peek();
    }

    private E peek() {
        ensureNotEmpty();
        return this.head.element;
    }


}
