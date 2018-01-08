/**
 * And Node class from the expression tree
 * @author Andrei-Ioan Cirnu
 *
 */

class OrNode extends Node implements IVisitable {

	
	char value='|';
    public OrNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public boolean accept(IVisitor visitor) {
        return visitor.visit(this);
    }
}