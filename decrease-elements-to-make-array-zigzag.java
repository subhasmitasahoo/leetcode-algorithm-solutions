//Problem link: https://leetcode.com/problems/decrease-elements-to-make-array-zigzag/
//Time complexity: O(n)
//Space complexity: O(1)

class Solution {
    public int movesToMakeZigzag(int[] nums) {
        int ans = 0;
        int cur = 0;
        
        int[] temp = Arrays.copyOf(nums, nums.length);
        for(int i=1; i<nums.length; i+=2) {
            int ele = nums[i];
            int dec = 0;
            dec = Math.max(0, nums[i]-nums[i-1]+1);
            ele = Math.min(ele, ele-dec);
            if(i+1 < nums.length) {
                dec += Math.max(0, ele-nums[i+1]+1);
            }
            cur += dec;
        }
        ans = cur;
        cur = 0;
        for(int i=1; i<nums.length; i+=2) {
            cur += Math.max(0, nums[i-1]-nums[i]+1);
            if(i+1 < nums.length) {
                cur += Math.max(0, nums[i+1]-nums[i]+1);
            }
            if(i+1<nums.length && nums[i+1] >= nums[i]) {
                nums[i+1] = nums[i]-1;
            }
        }
        ans = Math.min(ans,cur);
        return ans; 
    }
}
