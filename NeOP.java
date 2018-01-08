/**
 * Class of the "ne" operator
 * @author Andrei-Ioan Cirnu
 *
 */

public class NeOP extends Operator{


	public String result(String filterString, String feed) {
		if(filterString.equals(feed))
			  return "0";
		return "1";
	}

}
