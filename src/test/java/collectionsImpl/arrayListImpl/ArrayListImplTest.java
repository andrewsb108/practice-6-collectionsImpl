package collectionsImpl.arrayListImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListImplTest {
    private ArrayListImpl<String> arrayList;

    @BeforeEach
    public void setUp() {
        arrayList = new ArrayListImpl<>();
    }

    @Test
    public void shouldAddElementsAndShowSize() {
        arrayList.add("java");
        arrayList.add("python");
        arrayList.add("swift");

        assertEquals("[java, python, swift]", arrayList.toString());
        assertEquals(3, arrayList.size());
    }

    @Test
    public void shouldThrowAnException_whenAddElementsByIndex() {
        arrayList.add("java");
        arrayList.add("python");

        assertThrows(UnsupportedOperationException.class,
                () -> arrayList.addByIndex(0, "swift"));
    }

    @Test
    public void shouldAddThreeElementsUsingNotEqualCase() {
        arrayList.add("java");
        arrayList.add("python");
        arrayList.add("swift");

        assertNotEquals(0, arrayList.size());
    }

    @Test
    public void shouldAddNull() {
        arrayList.add(null);

        assertEquals("[null]", arrayList.toString());
    }

    @Test
    public void shouldCheckIfElementDoesNotExist() {
        arrayList.add("java");
        arrayList.add("python");
        arrayList.add("swift");

        assertEquals(-1, arrayList.indexOf("scala"));
    }

    @Test
    public void shouldCheckIfElementIsPresent_whenUseIndexOf() {
        arrayList.add("java");
        arrayList.add("python");
        arrayList.add("swift");

        assertEquals(0, arrayList.indexOf("java"));
        assertEquals(1, arrayList.indexOf("python"));
        assertEquals(2, arrayList.indexOf("swift"));
        assertNotEquals(0, arrayList.indexOf("scala"));
    }

    @Test
    public void shouldThrowAnException_whenRemoveFirstElement() {
        arrayList.add("java");
        arrayList.add("python");

        assertThrows(UnsupportedOperationException.class,
                () -> arrayList.remove(0));
    }

    @Test
    public void shouldThrowAnException_whenRemoveElement_inCommonCase() {
        arrayList.add("java");
        arrayList.add("python");

        assertThrows(UnsupportedOperationException.class,
                () -> arrayList.remove(1));
    }

    @Test
    public void shouldThrowAnExceptionsIfIndexDoesNotExist_whenUseRemove() {
        arrayList.add("java");
        arrayList.add("python");
        arrayList.add("swift");

        assertThrows(IndexOutOfBoundsException.class,
                () -> arrayList.remove(5));
    }

    @Test
    public void shouldThrowAnException_whenUseSet() {
        arrayList.add("java");
        arrayList.add("python");

        assertThrows(UnsupportedOperationException.class,
                () -> arrayList.set(1, "swift"));
    }

    @Test
    public void shouldThrowAnExceptions_whenIndexDoesNotExist() {
        arrayList.add("java");
        arrayList.add("python");

        assertThrows(IndexOutOfBoundsException.class,
                () -> arrayList.set(5, "scala"));
    }

    @Test
    public void shouldGetOneOfElements() {
        String textElement = "test text";
        arrayList.add(textElement);
        arrayList.add("another text");
        arrayList.add("another");

        assertEquals("another text", arrayList.get(1));
    }

    @Test
    public void shouldGetSingleElement() {
        String textElement = "test text";
        arrayList.add(textElement);
        assertEquals(textElement, arrayList.get(0));
    }

    @Test
    public void shouldThrowAnExceptionsIfIndexDoesNotExist_whenUseSet() {
        arrayList.add("java");
        arrayList.add("python");

        assertThrows(IndexOutOfBoundsException.class,
                () -> arrayList.set(3, "scala"));
    }

    @Test
    public void shouldShowThatAnyElementsDoesNotExist() {
        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void shouldShowThatElementsExist() {
        arrayList.add("java");
        arrayList.add("python");

        assertFalse(arrayList.isEmpty());
    }

    @Test
    public void shouldAddAndShowFirstElementOfArray() {
        arrayList.add("java");
        arrayList.add("python");
        arrayList.add("swift");

        assertEquals("java", arrayList.getFirst());
        assertNotEquals("python", arrayList.getFirst());
    }

    @Test
    public void shouldThrowAnExceptionsIfIndexDoesNotExist_whenUseGetFirst() {
        assertThrows(NoSuchElementException.class,
                () -> arrayList.getFirst());
    }

    @Test
    public void shouldShowLastElementOfArray() {
        arrayList.add("java");
        arrayList.add("python");
        arrayList.add("swift");

        assertEquals("swift", arrayList.getLast());
        assertNotEquals("python", arrayList.getLast());
    }

    @Test
    public void shouldThrowAnExceptionsIfIndexDoesNotExist_whenUseGetLast() {
        assertThrows(NoSuchElementException.class,
                () -> arrayList.getLast());
    }


    @Test
    public void shouldShowEmptyArray() {
        assertEquals(0, arrayList.size());
    }

    @Test
    public void shouldThrowAnException_whenClearAnArray() {
        arrayList.add("java");
        arrayList.add("python");
        assertThrows(UnsupportedOperationException.class,
                () -> arrayList.clear());
    }


    @Test
    public void shouldShowAllElementsOfArray() {
        arrayList.add("java");
        arrayList.add("python");
        arrayList.add("swift");
        assertEquals("[java, python, swift]", arrayList.toString());
    }

    @Test
    public void shouldShowEmptyArray_whenUse_toString() {
        assertEquals("[]", arrayList.toString());
    }

    @Test
    public void shouldIncreaseArrayIfNeed_useIncreaseArrayIfNeed() {
        ArrayListImpl<String> arrayList = new ArrayListImpl<>(2);
        arrayList.add("java");
        arrayList.add("python");
        arrayList.add("swift");

        assertEquals(3, arrayList.size());
    }

    @Test
    public void shouldRemoveMiddleElement_withIteratorRemove() {
        ArrayListImpl<String> arrayList = new ArrayListImpl<>(3);
        arrayList.add("java");
        arrayList.add("python");
        arrayList.add("swift");

        Iterator<Object> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }

        assertEquals("[java, python, swift]", arrayList.toString());
        assertEquals(3, arrayList.size());
    }

    @Test
    public void shouldThrowAnException_whenRemoveWithIterator() {
        ArrayListImpl<String> arrayList = new ArrayListImpl<>(1);
        arrayList.add("java");
        arrayList.add("python");

        Iterator<Object> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }

        assertThrows(UnsupportedOperationException.class,
                iterator::remove);
    }
}
