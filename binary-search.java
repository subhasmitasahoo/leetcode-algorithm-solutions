//Problem link: https://leetcode.com/problems/binary-search/submissions/

//Time complexity: O(logn)
//Space complexity: O(1)

class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length-1;
        
        while(l<=h) {
            int m = l + (h-l)/2;
            if(nums[m] == target) {
                return m;
            } 
            if(nums[m] < target) {
                l = m+1;
            } else {
                h = m-1;
            }
        }
        return -1;
    }
}
