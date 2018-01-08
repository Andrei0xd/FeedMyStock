/**
 * A factory which gets the name of the operator as a string 
 * and then it creates it.
 * @author Andrei-Ioan Cirnu
 *
 */

public class OperatorsFactory {

	public Operator getOp(String opType) {
		Operator op = null;
		if(opType.equals("eq"))
			op = new EqOP();
		else if(opType.equals("ne"))
			op = new NeOP();
		else if(opType.equals("lt"))
			op = new LtOP();
		else if(opType.equals("le"))
			op = new LeOP();
		else if(opType.equals("gt"))
			op = new GtOP();
		else if(opType.equals("ge"))
			op = new GeOP();	
		return op;
	}
}