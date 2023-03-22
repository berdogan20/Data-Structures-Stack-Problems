package gfgStackProblems;

import java.util.Stack;

public class PrefixToInfixConversion {

	public static void main(String[] args) {
		
		/*
		 Infix : An expression is called the Infix expression 
		 if the operator appears in between the operands in the expression. 
		 Simply of the form (operand1 operator operand2). 
		 Example : (A+B) * (C-D)
		
	 	 Prefix : An expression is called the prefix expression 
	 	 if the operator appears in the expression before the operands. 
	 	 Simply of the form (operator operand1 operand2). 
		 Example : *+AB-CD (Infix : (A+B) * (C-D) )
		
		 Given a Prefix expression, convert it into a Infix expression. 
		 Computers usually does the computation in either prefix or postfix (usually postfix). 
		 But for humans, its easier to understand an Infix expression rather than a prefix. 
		 Hence conversion is need for human understanding.
		 
		 Input :  Prefix :  *+AB-CD
		 Output : Infix : ((A+B)*(C-D))
		
	 	 Input :  Prefix :  *-A/BC-/AKL
		 Output : Infix : ((A-(B/C))*((A/K)-L))
		 */
		
		String exp = "*-A/BC-/AKL";
	    System.out.println("Infix : " + convertPrefixToInfix(exp));
	    System.out.println("Infix : " + convert(exp));
	}

	public static String convertPrefixToInfix(String s)
	{
		// The stack will store the characters
		// of the given string in reverse order
		
		Stack<String> stack = new Stack<>();
		StringBuilder result = new StringBuilder();
		StringBuilder temp;
		
		char c;
		for (int i = s.length() - 1; i >= 0; i--)
		{
			c = s.charAt(i);
			
			// if the char is an alphabetical character
			// store it to apply the next operator 
			if (Character.isAlphabetic(c))
			{
				stack.push(c + "");
			}
			
			else if (c == '-')
			{
				temp = new StringBuilder();
				
				temp.append('(');
				temp.append(stack.pop());
				temp.append('-');
				temp.append(stack.pop());
				temp.append(')');
				stack.push(temp.toString());
			}
			else if (c == '+')
			{
				temp = new StringBuilder();
				
				temp.append('(');
				temp.append(stack.pop());
				temp.append('+');
				temp.append(stack.pop());
				temp.append(')');
				stack.push(temp.toString());
			}
			else if (c == '*')
			{
				temp = new StringBuilder();
				
				temp.append('(');
				temp.append(stack.pop());
				temp.append('*');
				temp.append(stack.pop());
				temp.append(')');
				stack.push(temp.toString());
			}
			else if (c == '/')
			{
				temp = new StringBuilder();
				
				temp.append('(');
				temp.append(stack.pop());
				temp.append('/');
				temp.append(stack.pop());
				temp.append(')');
				stack.push(temp.toString());
			}
		}
		return stack.pop();
	}
	
	
	// In a better solution, we can write a function 
	// for all recurrent codes
	private static boolean isOperator(char x)
	{
	    switch(x)
	    {
	        case '+':
	        case '-':
	        case '*':
	        case '/':
	        case '^':
	        case '%':
	            return true;
	    }
	    return false;
	}
	
	public static String convert(String str)
	{
	    Stack<String> stack = new Stack<>();
	     
	    // Reading from right to left
	    for(int i = str.length() - 1; i >= 0; i--)
	    {
	        char c = str.charAt(i);
	        if (isOperator(c))
	        {
	            String op1 = stack.pop();
	            String op2 = stack.pop();
	             
	            // Concat the operands and operator
	            String temp = "(" + op1 + c + op2 + ")";
	            stack.push(temp);
	        }
	        else
	        {
	             
	            // To make character to string
	            stack.push(c + "");
	        }
	    }
	    return stack.pop();
	}
}
