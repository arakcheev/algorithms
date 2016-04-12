package queues;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Subset {

    private static class RandomizedQueue<Item> implements Iterable<Item> {

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

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> queue = new RandomizedQueue<String>();
        while (StdIn.hasNextLine() && !StdIn.isEmpty()) {
            queue.enqueue(StdIn.readString());
        }
        for (int i = 0; i < k; i++) {
            StdOut.println(queue.iterator().next());
        }
    }

}
