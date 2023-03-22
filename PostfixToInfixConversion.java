package gfgStackProblems;

import java.util.Stack;

public class PostfixToInfixConversion {

	public static void main(String[] args) {
		
		/*
		 Input : abc++
		 Output : (a + (b + c))
		
		 Input  : ab*c+
		 Output : ((a*b)+c)
		 */
		
		String exp = "ab*c+";
	    System.out.println(convertPostfixToInfix(exp));
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
	
	public static String convertPostfixToInfix(String s)
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
				String operator2 = stack.pop();
				String operator1 = stack.pop();
				String temp = '(' + operator1 + c + operator2 + ')';
				stack.push(temp);
			}
		}
		
		return stack.pop();
	}
}
