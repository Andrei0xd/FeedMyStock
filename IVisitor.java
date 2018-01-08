/**
 * Visitor class for the visitor pattern
 * @author Andrei-Ioan Cirnu
 *
 */

interface IVisitor {

    boolean visit(AndNode operatorNode);

    boolean visit(OrNode operatorNode);

    boolean visit(OperandNode operandNode);
}