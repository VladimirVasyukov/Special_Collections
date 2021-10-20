package com.efimchick.ifmo.collections;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class PairStringList extends AbstractList<String> {
    private final static int PARITY_DETERMINANT = 2;
    private final List<String> list;

    public PairStringList() {
        list = new ArrayList<>();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<String> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return (T[]) list.toArray();
    }

    @Override
    public void add(int index, String element) {
        if (index % PARITY_DETERMINANT == 0) {
            list.add(index, element);
            list.add(index, element);
        } else {
            list.add(index + 1, element);
            list.add(index + 1, element);
        }
    }

    @Override
    public boolean add(String s) {
        list.add(s);
        list.add(s);
        return true;
    }

    @Override
    public String remove(int index) {
        list.remove(index);
        list.remove(index - 1);
        return null;
    }

    @Override
    public boolean remove(Object o) {
        list.remove(o);
        list.remove(o);
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        List<String> str = new ArrayList<>(c);
        for (String s : str) {
            list.add(s);
            list.add(s);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        List<String> str = new ArrayList<>(c);
        Collections.reverse(str);
        for (String s : str) {
            if (index % PARITY_DETERMINANT == 0) {
                list.add(index, s);
                list.add(index, s);
            } else {
                list.add(index + 1, s);
                list.add(index + 1, s);
            }
        }
        return true;
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
    public String get(int index) {
        return list.get(index);
    }

    @Override
    public String set(int index, String element) {
        if (index % PARITY_DETERMINANT == 0) {
            list.set(index, element);
            list.set(index + 1, element);
        } else {
            list.set(index, element);
            list.set(index - 1, element);
        }
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return list.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return list.lastIndexOf(o);
    }

    @Override
    public ListIterator<String> listIterator() {
        return list.listIterator();
    }

    @Override
    public ListIterator<String> listIterator(int index) {
        return list.listIterator(index);
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        return list.subList(fromIndex, toIndex);
    }
}
