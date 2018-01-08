/**
 * The factory class which creates observers
 * @author Andrei-Ioan Cirnu
 *
 */
public class ObserversFactory {
	protected Subject subject;
	
	public ObserversFactory(Subject subject) {
		this.subject=subject;
	}
	
	public void createObs(int id,String filter) {
		Observer obs = new Observer(subject,id,filter);
		for(String feed : subject.feeds) {
			obs.update(feed);
		}
	}

}
