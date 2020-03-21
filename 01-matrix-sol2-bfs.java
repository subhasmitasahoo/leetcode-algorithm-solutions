//Time complexity: O(r*c)
//Space complexity: O(r*c)

//BFS solution
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int rlen = matrix.length;
        int clen = matrix[0].length;
        
        int[][] res = new int[rlen][clen];
        
        for(int i=0; i<rlen; i++) {
            Arrays.fill(res[i], 10001);
        }
        
        Queue<int[]> q = new LinkedList();
        
        
        for(int i=0; i<rlen; i++) {
            for(int j=0; j<clen; j++) {
                if(matrix[i][j] == 0) {
                    q.add(new int[]{i, j, 0});
                    res[i][j] = 0;
                }
            }
        }
        
        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i=0; i<4; i++) {
                int ni = cur[0] + dir[i][0];
                int nj = cur[1] + dir[i][1];
                if(ni>=0 && ni<rlen && nj>=0 && nj<clen) {
                    if(res[ni][nj] > cur[2]+1) {
                        res[ni][nj] = cur[2]+1;
                        q.add(new int[]{ni, nj, cur[2]+1});
                    }
                }
            }
        }
        
        return res;
    }
}

