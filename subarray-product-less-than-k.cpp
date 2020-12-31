// Problem link: https://leetcode.com/problems/subarray-product-less-than-k/
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
public:
    int numSubarrayProductLessThanK(vector<int>& nums, int k) {
        int start = 0, end = 0;
        
        int cur = 1, res = 0;
        while(end < nums.size()) {
            cur *= nums[end];
            while(start <= end && cur >= k) {
                cur /= nums[start];
                start++;
            }
            res += max(0, end-start+1);
            end++;
            }
        return res;
    }
};
