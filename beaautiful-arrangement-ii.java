//Problem link: https://leetcode.com/problems/beautiful-arrangement-ii/submissions/
//Time complexity: O(n)
//Space complexity: O(1) - excluding result

class Solution {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        for(int i=1; i<n-k; i++) {
            res[i-1] = i;
        }
        
        int first = n-k;
        int last = n; 
        for(int i=n-k; i<=n; i++) {
            res[i-1] = (i-n+k)%2==0 ? first++ : last--;
        }
        return res;
    }
}
