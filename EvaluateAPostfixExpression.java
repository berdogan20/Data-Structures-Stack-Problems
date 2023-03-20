package StackExamples;

import java.util.Stack;

public class EvaluateAPostfixExpression {

	public static void main(String[] args) {
		
		/*
		 
		 Write code to evaluate a given postfix expression efficiently.

 		 For example,
		
		 82/ will evaluate to 4 (8/2)
		 
	 	 138*+ will evaluate to 25 (1+8*3)
		 
		 545*+5/ will evaluate to 5 ((5+4*5)/5)
		 
		 Assume that the postfix expression contains only single-digit numeric operands, without any whitespace.
		 
		 */
		
		String exp = "138*+";
        System.out.println(evalPostfix(exp));

	}
	
	// Function to evaluate a given postfix expression
	public static int evalPostfix(String str)
	{
		// base case
		if (str == null || str.length() == 0)
		{
			System.exit(-1);
		}
		
		// create an empty stack
		Stack<Integer> stack = new Stack<>();
		
		for (char c : str.toCharArray())
		{
			// if the current character is an operand, push it into the stack
			if (Character.isDigit(c))
			{
				stack.push(c - '0');
			}
			
			// if the current character is an operator
			else
			{
				// remove the top two elements from the stack
				int x = stack.pop();
				int y = stack.pop();
				
				// evaluate the expression 'x op y', and push the
                // result back to the stack
				if (c == '+')
				{
					stack.push(x + y);
				}
				else if (c == '-')
				{
					stack.push(y - x);
				}
				else if (c == '*')
				{
					stack.push(x * y);
				}
				else // /
				{
					stack.push(y / x);
				}
			}
		}
		
		// At this point, the stack is left with only one element, i.e.,
        // expression result
		return stack.pop();
	}
}
