//Problem link: https://leetcode.com/problems/valid-triangle-number/
//Time complexity: O(n^2)
//Space complexity: O(valid-triangle-number)

class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for(int i=0; i<nums.length; i++) { 
            int k = i+2;
            for(int j=i+1; j<nums.length; j++) {
                k = Math.max(k, j+1);
                while(k<nums.length && nums[i]+nums[j] > nums[k]) {
                    k++;
                }
                res += k-j-1;
            }
        }
        return res;
    }
}
