//Problem link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/

//Time complexity: O(n)
//Space complexity: O(1)

class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len == 0) {
            return 0;
        }
        
        int mini = prices[0];
        int res = 0;
        
        for(int p: prices) {
            res = Math.max(res, p-mini);
            mini = Math.min(mini, p);
        }
        
        return res;
    }
}
