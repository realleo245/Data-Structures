package SimpleList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

public class SimpleList_additional_tests {
    @Test
    public void containsTest() {
        SimpleList list = new SimpleList();
        list.add("x");
        list.add("y");
        list.add("z");
        assertTrue(list.contains("x"));
        assertTrue(list.contains("y"));
        assertTrue(list.contains("z"));
        assertFalse(list.contains("a"));
        assertFalse(list.contains("b"));
        assertFalse(list.contains("c"));
    }
    @Test
    public void toArrayTest() {
        SimpleList list = new SimpleList();
        list.add("x");
        list.add("y");
        list.add("z");
        assertArrayEquals(new Object[]{"x", "y", "z"}, list.toArray());
        assertArrayEquals(new Object[]{"x", "y", "z"}, list.toArray(new Object[3]));
        assertArrayEquals(new Object[]{"x"}, list.toArray(new Object[1]));
        assertArrayEquals(new Object[]{"x", "y", "z", null, null}, list.toArray(new Object[5]));
    }
    @Test
    public void removeTest() {
        SimpleList list = new SimpleList();
        list.add("x");
        list.add("y");
        list.add("z");
        assertTrue(list.remove("y"));
        assertEquals(2, list.size());
        assertEquals("x", list.get(0));
        assertEquals("z", list.get(1));
        assertFalse(list.remove("a"));
    }
    @Test
    public void containsAllTest() {
        Collection<String> c = new ArrayList<>();
        c.add("x");
        c.add("y");
        c.add("z");
        SimpleList list = new SimpleList();
        assertFalse(list.containsAll(c));
        list.add("x");
        list.add("y");
        list.add("z");
        assertTrue(list.containsAll(c));
    }
}
