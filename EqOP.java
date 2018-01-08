/**
 * Class of the "eq" operator
 * @author Andrei-Ioan Cirnu
 *
 */


public class EqOP extends Operator{


	public String result(String filterString, String feed) {
		if(filterString.equals(feed))
			  return "1";
		return "0";
	}

}
