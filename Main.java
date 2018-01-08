import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		

		/**
		* I first create my subject and then by using the factory pattern
		* I create my observers factory
		*/
		Subject observers = new Subject();
		ObserversFactory obsFact = Singleton.getInstance(observers);

		Scanner a = new Scanner(System.in);
		String t = a.nextLine();
		
		
		/**
		* Parsing my input
		*/
		while(!t.equals("end")){
			String[] aa = t.split(" ");
			if(aa[0].equals("create_obs")) {
				int id=Integer.parseInt(aa[1]);
				aa[0]="";
				aa[1]="";
				String filter = String.join(" ", aa);
				obsFact.createObs(id,filter);
			}
			
			else if(aa[0].equals("feed")) {
				aa[0]=aa[1];
				aa[1]=aa[2];
				aa[2]="";
				String feed = String.join(" ", aa);
				observers.notifyAllObservers(feed);
				
			}
			else if(aa[0].equals("print")) {
				
				observers.printObsId(Integer.parseInt(aa[1]));
			}
			else if(aa[0].equals("delete_obs")) {
				observers.deleteObs(Integer.parseInt(aa[1]));
			}
			t=a.nextLine();
		}
		
		
	}
}
