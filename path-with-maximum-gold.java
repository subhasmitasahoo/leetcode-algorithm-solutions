//Problem link: https://leetcode.com/problems/path-with-maximum-gold/
//Time complexity: O(n^4)
//Space complexity: O(n*n)

class Solution {
    
    int ans = 0;
    boolean[][] vis;
    
    public int getMaximumGold(int[][] grid) {
        int rlen = grid.length;
        int clen = grid[0].length;
        vis = new boolean[rlen][clen];
        
        for(int i=0; i<rlen; i++) {
            for(int j=0; j<clen; j++) {
                if(grid[i][j] > 0) {
                    dfs(grid, i, j, 0);
                }
            }
        }
        return ans;
    }
    
    private void dfs(int[][] grid, int r, int c, int sum) {
        if(vis[r][c]) {
            return;
        }
        vis[r][c] = true;
        sum += grid[r][c];
        ans = Math.max(ans, sum);
        
        if(r-1>=0 && grid[r-1][c] > 0) {
            dfs(grid, r-1, c, sum);
        }
        if(r+1 < grid.length && grid[r+1][c] > 0) {
            dfs(grid, r+1, c, sum);
        }
        if(c-1>=0 && grid[r][c-1] > 0) {
            dfs(grid, r, c-1, sum);
        }
        if(c+1 < grid[0].length && grid[r][c+1] > 0) {
            dfs(grid, r, c+1, sum);
        }
        vis[r][c] = false;
    }
}
