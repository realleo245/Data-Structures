package Calculator;

import java.util.ArrayList;

import Calculator.OpNode.OpCode;

public class NumCalc {
    private RawNode head;
    private ArrayList<String> trace;
    private static final OpCode[][] OPERATOR_ORDER = {{OpCode.POWER}, {OpCode.MULTIPLICATION, OpCode.DIVISION, OpCode.MODULO}, {OpCode.ADDITION, OpCode.SUBTRACTION}};
    public NumCalc() {
        this.head = null;
        this.trace = new ArrayList<>();
    }
    public String evaluate(String expression) {
        trace.clear();
        // builds an expression list
        buildExpressionList(expression);
        // return the result value
        return evaluateExpression().getRawContent();
    }
    public String toString() {
        String calcTrace = "";
        for(String expression : trace) {
            calcTrace += expression;
            calcTrace += "\n";
        }
        return calcTrace;
    }
    private void buildExpressionList(String expression) {
        String[] exp = expression.split(" ");
        try {
            head = new NumNode(exp[0]);
        }
        catch(NumberFormatException e) {
            try {
                head = new OpNode(exp[0]);
            }
            catch(IllegalArgumentException ex) {
                throw new IllegalArgumentException("##Error: Unrecognized token " + exp[0]);
            }
        }
        RawNode cur = head;
        for(int i = 1; i < exp.length; i++) {
            try {
                cur.setNext(new NumNode(exp[i]));
            }
            catch(NumberFormatException e) {
                // cur.setNext(new OpNode(exp[i]));
                try {
                    cur.setNext(new OpNode(exp[i]));
                }
                catch(IllegalArgumentException ex) {
                    throw new IllegalArgumentException("##Error: Unrecognized token " + exp[i]);
                }
            }
            cur = cur.getNext();
        }
        head.setPrev(new RawNode("front"));
        head = head.getPrev();
        trace.add(convertExpressionList());
    }
    private RawNode evaluateExpression() {
        for(int i = 0; i < 3; i++) {
            RawNode cur = head.getNext();
            OpCode[] operators = OPERATOR_ORDER[i];
            // for(int j = 0; j < operators.length; j++) {
            //     while(cur != null) {
            //         if(cur instanceof OpNode) {
            //             if(((OpNode)cur).getOpCode() == operators[j]) {
            //                 NumNode result = ((OpNode)cur).evaluate();
            //                 result.setNext(cur.getNext().getNext());
            //                 if(head == cur.getPrev()) {
            //                     head = result;
            //                 }
            //             }
            //         }
            //         cur = cur.getNext();
            //     }
            // }
            // while(cur != null) {
            //     if(cur instanceof OpNode) {
            //         for(int j = 0; j < operators.length; j++) {
            //             if(((OpNode)cur).getOpCode() == operators[j]) {
            //                 NumNode result = ((OpNode)cur).evaluate();
            //                 result.setNext(cur.getNext().getNext());
            //                 result.next.prev = result;
            //                 // if(head == cur.getPrev()) {
            //                 //     head = result;
            //                 // }
            //                 cur = result;
            //             }
            //         }
            //     }
            //     cur = cur.getNext();
            // }
            while(cur != null) {
                if(cur instanceof OpNode) {
                    for(int j = 0; j < operators.length; j++) {
                        if(((OpNode) cur).getOpCode() == operators[j]) {
                            cur = ((OpNode)cur).evaluate();
                            // if(head == cur.getPrev()) {
                            //     head = cur;
                            // }
                            trace.add(convertExpressionList());
                            break;
                        }
                    }
                }
                cur = cur.getNext();
            }
        }
        return head.getNext();
    }
    private String convertExpressionList() {
        String expression = "";
        RawNode cur = head.getNext();
        expression += cur;
        expression += " ";
        while((cur instanceof NumNode || cur instanceof OpNode) &&  cur.getNext() != null && cur != null && cur.getRawContent() != null) {
            if(cur.getNext().getRawContent() == null) {
                expression += "";
            }
            else {
                expression += cur.getNext().toString();
            }
            expression += " ";
            cur = cur.getNext();
        }
        return expression;
    }
}
