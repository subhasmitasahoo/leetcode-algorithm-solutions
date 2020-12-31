// Problem link: https://leetcode.com/problems/subarray-sum-equals-k/
// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        unordered_map<int, int> sumTillNow;
        
        int sum = 0;
        int res = 0;
        
        for(int n: nums) {
            sum += n;
            if(sum == k) {
                res++;
            }
            if(sumTillNow.find(sum-k) != sumTillNow.end()) {
                res += sumTillNow[sum-k];
            }
            sumTillNow[sum]++;
            
        }
        return res;
    }
};
