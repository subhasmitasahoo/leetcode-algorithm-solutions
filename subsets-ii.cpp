// Problem link: https://leetcode.com/problems/subsets-ii/submissions/
// Time complexity: O(N*2^N)
// Space complexity: O(N*2^N)

class Solution {
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
      sort(nums.begin(), nums.end());
      vector<vector<int>> res;
      traverse(nums, res, 0);
      return res;
    }
    
    void traverse(vector<int> nums, vector<vector<int>>& res, int index) {
        if(index == nums.size()) {
            res.push_back(vector<int>{});
            return;
        }
        
        int j = index+1;
        while(j < nums.size() && nums[j] == nums[index]) {
            j++;
        }
        traverse(nums, res, j);
            
        int sz = res.size();
        
        for(int i=0; i<sz; i++) {
            vector<int> temp = res[i];
            for(int k=index; k<j; k++) {
                temp.push_back(nums[index]);
                res.push_back(temp);
            }
        }
    }
};
