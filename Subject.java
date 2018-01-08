/**
 * The subject class for the observer pattern
 * @author Andrei-Ioan Cirnu
 *
 */

import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;

public class Subject {
	
   private List<Observer> observers = new ArrayList<Observer>();
   Operator eq,ne,lt,le,gt,ge;
   ArrayList<String> feeds = new ArrayList<String>();
   
   
   /**
    * The Subject() constructor which initializes all of 
	* my operators by calling my operators factory.
    *
    */
   public Subject() {
	   OperatorsFactory opf = new OperatorsFactory();
	   this.eq = opf.getOp("eq");
	   this.ne = opf.getOp("ne");
	   this.lt = opf.getOp("lt");
	   this.le = opf.getOp("le");
	   this.gt = opf.getOp("gt");
	   this.ge = opf.getOp("ge");
	   
   }
   
   public void attach(Observer observer){
      observers.add(observer);		
   }


   /**
    * ThenotifyAllObservers() method which gets the feed 
	* as a string and then it passes it to all the
	* observers in the observers ArrayList
    *
    */
   public void notifyAllObservers(String afeed){
	   feeds.add(afeed);
	   for (Observer observer : observers) {
         observer.update(afeed);
      }
	  
	   
   }
   
   public void printObsId(int id) {
	   for (Observer observer : observers) {
		   if(observer.id == id) {
	         observer.print();}
	      }
   }
   
   public void deleteObs(int id) {
	   
	   for (Observer observer : observers) {
		   if(observer.id == id) {
	         observer.id=-1;}

	      }
   }
}