/**
 * Visitable class for the visitor pattern
 * @author Andrei-Ioan Cirnu
 *
 */

interface IVisitable {

    boolean accept(IVisitor visitor);
}