package StackExamples;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SortingAStackRecursively {

	public static void main(String[] args) {
		
		/*
		 
		  Given a stack, sort it using recursion. 
		  The use of any other data structures (like containers in STL or Collections in Java) is not allowed.

		  For example,
		
	 	  Stack before sorting : 5 | -2 | 9 | -7 | 3    where 3 is the top element
	 	  Stack after sorting  : -7 | -2 | 3 | 5 | 9    where 9 is the top element

		 */

		List<Integer> list = Arrays.asList(5, -2, 9, -7, 3);
		 
        Stack<Integer> stack = new Stack<>();
        stack.addAll(list);
 
        System.out.println("Stack before sorting: " + stack);
        sortStack(stack);
        System.out.println("Stack after sorting: " + stack);
        
        /*
         * The time complexity of the above solution is O(n2) and 
         * requires O(n) implicit space for the call stack, 
         * where n is the total number of elements in the stack.
         * */
	}
	
	private static void sortedInsert(Stack<Integer> stack, int key)
	{
		// base case : if the stack is empty 
		// or the key is greater than all the elements in the stack
		if (stack.isEmpty() || stack.peek() < key)
		{
			stack.push(key);
			return;
		}
		
		// remove top element
		int top = stack.pop();
		
		// recur for the remaining elements in the stack
		sortedInsert(stack, key);
		
		// push the top element back
		stack.push(top);
	}
	
	// Recursive method to sort a stack
	public static void sortStack(Stack<Integer> stack)
	{
		
		// base case: stack is empty
		if (stack.isEmpty())
		{
			return;
		}
		
		// remove top element
		int top = stack.pop();
		
		// recur for the remaining elements in the stack
		sortStack(stack);
		
		// insert the popped element back into the sorted stack
		sortedInsert(stack, top);
	}

}
