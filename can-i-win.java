//Problem link: https://leetcode.com/problems/can-i-win/
//Time complexity: Exponential 
//Space complexity: Exponential

class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal <= maxChoosableInteger) {
            return true;
        }
        if(desiredTotal > maxChoosableInteger*(maxChoosableInteger+1)/2) {
            return false;
        }
        int[] memo = new int[1<<maxChoosableInteger+1];
        boolean[] vis = new boolean[maxChoosableInteger+1];
        return traverse(maxChoosableInteger, desiredTotal, memo, 0, vis);
    }
    
    private boolean traverse(int maxi, int tot, int[] memo, int id, boolean[] vis) {
        if(tot <= 0) {
            return false;
        }
        if(memo[id] != 0) {
            return memo[id]==1;
        }
        
        for(int i=1; i<=maxi; i++) {
            if(!vis[i]) {
                vis[i] = true;
                if(!traverse(maxi, tot-i, memo, id|1<<i, vis)) {
                    memo[id] = 1;
                    vis[i] = false;
                    return true;
                }
                vis[i] = false;
            }
        }
        memo[id] = 2;
        return false;
    }
}
