// Problem link: https://leetcode.com/problems/word-search/
// Time complexity: O(N.(3^L))
// Space complexity: O(L)

class Solution {
    int rsz = -1;
    int csz = -1;
    vector<vector<int>> di = {{0,1},{0,-1},{1,0},{-1,0}};
public:
    bool exist(vector<vector<char>>& board, string word) {
        rsz = board.size();
        csz = board[0].size();
        vector<vector<bool>> state(rsz, vector<bool>(csz, false));
        
        for(int i=0; i<rsz; i++) {
            for(int j=0; j<csz; j++) {
                if(board[i][j] == word[0]) {
                    if(backtrack(board, i, j, word, 1, state)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    bool backtrack(vector<vector<char>> board, int r, int c, string word, int index, vector<vector<bool>>& state) {
        if(index >= word.length()) {
            return true;
        }
        state[r][c] = true;
        for(int i=0; i<di.size(); i++) {
            int cr = r + di[i][0];
            int cc = c + di[i][1];
            if(cr>=0 && cc>=0 && cr<rsz && cc<csz) {
                if(!state[cr][cc] && board[cr][cc] == word[index] && backtrack(board, cr, cc, word, index+1, state)) {
                    return true;
                }
            }
        }
        state[r][c] = false;
        return false;
    }
};
