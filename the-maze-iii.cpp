// Problem link: https://leetcode.com/problems/the-maze-iii/
// Time complexity: TODO
// Space complexity: O(m*n)

// TODO: Bad code!!! Make it concise.

class Solution {
    struct Direction {
        int dx;
        int dy;
        string name;
    }; 
public:
    string findShortestWay(vector<vector<int>>& maze, vector<int>& ball, vector<int>& hole) {
        if(ball[0]==hole[0] && ball[1]==hole[1]) {
            return "";
        }
        return bfs(maze, ball, hole);
    }
    
    string bfs(vector<vector<int>>& maze, vector<int> start, vector<int> destination) {
        queue<vector<int>> temp;
        vector<vector<int>> visited(maze.size(), vector<int>(maze[0].size(), INT_MAX));
        vector<vector<string>> dirName(maze.size(), vector<string>(maze[0].size(), ""));
        struct Direction dir[4] = {{0,-1, "l"},{-1,0, "u"},{1,0, "d"},{0,1, "r"}};

        string res = "";
        int track = -1;
        
        temp.push(vector<int>{start[0], start[1], 0});
        visited[start[0]][start[1]] = 0;
        dirName[start[0]][start[1]] = "";
        
        while(!temp.empty()) {
            vector<int> cur = temp.front();
            string cdir = dirName[cur[0]][cur[1]];
            temp.pop();
            
            for(int i=0; i<4; i++) {
                int x = cur[0];
                int y = cur[1];
                string newDir = cdir + dir[i].name;
                int ctrack = visited[x][y];
                
                bool isHoleOnPath = false;
                while(!isOutside(x+dir[i].dx, y+dir[i].dy, maze.size(), maze[0].size()) && maze[x+dir[i].dx][y+dir[i].dy] == 0) {
                    x += dir[i].dx;
                    y += dir[i].dy;
                    ctrack++;
                    if(x==destination[0] && y==destination[1]) {
                        if(res == "" || (ctrack<track || (ctrack==track && newDir < res))) {
                            res = newDir;
                            track = ctrack;
                        }
                        isHoleOnPath = true;
                        break;
                    }
                }
                
                if(!isHoleOnPath && (visited[x][y] > ctrack || (visited[x][y] == ctrack && dirName[x][y] > newDir))) {
                    visited[x][y] = ctrack;
                    temp.push(vector<int>{x, y});
                    dirName[x][y] = newDir;
                    //cout<<x<<" "<<y<<" "<<newDir<<endl;
                }   
        }
    }
        return res != "" ? res:"impossible";
    }
    
    bool isOutside(int x, int y, int xsz, int ysz) {
        return (x<0 || x==xsz) || (y<0 || y==ysz);
    }
};
