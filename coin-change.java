//Problem link: https://leetcode.com/problems/coin-change/submissions/
//Time complexity: O(n*ans)
//Space complexity: O(max(n,amount)) - Not sure

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        if(amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        
        Queue<int[]> q = new LinkedList();
        Set<Integer> vis = new HashSet();
        
        for(int i=coins.length-1; i>=0; i--) {
            if(coins[i] == amount) {
                return 1; 
            } 
            q.add(new int[]{coins[i], 1});
            vis.add(coins[i]);
        }
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i=coins.length-1; i>=0; i--) {
                int val = cur[0]+coins[i];
                if(vis.contains(val)) {
                    continue;
                }
                if(val == amount) {
                    return cur[1]+1; 
                } 
                 vis.add(val);
                if(val < amount) {
                    q.add(new int[]{val, cur[1]+1});
                }
            }
        }
        return -1;
    }
}
