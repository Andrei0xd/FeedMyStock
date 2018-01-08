/**
 * Transforming a Infix expression to a postfix one
 * @author Andrei-Ioan Cirnu
 *
 */

public class InToPost {
   private Stack theStack;
   private String input;
   private String output = "";
   public InToPost(String in) {
      input = in;
      int stackSize = input.length();
      theStack = new Stack(stackSize);
   }
   
   /**
	* The doTrans() method,which goes over the expression char by char
	* decides if the char is an operator,an operand or a parenthesis
	* and also decides which operator is more dominant than the other.
	* It then calls the right method for it's type.
	*/
   public String doTrans() {
      for (int j = 0; j < input.length(); j++) {
         char ch = input.charAt(j);
         switch (ch) {
            case '|':
               gotOper(ch, 1); 
               break; 
            case '&': 
               gotOper(ch, 2); 
               break; 
            case '(': 
               theStack.push(ch);
               break;
            case ')': 
               gotParen(ch); 
               break;
            case ' ':
            	break;
            default: 
               output = output + ch; 
               break;
         }
      }
      while (!theStack.isEmpty()) {
         output = output + theStack.pop();
      }
      return output; 
   }
   
   /**
	* The method that updates the stack in case our current char
	* is an operator
	*/
   public void gotOper(char opThis, int prec1) {
      while (!theStack.isEmpty()) {
         char opTop = theStack.pop();
         if (opTop == '(') {
            theStack.push(opTop);
            break;
         } else {
            int prec2;
            if (opTop == '|')
            prec2 = 1;
            else
            prec2 = 2;
            if (prec2 < prec1) { 
               theStack.push(opTop);
               break;
            } 
            else output = output + opTop;
         }
      }
      theStack.push(opThis);
   }
   public void gotParen(char ch) { 
      while (!theStack.isEmpty()) {
         char chx = theStack.pop();
         if (chx == '(') 
         break; 
         else output = output + chx; 
      }
   }
   class Stack {
      private int maxSize;
      private char[] stackArray;
      private int top;
      
      public Stack(int max) {
         maxSize = max;
         stackArray = new char[maxSize];
         top = -1;
      }
      public void push(char j) {
         stackArray[++top] = j;
      }
      public char pop() {
         return stackArray[top--];
      }
      public char peek() {
         return stackArray[top];
      }
      public boolean isEmpty() {
         return (top == -1);
      }
   }
}