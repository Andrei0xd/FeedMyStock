/**
 * Class for the visitor pattern to call the accept function
 * of and operator node.
 * @author Andrei-Ioan Cirnu
 *
 */

class CalculatorVisitor implements IVisitor {

    //@Override
    public boolean visit(OrNode operatorNode) {
        return operatorNode.left.accept(this) || operatorNode.right.accept(this);
    }

    @Override
    public boolean visit(AndNode operatorNode) {
        return operatorNode.left.accept(this) && operatorNode.right.accept(this);
    }

    //@Override
    public boolean visit(OperandNode operandNode) {
        return operandNode.value;
    }
}