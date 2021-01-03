// Problem link: https://leetcode.com/problems/spiral-matrix/submissions/
// Time complexity: O(m*n)
// Space complexity: O(1)

class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        vector<int> res;
        
        int rsz = matrix.size();
        if(rsz == 0) {
            return res;
        }
        int csz = matrix[0].size();
        if(csz == 0) {
            return res;
        }
        
        int tr = 0, br = rsz-1, lc = 0, rc = csz-1;
        
        while(tr<=br && lc <= rc) {
            getSpiralOrderOfLayer(matrix, res, tr, br, lc, rc);
            tr += 1;
            br -= 1;
            lc += 1;
            rc -= 1;
        }
        return res;
    }
    
    void getSpiralOrderOfLayer(vector<vector<int>> matrix, vector<int>& res, int tr, int br, int lc, int rc) {
        for(int i=lc; i<=rc; i++) {
            res.push_back(matrix[tr][i]);
        }
        for(int i=tr+1; i<=br; i++) {
            res.push_back(matrix[i][rc]);
        }
        for(int i=rc-1; i>=lc && tr < br; i--) {
            res.push_back(matrix[br][i]);
        }
        for(int i=br-1; i>tr && lc < rc; i--) {
            res.push_back(matrix[i][lc]);
        }
    }
};
