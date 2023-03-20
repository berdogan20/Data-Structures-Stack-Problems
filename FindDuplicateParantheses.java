package StackExamples;

import java.util.Stack;

public class FindDuplicateParantheses {

	public static void main(String[] args)
	{
		/*
		 * Given a balanced expression that can contain opening and closing parenthesis, 
		 * check if it contains any duplicate parenthesis or not.
		 
		 Input:  ((x+y))+z
		 Output: true
		 Explanation: Duplicate () found in subexpression ((x+y))
		 
		 
		 Input:  (x+y)
		 Output: false
		 Explanation: No duplicate () is found
		 
		 
		 Input:  ((x+y)+((z)))
		 Output: true
		 Explanation: Duplicate () found in subexpression ((z))
		 * */
		
		 String exp = "((bf(fg))())";        // assumes valid expression
		 
	     if (hasDuplicateParenthesis(exp)) {
	            System.out.println("The expression has duplicate parenthesis.");
	        }
	     else {
	            System.out.println("The expression does not have duplicate parenthesis");
	     }
	            
	}
	
	/*
	// Function to find duplicate parenthesis in an expression
	public static boolean hasDuplicateParenthesis(String str)
	{
		if (str == null || str.length() <= 3)
		{
			return false;
		}
		
		// take an empty stack of characters          (((((()
		Stack<Character> stack = new Stack<>();
		
		// traverse the input expression
		for (char c: str.toCharArray())
		{
			// if the current char in the expression is not a closing parenthesis
			if (c != ')')
			{
				stack.push(c);
			}
			
			// if the current char in the expression is a closing parenthesis
			else
			{
				// if the stack's top element is an opening parenthesis,
                // the subexpression of the form ((str)) is found
				if (stack.peek() == '(')
				{
					return true;
				}
				
				// pop till '(' is found for current ')'
                while (stack.peek() != '(') {
                    stack.pop();
                }
                
                // pop '('
                stack.pop();	
			}
		}
		
		// if we reach here, then the expression does not have any
        // duplicate parenthesis
        return false;
	}
	*/
	
	public static boolean hasDuplicateParenthesis(String str)
	{
		if (str == null || str.length() <= 3)
		{
			return false;
		}
		
		int count = 0; // (s(d(f(d)()))
		
		Stack<Character> stack = new Stack<>();
		
		for (char c: str.toCharArray())
		{
			if (c != ')') {
				stack.push(c);
			}
			else
			{
				while (stack.peek() != '(')
				{
					stack.pop();
				}
				
				count++;
				stack.pop();
			}
		}
		
		return (count % 2 == 0 && !stack.contains('('));
	}
	
	
	
	
	
	
}










