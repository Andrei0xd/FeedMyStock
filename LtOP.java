/**
 * Class of the "lt" operator
 * @author Andrei-Ioan Cirnu
 *
 */

public class LtOP extends Operator{


	public String result(String filterString, String feed) {
		if(Float.parseFloat(feed)<Float.parseFloat(filterString))
			  return "1";
		return "0";
	}

}
