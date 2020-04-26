//Problem link: https://leetcode.com/problems/product-of-array-except-self/submissions/
//Time complexity: O(n)
//Space complexity: O(1)

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        
        int cur = 1;
        for(int i=0; i<nums.length; i++) {
            if(i==0) {
                res[i] = 1;
                continue;
            }
            res[i] = res[i-1] * nums[i-1];
        }
        
        
        for(int i=nums.length-1; i>=0; i--) {
            res[i] *= cur;
            cur *= nums[i];
        }
        
        return res;
    }
}
