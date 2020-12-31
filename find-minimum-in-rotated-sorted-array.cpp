// Problem link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
// Time complexity: O(logn)
// Space complexity: O(1)

class Solution {
public:
    int findMin(vector<int>& nums) {
        int l = 0;
        int r = nums.size()-1;
        
        while(l < r) {
            int m = l + (r-l)/2;
            if (nums[m] <= nums[r]) {
                r = m;
            } else {
                l = m+1;
            }
        }
        return nums[l];
    }
};
