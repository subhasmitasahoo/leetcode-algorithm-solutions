// Problem link: https://leetcode.com/problems/max-area-of-island/
// Time complexity: O(m*n)
// Space complexity: O(1) 

class Solution {
    int rsz, csz;
public:
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int res = 0;
        
        rsz = grid.size();
        if(rsz == 0) {
            return 0;
        }
        csz = grid[0].size();
        if(csz == 0)  {
            return 0;
        }
        for(int i=0; i<rsz; i++) {
            for(int j=0; j<csz; j++) {
                if(grid[i][j] == 1) {
                    res = max(res, bfs(grid, i, j));
                }
            }
        }
        return res;
    }
    
    int bfs(vector<vector<int>>& grid, int r, int c) {
        queue<pair<int, int>> q;
        q.push({r,c});
        int ans = 1;
        grid[r][c] = 0;
        
        int dir[4][2] = {{-1,0},{1,0},{0,1},{0,-1}};
        
        while(!q.empty()) {
            int cr = q.front().first;
            int cc = q.front().second;
            q.pop();
            for(int i=0; i<4; i++) {
                int tr = cr + dir[i][0];
                int tc = cc + dir[i][1];
                if(isValid(tr, tc) && grid[tr][tc] == 1) {
                    ans++;
                    grid[tr][tc] = 0;
                    q.push({tr,tc});
                }
            }
        }
        return ans;
    }
    bool isValid(int r, int c) {
        return r>=0 && r<rsz && c>=0 && c<csz;
    }
};
