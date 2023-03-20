package StackExamples;

import java.util.Stack;

public class DecodeSequenceWithMinNumber {

	public static void main(String[] args) {
		
		/*
		 Given a sequence of length <= 8 consisting of I and D, 
		 where I denotes the increasing sequence 
		 and D denotes the decreasing sequence, decode the sequence to 
		 construct a minimum number without repeated digits.
		 
		 For example,
		 
		 sequence        output
 
		 IIDDIDID  ——>  125437698
		 IDIDII    ——>  1325467
		 DDDD      ——>  54321
		 IIII      ——>  12345
		 */
		
		// input sequence
        String seq = "IDIDII";
 
        System.out.println("The minimum number is " + decode(seq));

        /*
         * The time complexity of the above solution is O(n) 
         * and requires O(n) extra space, where n is the length of the input string.
         * */
	}
	
	// Function to decode the given sequence to construct a minimum number
    // without repeated digits
	public static String decode(String seq)
	{
		// base case
		if (seq == null || seq.length() == 0)
		{
			return seq;
		}
		
		// `result` store the output string
        StringBuilder result = new StringBuilder();
        
        // create an empty stack of integers
        Stack<Integer> stack = new Stack<>();
        
        // run `n+1` times, where `n` is the length of the input sequence
        for (int i = 0; i <= seq.length(); i++)
        {
        	// push number i+1 onto the stack
        	stack.push(i + 1);
        	
        	// if all characters of the input sequence are processed, or
            // the current character is 'I' (increasing)
        	if (seq.length() == i || seq.charAt(i) == 'I')
        	{
        		// run till stack is empty
        		while (!stack.isEmpty())
        		{
        			 // remove a top element from the stack and add it to the 
        			result.append(stack.pop());
        		}
        	}
        }
        
        return result.toString();
	}

}
