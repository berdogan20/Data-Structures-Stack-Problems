package gfgStackProblems;

import java.util.Stack;

public class PostfixToPrefixConversion {

	public static void main(String[] args) {
		
		/*
		Postfix: An expression is called the postfix expression 
		if the operator appears in the expression after the operands. 
		Simply of the form (operand1 operand2 operator). 
		Example : AB+CD-* (Infix : (A+B) * (C-D) )
		
		Prefix : An expression is called the prefix expression 
		if the operator appears in the expression before the operands. 
		Simply of the form (operator operand1 operand2). 
		Example : *+AB-CD (Infix : (A+B) * (C-D) )
		
		Given a Postfix expression, convert it into a Prefix expression. 
		Conversion of Postfix expression directly to Prefix 
		without going through the process of converting them 
		first to Infix and then to Prefix is much better in terms of 
		computation and better understanding the expression 
		(Computers evaluate using Postfix expression). 
		
		Input :  Postfix : AB+CD-*
		Output : Prefix :  *+AB-CD
		Explanation : Postfix to Infix : (A+B) * (C-D)
		              Infix to Prefix :  *+AB-CD
		
		Input :  Postfix : ABC/-AK/L-*
		Output : Prefix :  *-A/BC-/AKL
		Explanation : Postfix to Infix : ((A-(B/C))*((A/K)-L))
		              Infix to Prefix :  *-A/BC-/AKL
		 */
		
		 String post_exp = "ABC/-AK/L-*";
		 
	        // Function call
	        System.out.println("Prefix : "
	                           + convertPostfixToPrefix(post_exp));
	}

	private static boolean isOperator(char x)
    {
 
        switch (x) {
        case '+':
        case '-':
        case '/':
        case '*':
            return true;
        }
        return false;
    }
	
	public static String convertPostfixToPrefix(String s)
	{
		// We will store the characters of the
		// given string in a stack
		Stack<String> stack = new Stack<>();
		
		for (char c : s.toCharArray())
		{
			if (!isOperator(c))
			{
				stack.push(c + "");
			}
			else
			{
				String operand2 = stack.pop();
				String operand1 = stack.pop();
				String temp = c + operand1 + operand2;
				
				stack.push(temp);
			}
		}
		return stack.pop();
	}
	
}







