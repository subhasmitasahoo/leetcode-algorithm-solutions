// Problem link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// Time complexity: O(logn)
// Space complexity: O(1)

class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int sz = nums.size();
        int mini = -1;
        int maxi = -1;
        
        int l = 0, h = sz-1;
        
        // Find the min position
        while(l<=h) {
            int m = l + (h-l)/2;
            if(nums[m] == target) {
                mini = m;
                h = m-1;
            } else if(nums[m] < target) {
                l = m+1;
            } else {
                h = m-1;
            }
        }
        
        l = 0, h = sz-1;
        // Find the max position
        while(l<=h) {
            int m = l + (h-l)/2;
            if(nums[m] == target) {
                maxi = m;
                l = m+1;
            } else if(nums[m] < target) {
                l = m+1;
            } else {
                h = m-1;
            }
        }
        
        return vector<int>({mini, maxi});
    }
};
