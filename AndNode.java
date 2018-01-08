/**
 * And Node class from the expression tree
 * @author Andrei-Ioan Cirnu
 *
 */

class AndNode extends Node implements IVisitable {

	char value='&';
    public AndNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public boolean accept(IVisitor visitor) {
        return visitor.visit(this);
    }
}