/**
 * The struct of a stock
 * @author Andrei-Ioan Cirnu
 *
 */


public class StockStruct {

	public String name;
	public float value;
	public float increase;
	public float lastPrintedValue;
	public int nrOfChanges;
	public boolean firstPrint;
	public boolean printable;
	
	
	public StockStruct(String name, float value,int nrOfChanges) {
		this.name=name;
		this.value=value;
		this.increase=0f;
		this.lastPrintedValue=0;
		this.firstPrint=true;
		this.nrOfChanges=nrOfChanges;
		this.printable=true;
	}
}
