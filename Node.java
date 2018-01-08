/**
 * Node class for my expression tree. It also implements
 * IVisitable for the visitor pattern
 * @author Andrei-Ioan Cirnu
 *
 */

public class Node implements IVisitable{
 
    char value;
    String val;
    Node left, right;
 
    Node(char item) {
        value = item;
        left = right = null;
    }
    public Node(Node left, Node right) {
        this.left = left;
        this.right = right;
    }
	@Override
	public boolean accept(IVisitor visitor) {
		
		return false;
	}
	 @Override
	    public String toString() {
	        return (right == null && left == null) ? (val) : "(" + left.toString()+ val + right.toString() + ")";
	    }

}