// Problem link: https://leetcode.com/problems/subsets/
// Time complexity: O(N*2^N)
// Space complexity: O(N*2^N)

class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> res;
        traverse(nums, res, 0);
        return res;
    }
    
    void traverse(vector<int> nums, vector<vector<int>>& res, int index) {
        if(index == nums.size()) {
            res.push_back(vector<int>{});
            return;
        }
        
        traverse(nums, res, index+1);
            
        int sz = res.size();
        for(int i=0; i<sz; i++) {
            vector<int> temp = res[i];
            temp.push_back(nums[index]);
            res.push_back(temp);
        }
    }
};
