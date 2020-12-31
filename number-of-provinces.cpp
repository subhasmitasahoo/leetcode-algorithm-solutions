// Problem link: https://leetcode.com/problems/number-of-provinces/submissions/
// Time complexity: O(n^3)
// Space complexity: O(n)

// Note: Time complexity can be improved with path compression and by maintaining size information. 
// Too lazy to do it!

class Solution {
public:
    int findCircleNum(vector<vector<int>>& isConnected) {
        int n = isConnected.size();
        vector<int> parent(n, -1);
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(isConnected[i][j] == 1) {
                   connect(parent, i, j);
                }
            }
        }
        
        int cnt = 0;
        for(int i=0; i<n; i++) {
            if(parent[i] == -1) {
                cnt++;
            }
        }
        return cnt;
    }
    
    void connect(vector<int> &parent, int s, int d) {
        int ps = getParent(parent, s);
        int pd = getParent(parent, d);
        
        if(ps != pd) {
            parent[ps] = pd;
        }
    }
    
    int getParent(vector<int> parent, int node) {
        while(parent[node] != -1) {
            node = parent[node];
        }
        return node;
    }
};
