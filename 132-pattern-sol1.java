//Time complexity: O(n)
//Space complexity: O(n)

/*Solution explanation: 
    Relation to satisfy: ai < ak < aj (ai<ak, ai<aj, ak<aj), where i<j<k
    
    Satisfy: ai<aj
    From this, we know that i has to be the as small as possible and can be anywhere to the left of other two indices. 
    This can be easily achieved by storing the minimum of left values for indices by traversing from left to right.
    
    Next we need to satisfy: ai<ak, ak<aj 
    Here, we traverse for index j. For each j, we try to find k in the right that satisfies the above two relations. 
    
    Satisfy: ai<ak
    Imagine for the current j index, we have stored the values of k in ascending order such that all those values are greater than min[j+1]. 
    Lets, name this group of numbers as Right[k]. We know that min[j] >= min[j+1] (think, take some examples and trace). 
    From this we can observe that Right[j+1] = subset of (Right[j]), by removing beginning elements of Right[j], 
    that are smaller than min[j+1] (Note: Right[j] is sorted). 
    
    Satisfy: ak<aj
    Now, we can check for the first element of Right[j+1], if it is smaller than nums[j], we can return true. 
    Else, we can store the current value in the Right[] group to act as the potential candidate for j-1. 
*/


class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums.length < 3) {
            return false;
        }
                
        int[] mini = new int[nums.length];
        mini[0] = Integer.MAX_VALUE;
        
        int curMin = nums[0];
        
        for(int i=1; i<nums.length; i++) {
            curMin = Math.min(curMin, nums[i-1]);
            mini[i] = curMin;
        }
        
        Stack<Integer> stk = new Stack();
        stk.push(nums[nums.length-1]);
        
        for(int j=nums.length-2; j>=0; j--) {
            while(!stk.isEmpty() && stk.peek() <= mini[j]) {
                stk.pop();
            }
            if(!stk.empty() && nums[j] > stk.peek()) {
                return true;
            }
            stk.push(nums[j]);
        }
        return false;
    }
}
