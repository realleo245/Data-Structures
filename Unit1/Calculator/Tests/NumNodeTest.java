package Calculator.Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import Calculator.NumNode;

public class NumNodeTest {
    @Test
    public void constructorTest() {
        NumNode node = new NumNode("3.3333333333333");
        assertEquals(10.0/3.0, node.getNumValue(), 0.00001);

        NumberFormatException e = assertThrows(NumberFormatException.class, () -> {
            NumNode numNode = new NumNode("asdf");
        });
        assertEquals("For input string: \"asdf\"", e.getMessage());
    }
}
