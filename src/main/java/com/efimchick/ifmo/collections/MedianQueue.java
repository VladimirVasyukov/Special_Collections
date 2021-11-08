package com.efimchick.ifmo.collections;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

class MedianQueue extends AbstractQueue<Integer> {
    private static final int PARITY_DETERMINANT = 2;
    private final LinkedList<Integer> list;

    public MedianQueue() {
        list = new LinkedList<>();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }

    @Override
    public boolean add(Integer integer) {
        return addElement(integer);
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        return list.addAll(c);
    }

    @Override
    public boolean offer(Integer integer) {
        return addElement(integer);
    }

    private boolean addElement(Integer value) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) >= value) {
                list.add(i, value);
                return true;
            }
        }
        return list.add(value);
    }

    @Override
    public Integer remove() {
        return list.remove();
    }

    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return list.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public Integer element() {
        return list.element();
    }

    @Override
    public Integer poll() {
        return list.remove(findMedianIndex());
    }

    @Override
    public Integer peek() {
        return list.get(findMedianIndex());
    }

    private int findMedianIndex() {
        return (list.size() - 1) / PARITY_DETERMINANT;
    }
}
