//Problem link: https://leetcode.com/problems/beautiful-arrangement/
//Time complexity: O(no. of permutations)
//Space complexity: O(n)

class Solution {
    int res = 0;
    public int countArrangement(int N) {
        boolean[] vis = new boolean[N+1];
        traverse(1, N, vis);
        return res;
    }
    
    private void traverse(int ind, int sz, boolean[] vis) {
        if(ind > sz) {
            res++;
            return;
        }
        
        for(int i=1; i<=sz; i++) {
            if(vis[i])
                continue;
            if(ind%i == 0 || i%ind == 0) {
                vis[i] = true;
                traverse(ind+1, sz, vis);
                vis[i] = false;
            }
        }
    }
}
