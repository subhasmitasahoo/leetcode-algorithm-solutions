//Problem link: https://leetcode.com/problems/minimum-size-subarray-sum/
//Time complexity: O(n)
//Space complexity: O(1)

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int res = nums.length+1;
        int l = 0;
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            while(sum >= s) {
                if(sum >= s) {
                    res = Math.min(res, i-l+1);
                }
                sum -= nums[l];
                l++;
            }
        }
        if(res > nums.length) {
            return 0;
        }
        return res;
    }
}
