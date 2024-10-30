package Calculator;

public class RawNode {
    protected String rawContent;
    protected RawNode prev;
    protected RawNode next;
    public RawNode(String rawContent) {
        this.rawContent = rawContent;
        this.prev = new RawNode();
        this.next = new RawNode();
    }
    public RawNode() {
        //TODO Auto-generated constructor stub
    }
    /**
     * 
     * @return the raw content
     */
    public String getRawContent() {
        return rawContent;
    }
    /**
     * 
     * @return the previous node
     */
    public RawNode getPrev() {
        return prev;
    }
    /**
     * 
     * @return the next node
     */
    public RawNode getNext() {
        return next;
    }
    /**
     * Sets the previous node
     * @param node
     */
    public RawNode setPrev(RawNode node) {
        this.prev.prev = node.prev;
        this.prev = node;
        this.prev.next = this;
        return node;
    }
    /**
     * Sets the next node
     * @param node
     */
    public RawNode setNext(RawNode node) {
        this.next = node;
        node.prev = this;
        return node;
    } 

    public String toString() {
        return rawContent;
    }
}
