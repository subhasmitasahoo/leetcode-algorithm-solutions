//Problem link: https://leetcode.com/problems/game-of-life/solution/
//Time complexity: O(m*n)
//Space complexity: O(1)

class Solution {
    int rsz, csz;
    int[][] di = new int[][]{{-1,-1},{0,-1},{1,-1},{-1,0},{1,0},{-1,1},{0,1},{1,1}};
    private boolean isValidRow(int r) {
        return r>=0 && r<rsz;
    }
    
    private boolean isValidCol(int c) {
        return c>=0 && c<csz;
    }
    
    private int countNei(int[][] board, int r, int c) {
        int cnt = 0;
        for(int i=0; i<di.length; i++) {
            int ci = r+di[i][0];
            int cj = c+di[i][1];
            if(isValidRow(ci) && isValidCol(cj) && Math.abs(board[ci][cj]) == 1) {
                cnt++;
            }
        }
        return cnt;
    }
    
    public void gameOfLife(int[][] board) {
        rsz = board.length;
        if(rsz == 0) {
            return;
        }
        csz = board[0].length;
        
        if(csz == 0) {
            return;
        }
        
        for(int i=0; i<rsz; i++) {
            for(int j=0; j<csz; j++) {
                int cnt= countNei(board, i, j);
                if(board[i][j] == 1) {
                    if(cnt != 2 && cnt != 3) {
                        board[i][j] = -1;
                    }
                }
                if(board[i][j] == 0) {
                    if(cnt == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }
        
        for(int i=0; i<rsz; i++) {
            for(int j=0; j<csz; j++) {
                if(board[i][j] == -1) {
                    board[i][j] = 0;
                }
                if(board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
    
    }
}
