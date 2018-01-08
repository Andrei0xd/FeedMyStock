/**
 * Class of the "le" operator
 * @author Andrei-Ioan Cirnu
 *
 */

public class LeOP extends Operator{


	public String result(String filterString, String feed) {
		if(Float.parseFloat(feed)<=Float.parseFloat(filterString))
			  return "1";
		return "0";
	}

}
