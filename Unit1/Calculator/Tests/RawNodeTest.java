package Calculator.Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Calculator.RawNode;

public class RawNodeTest {
    @Test
    public void constructorTest() {
        RawNode node = new RawNode("abcd");
        assertEquals("abcd", node.getRawContent());
        assertEquals(null, node.getPrev());
        assertEquals(null, node.getNext());
    }
    @Test
    public void setPrevTest() {
        RawNode node = new RawNode("abcd");
        RawNode oPrev = new RawNode("wxyz");
        node.setPrev(oPrev);
        RawNode prev = new RawNode("efgh");
        node.setPrev(prev);
        assertEquals("efgh", node.getPrev().getRawContent());
        assertEquals("abcd", prev.getNext().getRawContent());
        assertEquals("wxyz", prev.getPrev().getRawContent());
        assertThrows(NullPointerException.class, () -> {
            node.setPrev(null);
        });
    }
    @Test
    public void setNextTest() {
        RawNode node = new RawNode("abcd");
        RawNode next = new RawNode("efgh");
        node.setNext(next);
        assertEquals("efgh", node.getNext().getRawContent());
        assertEquals("abcd", next.getPrev().getRawContent());
        assertThrows(NullPointerException.class, () -> {
            node.setNext(null);
        });
    }
}