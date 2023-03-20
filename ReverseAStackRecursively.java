package StackExamples;

import java.util.Stack;

public class ReverseAStackRecursively {

	public static void main(String[] args) {
		
		/*
		 Given a stack, recursively reverse it only using ,
		 its abstract data type (ADT) standard operations, 
		 i.e., push(item), pop(), peek(), isEmpty(), size(), etc.
		 */

		Stack<Integer> s = new Stack<>();
        for (int i = 1; i <= 5; i++) {
            s.push(i);
        }
 
        System.out.println("Original stack is " + s);
        reverseStack(s);
        System.out.println("Reversed stack is " + s);
        
        /*
         * The time complexity of the above solution is O(n2) 
         * and requires O(n) implicit space for the call stack, 
         * where n is the total number of elements in the stack
         * */
	}
	
	// Recursive function to insert an item at the bottom of a given stack
	private static void insertAtBottom(Stack<Integer> stack, int key)
	{
		// base case: if the stack is empty, insert the given item at the bottom
		if (stack.isEmpty())
		{
			stack.push(key);
			return;
		}
		
		// Pop all items from the stack and hold them in the call stack
		int top = stack.pop();
		insertAtBottom(stack, key);
		
		// After the recursion unfolds, push each item in the call stack
        // at the top of the stack
		stack.push(top);
	}

	// Recursive function to reverse a given stack
	public static void reverseStack(Stack<Integer> stack)
	{
		// base case: if the stack is empty
		if (stack.isEmpty())
		{
			return;
		}
		
		// Pop all items from the stack and hold them in the call stack
		int top = stack.pop();
		reverseStack(stack);
		
		// After the recursion unfolds, insert each item in the call stack
        // at the bottom of the stack
		insertAtBottom(stack, top);
	}
}
