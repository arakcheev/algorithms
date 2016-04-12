package queues;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private List<Item> list;

    public RandomizedQueue() {
        list = new ArrayList<Item>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new java.lang.NullPointerException();
        }
        list.add(item);
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        int index = StdRandom.uniform(size());
        return (Item) list.remove(index);
    }

    public Item sample() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        int index = StdRandom.uniform(size());
        return (Item) list.get(index);
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        public boolean hasNext() {
            return size() > 0;
        }

        public Item next() {
            if (isEmpty()) {
                throw new java.util.NoSuchElementException();
            }
            return dequeue();
        }

        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }
}
