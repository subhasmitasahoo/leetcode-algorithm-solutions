//Problem link: https://leetcode.com/problems/search-in-rotated-sorted-array/
//Time complexity: O(logn)
//Space complexity: O(1)

class Solution {
    public int search(int[] nums, int target) {
        
        int len = nums.length;
        if(len == 0) {
            return -1;
        }
        
        int l = 0, h = len-1;
        
        while(l<=h) {
            int m = l + (h-l)/2;
            if(nums[m] == target) {
                return m;
            }
            //Left part is sorted, so apply normal binary search there
            if(nums[l] <= nums[m]) {
                if(target >= nums[l] && target <= nums[m]) {
                    h = m-1;
                } else {
                    l = m+1;
                }
            }
            //Right part is sorted, so apply normal binary search there
            else {
                if(target >= nums[m] && target <= nums[h]) {
                    l = m+1;
                } else {
                    h = m-1;
                }
            }
        }
        return -1;
    }
}
