// Problem link: https://leetcode.com/problems/minimum-knight-moves/submissions/
// Time complexity: O(X*Y)
// Space complexity: O(X*Y)

class Solution {
public:
    int minKnightMoves(int x, int y) {
        x = abs(x);
        y = abs(y);
        
        if(x==0 && y==0 || x==1 && y==1) {
            return x+y;
        }
        queue<pair<int,int>> temp;
        temp.push({0,0});
        unordered_map<int, unordered_map<int,int>> vis;
        vis[0][0] = 1;
        
        int di[8][2] = {{1,2},{1,-2},{-1,2},{-1,-2},{2,1},{-2,1},{2,-1},{-2,-1}};
        int dist = 0;
        
        while(!temp.empty()) {
            int sz = temp.size();
            for(int j=0; j<sz; j++) {
                auto cur = temp.front();
                temp.pop();
                for(int i=0; i<8; i++) {
                    int ti = cur.first + di[i][0];
                    int tj = cur.second + di[i][1];

                    if(!isValid(ti,tj)) {
                        continue;
                    }

                    if(ti == x && tj == y) {
                        return dist + 1;
                    }
                    if(vis[ti][tj] != 1) {
                        vis[ti][tj] = 1;
                        temp.push({ti, tj});
                    }
                }
            }
            dist++;
        }
        return -1;
    }
    
    bool isValid(int x, int y) {
        return x>=0 && y>=0;
    }
};
