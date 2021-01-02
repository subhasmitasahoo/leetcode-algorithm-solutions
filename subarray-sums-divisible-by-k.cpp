// Problem link: https://leetcode.com/problems/subarray-sums-divisible-by-k/
// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
public:
    int subarraysDivByK(vector<int>& A, int K) {
        unordered_map<int, int> tracker;
        tracker[0] = 1;
        
        int sum = 0;
        int res = 0;
        
        for(int a: A) {
            //Careful of negative numbers.
            sum = ((sum+a)%K +K)%K;
            if(tracker.find(sum) != tracker.end()) {
                res += tracker[sum];        
            }
            tracker[sum]++;
        }
        return res;
    }
};
