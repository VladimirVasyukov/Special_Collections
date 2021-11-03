package com.efimchick.ifmo.collections;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class PairStringList extends AbstractList<String> {
    private static final int PARITY_DETERMINANT = 2;
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
        return list.size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator<String> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
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
        if (index % PARITY_DETERMINANT == 0) {
            return list.remove(index) + list.remove(index + 1);
        } else {
            return list.remove(index) + list.remove(index - 1);
        }
    }

    @Override
    public boolean remove(Object o) {
        return list.remove(o) && list.remove(o);
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
        boolean modified = false;
        Collections.reverse((List<?>) c);
        for (String e : c) {
            add(index, e);
            modified = true;
        }
        return modified;
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
        String setElement = list.set(index, element);
        if (index % PARITY_DETERMINANT == 0) {
            return setElement + list.set(index + 1, element);
        } else {
            return setElement + list.set(index - 1, element);
        }
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
