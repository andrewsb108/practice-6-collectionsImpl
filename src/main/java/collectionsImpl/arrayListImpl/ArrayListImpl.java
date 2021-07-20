package collectionsImpl.arrayListImpl;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayListImpl<T> implements ArrayListInterface<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] data;
    private int size;

    public ArrayListImpl(int initCapacity) {
        if (initCapacity <= 0) {
            throw new IllegalArgumentException();
        } else {
            data = new Object[initCapacity];
        }
    }

    public ArrayListImpl() {
        data = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void add(T element) {
        if (data.length == size) {
            increaseArrayIfNeed();
        }
        data[size] = element;
        size++;
    }

    private void increaseArrayIfNeed() {
        Object[] newData = new Object[data.length * 2];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    @Override
    public void addByIndex(int index, Object element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index is: " + index + "size is: " + size);
        } else {
            throw new UnsupportedOperationException("You can't change this ArrayList");
        }
    }

    @Override
    public int indexOf(Object element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index is: " + index);
        }
        throw new UnsupportedOperationException("You can't change this ArrayList");
    }

    @Override
    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.valueOf(index));
        } else {
            throw new UnsupportedOperationException("You can't change this ArrayList");
        }
    }

    @Override
    public T get(int index) {
        if (index >= 0 || index < size) {
            return (T) data[index];
        }
        throw new IndexOutOfBoundsException(String.valueOf(index));
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return get(0);
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return get(size - 1);
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("You can't change this ArrayList");
    }

    public String toString() {
        Iterator<Object> iterator = iterator();
        if (!iterator.hasNext()) {
            return "[]";
        } else {
            StringBuilder output = new StringBuilder("[");
            String splitter = ", ";
            String prefix = "";
            while (iterator.hasNext()) {
                output.append(prefix).append(iterator.next());
                prefix = splitter;
            }
            output.append("]");

            return output.toString();
        }
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImplementation();
    }

    private class IteratorImplementation implements Iterator<Object> {
        public int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public Object next() {
            return data[currentIndex++];
        }

        @Override
        public void remove() {
            if (currentIndex <= 0) {
                throw new IllegalStateException();
            }
            throw new UnsupportedOperationException("You can't change this ArrayList");
        }
    }
}
