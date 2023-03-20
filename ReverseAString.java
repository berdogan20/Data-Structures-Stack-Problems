package StackExamples;

import java.util.Arrays;
import java.util.Stack;

public class ReverseAString {

	public static void main(String[] args) {
		
		String str = "Reverse me";
		 
        str = reverse(str);
        System.out.println(str);
        
        /*
         * The time complexity of the solution is O(n), 
         * where n is the length of the input string. 
         * The auxiliary space required by the program is 
         * O(n) for the stack data structure.
         * */
	}
	
	
	// Reverse a string using a stack container in Java
	public static String reverse(String s)
	{
		Stack<Character> tempS = new Stack<>();
		char[] chars = new char[s.length()];
		
		 // push each character in the string into the stack
		for (char c: s.toCharArray())
		{
			tempS.push(c);
		}
		
		// pop all characters from the stack and
        // put them back to the character array
		for (int i = 0; i < s.length(); i++)
		{
			chars[i] = tempS.pop();
		}
		
		// convert the char array to a string and return
		return new String(chars);
	}

}
