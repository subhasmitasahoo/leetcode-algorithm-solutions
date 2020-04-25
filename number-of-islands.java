//Problem link: https://leetcode.com/problems/number-of-islands/solution/
//Time complexity: O(m*n)
//Space complexity: O(linear(m,n)) - not sure, didnt think about it

class Solution {
    public int numIslands(char[][] grid) {
        int rsz = grid.length;
        if(rsz == 0) {
            return 0;
        }
        int csz = grid[0].length;
        if(csz == 0) {
            return 0;
        }
        
        int res = 0;
        int[][] di = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int i=0; i<rsz; i++) {
            for(int j=0; j<csz; j++) {
                if(grid[i][j] == '1') {
                    res++;
                    Queue<int[]> q = new LinkedList();
                    q.add(new int[]{i, j});
                    grid[i][j] = '0';
                    while(!q.isEmpty()) {
                        int[] cur = q.poll();
                        for(int k=0; k<4; k++) {
                            int ci = cur[0] + di[k][0];
                            int cj = cur[1] + di[k][1];
                            if(ci>=0 && ci<rsz && cj>=0 && cj<csz && grid[ci][cj] == '1')                             {
                                q.add(new int[]{ci, cj});
                                grid[ci][cj] = '0';
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
