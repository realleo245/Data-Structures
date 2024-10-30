package Calculator;

public class NumNode extends RawNode {
    private double numValue;
    public NumNode(String rawContent) {
        super(rawContent);
        this.numValue = Double.parseDouble(rawContent);
    }
    public NumNode(double numValue) {
        super(String.valueOf(numValue));
        this.numValue = numValue;
    }
    public double getNumValue() {
        return numValue;
    }
}
