package StackExamples;

import java.util.Stack;

public class ValidParantheses {

	public static void main(String[] args) {
		
		/*
		Problem Statement
		Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
		
		An input string is valid if:
		Open brackets must be closed by the same type of brackets.
		Open brackets must be closed in the correct order.
		
		Constraints
		1 ≤ s.length ≤ 104
		s consists of parentheses only '()[]{}'.
		*/
		
		String s;
		
		
		s = "()";
		System.out.println(isValid(s));

		s = "()[]{}";
		System.out.println(isValid(s));
		
		s = "(]";
		System.out.println(isValid(s));
		
		s = "([)]";
		System.out.println(isValid(s));
		
		s = "{[]}";
		System.out.println(isValid(s));
		
	}
	
	public static boolean isValid(String s)
	{
		// stack to store left symbols (, [, {
		Stack<Character> leftSymbols = new Stack<>();
		
		// loop for each character of the string
		for (char c : s.toCharArray())
		{
			// if left symbol is encountered
			if (c == '(' || c == '[' || c == '{')
			{
				leftSymbols.push(c);
			}
			
			// if right symbol is encountered
			else if (c == ')' && !leftSymbols.isEmpty() && leftSymbols.peek() == '(')
			{
				leftSymbols.pop();
			}
			else if (c == ']' && !leftSymbols.isEmpty() && leftSymbols.peek() == '[')
			{
				leftSymbols.pop();
			}
			else if (c == '}' && !leftSymbols.isEmpty() && leftSymbols.peek() == '{')
			{
				leftSymbols.pop();
			}
			
			// If none of the valid symbols is encountered
			else
			{
				return false;
			}
			
		}
		
		
		return leftSymbols.isEmpty();
	}

}
