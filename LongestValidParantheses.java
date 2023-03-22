package LeetCodeStackProblems;

import java.util.Stack;

public class LongestValidParantheses {

	public static void main(String[] args) {
		
		/*
		 * Given a string containing just the characters '(' and ')', 
		 * return the length of the longest valid (well-formed) parentheses  substring
		
		Input: s = "(()"
		Output: 2
		Explanation: The longest valid parentheses substring is "()".
		
		Input: s = ")()())"
		Output: 4
		Explanation: The longest valid parentheses substring is "()()".
		
		Input: s = ""
		Output: 0
		*/
		
		
	}

	
	public int longestValidParentheses(String s)
	{
		if(s == null || s.length() < 2)
		{
            return 0;
        }

        Stack<Integer> stack =new Stack<>();

        for(int i = 0; i < s.length(); i++)
        {
        	if (s.charAt(i) == '(')
        	{
        		stack.push(i);
            } 
        	else
        	{
                if(!stack.empty() && s.charAt(stack.peek()) == '(')
                {
                	stack.pop();
                } 
                else 
                {
                	stack.push(i);
                }
            }
        }
     
        int maxLen = 0;
        int endTerminal = s.length();

        while(!stack.empty())
        {
            int startTerminal  = stack.pop();
            maxLen = Math.max(maxLen, endTerminal - startTerminal -1);
            endTerminal = startTerminal;
        }

        return Math.max(endTerminal, maxLen);
		
	}
}
