package com.efimchick.ifmo.collections;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class MedianQueue extends AbstractQueue<Integer> {
    private final static int PARITY_DETERMINANT = 2;
    private final Queue<Integer> queue;

    public MedianQueue() {
        queue = new LinkedList<>();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return queue.iterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return (T[]) queue.toArray();
    }

    @Override
    public boolean add(Integer integer) {
        return queue.add(integer);
    }

    @Override
    public Integer remove() {
        return queue.remove();
    }

    @Override
    public boolean remove(Object o) {
        return queue.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return queue.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        return queue.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return queue.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return queue.retainAll(c);
    }

    @Override
    public void clear() {
        queue.clear();
    }

    @Override
    public boolean offer(Integer integer) {
        return queue.offer(integer);
    }

    @Override
    public Integer poll() {
        Queue<Integer> orderedQueue = new PriorityQueue<>(queue);
        List<Integer> listQueue = new ArrayList<>();
        while (!orderedQueue.isEmpty()) {
            listQueue.add(orderedQueue.poll());
        }
        List<Integer> medianStorage = new LinkedList<>();
        int medianIndex;
        while (!listQueue.isEmpty()) {
            if (listQueue.size() % PARITY_DETERMINANT == 0) {
                medianIndex = (listQueue.size() / PARITY_DETERMINANT) - 1;
            } else {
                medianIndex = listQueue.size() / PARITY_DETERMINANT;
            }
            medianStorage.add(listQueue.get(medianIndex));
            listQueue.remove(medianIndex);
        }
        queue.clear();
        queue.addAll(medianStorage);
        return queue.poll();
    }


    @Override
    public Integer element() {
        return queue.element();
    }

    @Override
    public Integer peek() {
        Queue<Integer> orderedQueue = new PriorityQueue<>(queue);
        List<Integer> listQueue = new ArrayList<>();
        while (!orderedQueue.isEmpty()) {
            listQueue.add(orderedQueue.poll());
        }
        List<Integer> medianStorage = new LinkedList<>();
        int medianIndex;
        while (!listQueue.isEmpty()) {
            if (listQueue.size() % PARITY_DETERMINANT == 0) {
                medianIndex = (listQueue.size() / PARITY_DETERMINANT) - 1;
            } else {
                medianIndex = listQueue.size() / PARITY_DETERMINANT;
            }
            medianStorage.add(listQueue.get(medianIndex));
            listQueue.remove(medianIndex);
        }
        queue.clear();
        queue.addAll(medianStorage);
        return queue.peek();
    }
}
