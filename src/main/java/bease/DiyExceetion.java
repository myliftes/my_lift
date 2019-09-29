package bease;

public class DiyExceetion  extends Exception {
	
    private int value;
    
    public DiyExceetion() {
        super();
    }
    public DiyExceetion(String msg,int value) {
        super(msg);
        this.value=value;
    }
    public int getValue() {
        return value;
    }
}
