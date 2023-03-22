package gfgStackProblems;

import java.util.Stack;

public class PrefixToPostfixConversion {

	public static void main(String[] args) {
		
		/*
		 Prefix: An expression is called the prefix expression 
		 if the operator appears in the expression before the operands. 
		 Simply of the form (operator operand1 operand2). 
		 Example : *+AB-CD (Infix : (A+B) * (C-D) )
		
	 	 Postfix: An expression is called the postfix expression 
	 	 if the operator appears in the expression after the operands. 
	 	 Simply of the form (operand1 operand2 operator). 
		 Example : AB+CD-* (Infix : (A+B * (C-D) )
		 Given a Prefix expression, convert it into a Postfix expression. 
		 Conversion of Prefix expression directly to Postfix 
		 without going through the process of converting them first to 
		 Infix and then to Postfix is much better in terms of computation 
		 and better understanding the expression 
		 
		Input :  Prefix :  *+AB-CD
		Output : Postfix : AB+CD-*
		Explanation : Prefix to Infix :  (A+B) * (C-D)
		              Infix to Postfix :  AB+CD-*
		
		Input :  Prefix :  *-A/BC-/AKL
		Output : Postfix : ABC/-AK/L-*
		Explanation : Prefix to Infix :  (A-(B/C))*((A/K)-L)
		              Infix to Postfix : ABC/-AK/L-* 
		 */
		
		String pre_exp = "*-A/BC-/AKL";
        System.out.println("Postfix : "
                           + convertPrefixToPostfix(pre_exp));
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
	
	public static String convertPrefixToPostfix(String s)
	{
		// We will store the characters of given string
		// in a stack, in reverse order
		Stack<String> stack = new Stack<>();
		
		char c;
		for (int i = s.length() - 1; i >= 0; i--)
		{
			c = s.charAt(i);
			
			if (!isOperator(c))
			{
				stack.push(c + "");
			}
			else
			{
				String operand1 = stack.pop();
				String operand2 = stack.pop();
				
				String temp = operand1 + operand2 + c;
				stack.push(temp);
			}
		}
		
		return stack.pop();
		
	}
	
	

}





