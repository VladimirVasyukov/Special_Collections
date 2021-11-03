package com.efimchick.ifmo.collections;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class MedianQueue extends AbstractQueue<Integer> {
    private static final int PARITY_DETERMINANT = 2;
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
        return queue.toArray(a);
    }

    @Override
    public boolean add(Integer integer) {
        return queue.add(integer);
    }

    @Override
    public Integer remove() {
        Deque<Integer> stack = new LinkedList<>();
        while (!queue.isEmpty()) {
            stack.add(queue.peek());
            queue.remove();
        }
        while (!stack.isEmpty()) {
            queue.add(stack.peek());
            stack.pop();
        }
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
        reorderTestQueueWithMedianInHead();
        return queue.poll();
    }


    @Override
    public Integer element() {
        return queue.element();
    }

    @Override
    public Integer peek() {
        reorderTestQueueWithMedianInHead();
        return queue.peek();
    }

    public void reorderTestQueueWithMedianInHead() {
        List<Integer> sortedList = new ArrayList<>(queue);
        Collections.sort(sortedList);
        int medianIndex;
        while (!sortedList.isEmpty()) {
            if (sortedList.size() % PARITY_DETERMINANT == 0) {
                medianIndex = (sortedList.size() / PARITY_DETERMINANT) - 1;
            } else {
                medianIndex = sortedList.size() / PARITY_DETERMINANT;
            }
            queue.remove();
            queue.add(sortedList.get(medianIndex));
            sortedList.remove(medianIndex);
        }
    }
}
