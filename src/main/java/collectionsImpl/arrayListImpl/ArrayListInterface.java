package collectionsImpl.arrayListImpl;

import collectionsImpl.Container;

public interface ArrayListInterface<T> extends Container {
    void add(T element);

    void addByIndex(int index, T element);

    int indexOf(Object e);

    T remove(int index);

    void set(int index, T element);

    boolean isEmpty();

    Object get(int index);

    T getFirst();

    T getLast();
}
