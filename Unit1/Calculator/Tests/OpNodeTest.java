package Calculator.Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import Calculator.NumNode;
import Calculator.OpNode;
import Calculator.OpNode.OpCode;

public class OpNodeTest {
    @Test
    public void constructorTest() {
        String[] operators = {"+", "-", "*", "/", "%", "^"};
        OpCode[] opCodes =  {OpCode.ADDITION, OpCode.SUBTRACTION, OpCode.MULTIPLICATION, OpCode.DIVISION, OpCode.MODULO, OpCode.POWER};
        for(int i = 0; i < operators.length; i++) {
            OpNode node = new OpNode(operators[i]);
            assertEquals(opCodes[i], node.getOpCode());
        } 
        try {
            OpNode badNode = new OpNode("ewpi");
            fail();
        }
        catch(IllegalArgumentException e) {
            assertEquals("Unable to parse operator: " + "ewpi", e.getMessage());
        }
    }
    @Test
    public void evaluateTest() {
        NumNode list = new NumNode(2);
        list.setNext(new OpNode("+")).setNext(new NumNode(2));
        assertEquals(4, ((OpNode) list.getNext()).evaluate().getNumValue());
        list.setNext(new OpNode("-")).setNext(new NumNode(2));
        assertEquals(0, ((OpNode) list.getNext()).evaluate().getNumValue());
        list.setNext(new OpNode("*")).setNext(new NumNode(2));
        assertEquals(4, ((OpNode) list.getNext()).evaluate().getNumValue());
        list.setNext(new OpNode("/")).setNext(new NumNode(2));
        assertEquals(1, ((OpNode) list.getNext()).evaluate().getNumValue());
        list.setNext(new OpNode("%")).setNext(new NumNode(2));
        assertEquals(0, ((OpNode) list.getNext()).evaluate().getNumValue());
        list.setNext(new OpNode("^")).setNext(new NumNode(2));
        assertEquals(4, ((OpNode) list.getNext()).evaluate().getNumValue());
        assertThrows(RuntimeException.class, () -> {
            list.setNext(new OpNode("$")).setNext(new NumNode(2));
        });
    }
}
