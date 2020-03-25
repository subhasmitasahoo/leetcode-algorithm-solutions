//Problem link: https://leetcode.com/problems/arithmetic-slices/

//Time complexity: O(n)
//Space complexity: O(n)

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int len = A.length;
        if(len < 3) {
            return 0;
        }
        int[] dp = new int[len];
        
        int res = 0;
        
        for(int i=2; i<len; i++) {
            if(A[i] - A[i-1] == A[i-1] - A[i-2]) {
                dp[i] = 1 + dp[i-1];
            }
            res += dp[i];    
        }
        return res;
    }
}
