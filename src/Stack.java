import java.util.EmptyStackException;
//import java.util.Iterator;

public class Stack<E> {
    private Node<E> top;
    private int size;

    public boolean clear() {
        while(!this.isEmpty()) {
            this.pop();         //could be bloody slow but meh...
        }
        return this.isEmpty();
    }

    private static class Node<E> {
        private E element;
        private Node<E> previous;

        public Node(E e) {
            this.element = e;
        }
    }

    public Stack() {
        this.size = 0;
        this.top = null;
    }

    public void push(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.previous = top;
        top = newNode;
        this.size++;
    }

    public E pop() {
        ensureNonEmpty();
        E element = this.top.element;
        Node<E> temp = this.top.previous;
        this.top.previous = null;
        this.top = temp;
        this.size--;
        return element;
    }

    public void ensureNonEmpty() {
        if (this.size == 0) {
            throw new EmptyStackException();
        }
    }

    public E peek() {
        ensureNonEmpty();
        return this.top.element;
    }

//    public Iterator<E> iterator() {
//        return new Iterator<E>() {
//            private Node<E> current = top;
//
//            @Override
//            public boolean hasNext() {
//                return current != null;
//            }
//
//            @Override
//            public E next() {
//                E element = current.element;
//                this.current = this.current.previous;
//                return element;
//            }
//        };
//    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

}
