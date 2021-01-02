// Problem link: https://leetcode.com/problems/make-sum-divisible-by-p/
// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
public:
    int minSubarray(vector<int>& nums, int p) {
        int totMod = 0;
        unordered_map<int, int> tracker;
        tracker[0] = -1;
        
        for(int n: nums) {
            totMod = (totMod+n)%p;
        }
        if(totMod == 0) {
            return 0;
        } 
        
        int cur = 0;
        int res = nums.size();
        
        for(int i=0; i<nums.size(); i++) {
            cur = (cur+nums[i])%p;
            int search = (cur-totMod+p)%p;
            if(tracker.find(search) != tracker.end()) {
                res = min(res, i-tracker[search]);        
            }
            tracker[cur] = i;
        }
        return res==nums.size() ? -1 : res;
    }
};
