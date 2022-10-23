
public class Queue<E> {
    private Node<E> head;
    private Node<E> rear;
    private int size;

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
        this.rear = null;
    }

    public void offer(E element) {
        Node<E> newNode = new Node<E>(element);
        if (this.head == null) {
            this.head = newNode;
            this.rear = newNode;
        } else {
            Node<E> current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public E poll() {
        ensureNotEmpty();
        E element = this.head.element;
        if (this.size == 1) {
            this.head = null;
            this.rear = null;
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


}
