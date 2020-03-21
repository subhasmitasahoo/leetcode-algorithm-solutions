//Time complexity: O(r*c)
//Space complexity: O(r*c)

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int rlen = matrix.length;
        int clen = matrix[0].length;
        
        int[][] res = new int[rlen][clen];
        
        for(int i=0; i<rlen; i++) {
            Arrays.fill(res[i], 10001);
        }
        
        
        for(int i=0; i<rlen; i++) {
            for(int j=0; j<clen; j++) {
                if(matrix[i][j] == 0) {
                    res[i][j] = 0;
                    continue;
                }
                if(i-1 >= 0) {
                    res[i][j] = Math.min(res[i][j], 1+res[i-1][j]);  
                }
                if(j-1 >= 0) {
                    res[i][j] = Math.min(res[i][j], 1+res[i][j-1]);  
                }
            }
        }
        
        for(int i=rlen-1; i>=0; i--) {
            for(int j=clen-1; j>=0; j--) {
                if(matrix[i][j] == 0) {
                    res[i][j] = 0;
                    continue;
                }
                if(i+1 < rlen) {
                    res[i][j] = Math.min(res[i][j], 1+res[i+1][j]);  
                }
                if(j+1 < clen) {
                    res[i][j] = Math.min(res[i][j], 1+res[i][j+1]);  
                }
            }
        }
        
        return res;
    }
}

