/**
 * Class to create the Expression Tree
 * @author Andrei-Ioan Cirnu
 *
 */

import java.util.Stack;

class ExpressionTree {
 

	/**
	 * Metoda care intoarce true daca un caracter este operator ( sau / si ) si false altfel.
	 * @author Andrei-Ioan Cirnu
	 *
	 */
	boolean isOperator(char c) {
        if (c == '&' || c == '|') {
            return true;
        }
        return false;
    }
    
 
	
	/**
	 * Metoda care primeste un char array al unei expresii postfix si creaza
	 * arborele acelei expresii.
	 * @author Andrei-Ioan Cirnu
	 *
	 */
    Node constructTree(char postfix[]) {
        Stack<Node> st = new Stack<Node>();
        Node t, t1, t2;
 
        for (int i = 0; i < postfix.length; i++) {
 
            // Daca e operand, il fac OperandNode si il pun in stiv
            if (!isOperator(postfix[i])) {
            	if(postfix[i]=='1')
            		t = new OperandNode(true);
            	else
            		t = new OperandNode(false);
                st.push(t);
            } else // operator
            {
            	t1 = st.pop();    
                t2 = st.pop();


                //Daca nu e operand, il fac AndNode sau OrNode cu copii cele
                //doua elemente de sub el din stiva
            	if(postfix[i]=='&')
            		t = new AndNode(t2,t1);
            	else
                	t = new OrNode(t2,t1);
 

                st.push(t);
            }
        }
 
        // Elementul ramas este rootul
        // arborelui de expresii
        t = st.peek();
        st.pop();
        return t;
 }
}