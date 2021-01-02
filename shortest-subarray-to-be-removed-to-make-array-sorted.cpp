// Problem link: https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/
// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
public:
    int findLengthOfShortestSubarray(vector<int>& arr) {
        int sz = arr.size();
        int l = 0;
        while(l<sz) {
            if(l==sz-1 || arr[l]<=arr[l+1]) {
                l++;
            } else {
                break;
            }
        }
        if(l==sz) {
            return 0;
        }
        int res = l+1;
        
        int r = sz-1;
        while(r>=0) {
            if(r==0 || arr[r]>=arr[r-1]) {
                r--;
            } else {
                break;
            }
        }
        res = max(res, sz-r);
        
        int j = sz-1;
        while(l>=0) {
            while(j>=r && arr[j] >= arr[l]) {
                j--;
            }
            if(j!=sz-1 && arr[j+1] >= arr[l]) {
                res = max(res, l+sz-j);
            } 
            l--;
        }
        return sz-res;
    }
};
