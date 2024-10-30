package Calculator;

public class OpNode extends RawNode {
    public enum OpCode {
        UNKNOWN, ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION, MODULO, POWER;
    }
    private OpCode opCode;
    public OpNode(String rawContent) {
        super(rawContent);
        switch(rawContent) {
            case "+":
                this.opCode = OpCode.ADDITION;
                break;
            case "-":
                this.opCode = OpCode.SUBTRACTION;
                break;
            case "*":
                this.opCode = OpCode.MULTIPLICATION;
                break;
            case "/":
                this.opCode = OpCode.DIVISION;
                break;
            case "%":
                this.opCode = OpCode.MODULO;
                break;
            case "^":
                this.opCode = OpCode.POWER;
                break;
            default:
                this.opCode = OpCode.UNKNOWN;
                throw new IllegalArgumentException("Unable to parse operator: " + rawContent);
        }
    }
    public OpCode getOpCode() {
        return opCode;
    }
    public NumNode evaluate() {
        NumNode prev;
        NumNode next;
        NumNode result;
        try {
            prev = (NumNode)this.getPrev();
            next = (NumNode)this.getNext();
        }
        catch(ClassCastException e) {
            throw new IllegalArgumentException("#Error: Wrong operands for operator " + this.rawContent);
        }
        switch(opCode) {
            case ADDITION:
                result = new NumNode(add(prev.getNumValue(), next.getNumValue()));
                break;
            case SUBTRACTION:
                result = new NumNode(subtract(prev.getNumValue(), next.getNumValue()));
                break;
            case MULTIPLICATION:
                result = new NumNode(multiply(prev.getNumValue(), next.getNumValue()));
                break;
            case DIVISION:
                result = new NumNode(divide(prev.getNumValue(), next.getNumValue()));
                break;
            case MODULO:
                result = new NumNode(modulo(prev.getNumValue(), next.getNumValue()));
                break;
            case POWER:
                result = new NumNode(power(prev.getNumValue(), next.getNumValue()));
                break;
            case UNKNOWN:
            default:
                throw new UnsupportedOperationException("Unknown operation");
        }
        result.setNext(next.getNext());
        result.setPrev(prev.getPrev());
        return result;
    }
    private double add(double x, double y) {
        return x + y;
    }
    private double subtract(double x, double y) {
        return x - y;
    }
    private double multiply(double x, double y) {
        return x * y;
    }
    private double divide(double x, double y) {
        double quotient = x / y;
        if(Double.isInfinite(quotient)) {
            throw new ArithmeticException("Division by zero");
        }
        else {
            return quotient;
        }
    }
    private double modulo(double x, double y) {
        double remainder = x % y;
        if(Double.isInfinite(remainder)) {
            throw new ArithmeticException("Division by zero");
        }
        return remainder;
    }
    private double power(double x, double y) {
        return Math.pow(x, y);
    }
}