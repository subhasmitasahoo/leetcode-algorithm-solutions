// Problem link: https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/
// Time complexity: O(m*n)
// Space complexity: O(1)

class Solution {
    unordered_map<int, pair<char, char>> numToDir;
    unordered_map<char, unordered_set<char>> dirToNum;
    unordered_map<char, int> complement;
    unordered_map<char, pair<int, int>> dirMove;
public:
    bool hasValidPath(vector<vector<int>>& grid) {
        numToDir[1] = {'l', 'r'};
        numToDir[2] = {'t', 'b'};
        numToDir[3] = {'l', 'b'};
        numToDir[4] = {'r', 'b'};
        numToDir[5] = {'t', 'l'};
        numToDir[6] = {'t', 'r'};
        
        dirToNum['t'] = {2, 5, 6};
        dirToNum['b'] = {2, 3, 4};
        dirToNum['l'] = {1, 3, 5};
        dirToNum['r'] = {1, 4, 6};
        
        complement['l'] = 'r';
        complement['t'] = 'b';
        complement['b'] = 't';
        complement['r'] = 'l';
        
        dirMove['l'] = {0, -1};
        dirMove['t'] = {-1, 0};
        dirMove['b'] = {1, 0};
        dirMove['r'] = {0, 1};
        
        return isValidPath(grid, numToDir[grid[0][0]].first) ? true: isValidPath(grid, numToDir[grid[0][0]].second);
    }
    
    bool isValidPath(vector<vector<int>> grid, char curDir) {
        int cr = 0, cc = 0;
        int rsz = grid.size();
        int csz = grid[0].size();
        
        while(true) {
            if(cr == rsz-1 && cc == csz-1) {
                return true;
            }
            auto dir = numToDir[grid[cr][cc]];
            char nextDir = dir.first == curDir ? dir.second : dir.first;
            int nr = cr + dirMove[nextDir].first;
            int nc = cc + dirMove[nextDir].second;
            grid[cr][cc] = -1;

            if(nr>=0 && nc>=0 && nr<rsz && nc<csz && grid[nr][nc] != -1) {
                if(dirToNum[complement[nextDir]].find(grid[nr][nc]) != dirToNum[complement[nextDir]].end()) {
                    curDir = complement[nextDir];
                    cr = nr;
                    cc = nc;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        return false;
    }
};
