import java.util.Map;
import java.util.TreeMap;

/**
 * Observer class
 * @author Andrei-Ioan Cirnu
 *
 */
public class Observer{

   protected Subject subject;
   int id; 
   String filter;
   TreeMap<String,StockStruct> map;
   int timeCreated;
  
   public Observer(Subject subject,int id,String filter){
	  this.map = new TreeMap<String, StockStruct>();
      this.subject = subject;
      this.id=id;
      this.filter=filter;
      this.subject.attach(this);
      this.timeCreated=subject.feeds.size();
   }

   /**
    * The update method of an observer, which gets the feed as the input
	* it runs it through the filter and then decides weather it should
	* make a change in any StockStructs from my tree map.
    *
    */
   public void update(String afeed) {
	   
	  String[] feed = afeed.split(" ");
      String[] f1 = filter.split(" ");
      
      for(int i=0;i<f1.length;i++) {
	  
    	  if(f1[i].equals("nil"))
    		  f1[i]="1";
    	  
    	  if(f1[i].equals("eq")) {
    		  if(f1[i+1].equals("name")) {
    				  f1[i]=subject.eq.result(f1[i+2],feed[0]);
    		  }
    		  else {
    			  if(Float.parseFloat(feed[1])==Float.parseFloat(f1[i+2]))
    				  f1[i]="1";
    			  else
    				  f1[i]="0";
    						  
    		  }
    		  f1[i+1]="";
    		  f1[i+2]="";
    	  }
    	   
    	  
    	  if(f1[i].equals("ne")) {
    		  if(f1[i+1].equals("name")) {
    			  f1[i]=subject.ne.result(f1[i+2],feed[0]);
    		  }
    		  else {
    			  if(Float.parseFloat(feed[1])==Float.parseFloat(f1[i+2]))
    				  f1[i]="0";
    			  else
    				  f1[i]="1";
    						  
    		  }
    		  f1[i+1]="";
    		  f1[i+2]="";
    	  }
    	  
    	  if(f1[i].equals("gt")) {
    		  f1[i]=subject.gt.result(f1[i+2],feed[1]);
    		  f1[i+1]="";
    		  f1[i+2]="";
    	  }
    	  
    	  if(f1[i].equals("ge")) {
    		  f1[i]=subject.ge.result(f1[i+2],feed[1]);
    		  f1[i+1]="";
    		  f1[i+2]="";
    	  }
    	  
    	  if(f1[i].equals("lt")) {
    		  f1[i]=subject.lt.result(f1[i+2],feed[1]);
    		  f1[i+1]="";
    		  f1[i+2]="";
    	  }
    	  
    	  if(f1[i].equals("le")) {
    		  f1[i]=subject.le.result(f1[i+2],feed[1]);
    		  f1[i+1]="";
    		  f1[i+2]="";
    	  }
    	  
    	  if(f1[i].equals("||"))
    		  f1[i]="|";
    	  if(f1[i].equals("&&"))
    		  f1[i]="&";
    	  
      }
      
      String f2 = String.join("", f1);
      
      InToPost test = new InToPost(f2);
      ExpressionTree et = new ExpressionTree();
      String postfix = test.doTrans();
      char[] charArray = postfix.toCharArray();
      Node root = et.constructTree(charArray);
      if(root.accept(new CalculatorVisitor())==true) {
    	  if(map.containsKey(feed[0])) {
    	  	  	map.get(feed[0]).value=Float.parseFloat(feed[1]);
    	  	  	map.get(feed[0]).printable=true;
    	  		}
    	  else {
    		  int change=0;
    		  map.put(feed[0],new StockStruct(feed[0], Float.parseFloat(feed[1]),change));
    	  }
    	  				
      }
      else
    	  if(map.containsKey(feed[0])) 
  	  	  	map.get(feed[0]).printable=false;
   }
   
   /**
    * The print method of an observer, which iterates through my treemap of StockStructs 
	* and prints them, while also making changes,because the output is based on last time I printed
    *
    */
   public void print() {
	   for (Map.Entry<String,StockStruct> entry : map.entrySet()) {

		   if(entry.getValue().firstPrint) {
			   entry.getValue().increase = 0;
			   if(entry.getValue().printable)
			   entry.getValue().firstPrint = false;
		   }
		   else
			   entry.getValue().increase=(1-entry.getValue().value/entry.getValue().lastPrintedValue)*100;
		   
		   if(entry.getValue().increase!=0.00f)
			   entry.getValue().increase*=-1;
		   String name = entry.getValue().name;
		   
		   int change=0,i=0;
		   for(String feed : subject.feeds) {
			   String feedName[]=feed.split(" ");
			   i++;
			   if (feedName[0].equals(name) && i>this.timeCreated)
				   change++;
		   }
   
		   String strDouble = String.format("%.2f", entry.getValue().increase);   
		   
		   if(entry.getValue().printable==true) {
			   entry.getValue().lastPrintedValue = entry.getValue().value;
			   System.out.println("obs "+this.id+": "+entry.getValue().name+" "
				   +entry.getValue().value+" "+ strDouble+
				    "% "+(change-entry.getValue().nrOfChanges));
			   entry.getValue().nrOfChanges=change;
		   }
		   
		}
   }
}