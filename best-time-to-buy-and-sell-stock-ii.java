//Problem link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solution/

//Time complexity: O(n)
//Space complexity: O(1)

class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        if(prices.length <= 1) {
            return 0;
        }
        
        int mini = prices[0];
        int cur = 0;
        
        for(int i=1; i<prices.length; i++) {
            if(prices[i]<prices[i-1]) {
                res += cur;
                cur = 0;
                mini = prices[i];
            } else {
                cur = prices[i]-mini;
            }
        }
        res += cur;
        return res;
    }
}
