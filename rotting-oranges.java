//Problem link: https://leetcode.com/problems/rotting-oranges/solution/
//Time complexity: O(n), n-sizeof grid
//Space complexity: O(n), n-size of grid

class Solution {
    public int orangesRotting(int[][] grid) {
        int rsz = grid.length;
        if(rsz == 0) {
            return 0;
        }
        int csz = grid[0].length;
        if(csz == 0) {
            return 0;
        }        
        Queue<int[]> q = new LinkedList();
        for(int i=0; i<rsz; i++) {
            for(int j=0; j<csz; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }
        int[][] di = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int maxi = 0;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int k=0; k<4; k++) {
                int ci = cur[0] + di[k][0];
                int cj = cur[1] + di[k][1];
                if(ci>=0 && ci<rsz && cj>=0 && cj<csz && grid[ci][cj] == 1)                             {
                    q.add(new int[]{ci, cj});
                    grid[ci][cj] = grid[cur[0]][cur[1]] + 1;
                    maxi = Math.max(maxi, grid[ci][cj]-2);
                }
            }
        }
        
        for(int i=0; i<rsz; i++) {
            for(int j=0; j<csz; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        
        return maxi;
    }
}
