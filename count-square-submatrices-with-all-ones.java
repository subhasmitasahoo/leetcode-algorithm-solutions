//Problem link: https://leetcode.com/problems/count-square-submatrices-with-all-ones/
//Time complexity: O(m*n)
//Space complexity: O(1) - considering write operation in the matrix is allowed

class Solution {
    public int countSquares(int[][] matrix) {
        int rlen = matrix.length;
        int clen = matrix[0].length;
        
        for(int i=1; i<rlen; i++) {
            for(int j=1; j<clen; j++) {
                if(matrix[i][j] == 0) {
                    continue;
                }
                matrix[i][j] = Math.min(matrix[i-1][j], Math.min(matrix[i][j-1],matrix[i-1][j-1])) + 1;
            }
        }
        
        int res = 0;
        
        for(int i=0; i<rlen; i++) {
            for(int j=0; j<clen; j++) {
                res += matrix[i][j];   
            }
        }
        return res;
    }
}
