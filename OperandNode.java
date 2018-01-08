/**
 * The class for my operand-type nodes from my expression tree
 * The operan nodes are leafs with true or false values.
 * @author Andrei-Ioan Cirnu
 *
 */

class OperandNode extends Node implements IVisitable {

    public boolean value;

    public OperandNode(boolean value) {
        super(null, null);
        this.value = value;
    }

    @Override
    public boolean accept(IVisitor visitor) {
        return visitor.visit(this);
    }
}