// Problem statement: https://leetcode.com/problems/flood-fill/
// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        int rsz = image.size();
        if(rsz == 0) {
            return image;
        }
        int csz = image[0].size();
        if(csz == 0) {
            return image;
        }
        if(image[sr][sc] == newColor) {
            return image;
        }
        queue<pair<int, int>> q;
        int oc = image[sr][sc];
        image[sr][sc] = newColor;
        q.push({sr, sc});
        
        int di[4][2] = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.empty()) {
            pair<int, int> top = q.front();
            q.pop();
            for(int i=0; i<4; i++) {
                int tr = top.first + di[i][0];
                int tc = top.second + di[i][1];
                if(tr>=0 && tc>=0 && tr<rsz && tc<csz && image[tr][tc] == oc) {
                    image[tr][tc] = newColor;
                    q.push({tr, tc});
                }
            }
        }
        return image;
    }
};
