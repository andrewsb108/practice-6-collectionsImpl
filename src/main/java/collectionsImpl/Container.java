package collectionsImpl;

import java.util.Iterator;

public interface Container extends Iterable<Object>{
    int size();

    void clear();

    String toString();

    Iterator<Object> iterator();
}
