// Problem link: https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/submissions/
// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
public:
    int maxSubArrayLen(vector<int>& nums, int k) {
        unordered_map<int, int> cnt;
        
        int sum = 0;
        cnt[0] = -1;
        int res = 0;
        for(int i=0; i<nums.size(); i++) {
            sum += nums[i];
            if(cnt.find(sum-k) != cnt.end()) {
                res = max(res, i-cnt[sum-k]);
            }
            if(cnt.find(sum) == cnt.end()) {
                cnt[sum] = i;
            } 
        }
        return res;
    }
};
