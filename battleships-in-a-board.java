//Probleem link: https://leetcode.com/problems/battleships-in-a-board/
//Time complexity: O(m*n)
//Space complexity: O(1)

class Solution {
    int rlen, clen;
    public int countBattleships(char[][] board) {
        int res = 0;
        rlen = board.length;
        clen = board[0].length;
        
        for(int i=0; i<rlen; i++) {
            for(int j=0; j<clen; j++) {
                res += isValid(board, i, j) ? 1 : 0; 
            }
        }
        
        return res;
    }
    
    private boolean isValid(char[][] b, int r, int c) {
        if(b[r][c] == '.') {
            return false;
        }
        int[][] di = new int[][]{{-1,0},{0,-1}};
        
        for(int i=0; i<2; i++) {
            int nr = r + di[i][0];
            int nc = c + di[i][1];
            if(nr>=0 && nr<rlen && nc>=0 && nc<clen) {
                if(b[nr][nc] == 'X') {
                    return false;
                }
            }
        }
        return true;
    }
}
