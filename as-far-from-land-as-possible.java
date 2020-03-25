//Problem link: https://leetcode.com/problems/as-far-from-land-as-possible/submissions/

//Time complexity: O(m*n)
//Space complexity: O(m*n)

class Solution {
    public int maxDistance(int[][] grid) {
        Queue<int[]> q = new LinkedList();
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    q.add(new int[]{i, j, 0});
                    grid[i][j] = -1;
                }
            }
        }
        
        int[][] di = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        int res = -1;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i=0; i<4; i++) {
                int cr = cur[0] + di[i][0];
                int cc = cur[1] + di[i][1];
                if(cr>=0 && cr<grid.length && cc>=0 && cc<grid[0].length) {
                    if(grid[cr][cc] != -1) {
                        q.add(new int[]{cr,cc,cur[2]+1});
                        grid[cr][cc] = -1;
                        res = Math.max(res, cur[2]+1);
                    }
                }
            }
        }
        return res;
    }
}
