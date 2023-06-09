
import java.util.Stack;

public class TrappingRainWater {

	public static void main(String[] args) {
		
		/*
		 * Given n non-negative integers representing an elevation map 
		 * where the width of each bar is 1, compute how much water it can trap after raining
		 
		 Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
		 Output: 6
		 Explanation: The above elevation map (black section) is represented by array 
		 [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
		 
		 Input: height = [4,2,0,3,2,5]
		 Output: 9
		 */
	}
	
	public int trap(int[] height) {
        
		int left = 0; 
	    int right = height.length - 1;
	    int ans = 0; 
	    int leftMax = 0, rightMax = 0;
	        
	    while(left <= right)
	    {
	    	leftMax = Math.max(height[left], leftMax);
	    	rightMax = Math.max(height[right], rightMax);			  
	            
	        if (leftMax < rightMax)
	        {
	           ans += leftMax - height[left++];
	        }
	        else 
	        {
	           ans += rightMax - height[right--];
	        }
	   }
	   
	    return ans;
    }

}
