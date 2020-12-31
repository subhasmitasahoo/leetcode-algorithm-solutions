// Problem link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
public:
    int findMin(vector<int>& nums) {
        int l = 0;
        int r = nums.size()-1;
        
        while(l < r) {
            int m = l + (r-l)/2;
            //cout<<l<<" "<<r<<" "<<m<<endl;
            if (nums[m] < nums[r]) {
                r = m;
            } else if (nums[m] > nums[r]) {
                l = m+1;
            } else {
                r -= 1;
            }
        }
        return nums[l];
    }
};
