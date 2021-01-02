// Problem link: https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
public:
    int findUnsortedSubarray(vector<int>& nums) {
        
        int sz = nums.size();
        int li = sz;
        int ri = -1;
        
        int target = nums[0];
        for(int i=1; i<sz; i++) {
            if(nums[i] < target) {
                li = min(li, i);
                ri = max(ri, i);
            } else {
                target = nums[i];
            }
        }
        if(ri == -1) {
            return 0;
        }
        
        target = nums[sz-1];
        for(int i=sz-2; i>=0; i--) {
            if(nums[i] > target) {
                li = min(li, i);
                ri = max(ri, i);
            } else {
                target = nums[i];
            }
        }
        return ri-li+1;
    }
};
