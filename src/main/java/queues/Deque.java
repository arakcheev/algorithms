package queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<T> implements Iterable<T> {
    private Node first;
    private Node last;

    private int size;

    public Deque() {
        size = 0;
        first = last = null;
    }

    public void addFirst(T item) {
        if (item == null) throw new NullPointerException();
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        if (oldFirst != null) {
            oldFirst.prev = first;
        } else {
            last = first;
        }
        size++;
    }

    public void addLast(T item) {
        if (item == null) throw new NullPointerException();
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.prev = oldLast;
        if (!isEmpty()) {
            oldLast.next = last;
        } else {
            first = last;
        }
        size++;
    }

    public T removeFirst() {
        if(isEmpty()) throw new NoSuchElementException("Remove from empty Deque.");
        Node oldFirst = first;
        if(size() == 1){
            first = last = null;
        } else {
            first = first.next;
        }
        size--;
        return oldFirst.item;
    }

    public T removeLast(){
        if(isEmpty()) throw new NoSuchElementException("Remove from empty Deque.");
        Node oldLast = last;
        if(size == 1){
            first = last = null;
        } else {
            last = last.prev;
            last.next = null;
        }
        size--;
        return oldLast.item;
    }

    private class Node {
        T item;
        Node next;
        Node prev;

        public Node() {

        }

        public Node(T item, Node next, Node prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T> {
        private Node current = first;

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (T item : this)
            s.append(item).append(" ");
        return s.toString();
    }

    public static void main(String[] args) {
        Deque<Integer> dq = new Deque<>();

        dq.addFirst(1);
        dq.addFirst(2);
        dq.addFirst(3);

        dq.addLast(0);
        dq.addFirst(1);



        System.out.println(dq);


        System.out.println(dq.removeFirst());
        System.out.println(dq.removeFirst());
        System.out.println(dq.removeFirst());
        System.out.println(dq);
        System.out.println(dq.removeLast());
        System.out.println(dq);
    }
}
