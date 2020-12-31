// Problem link: https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/
// Time complexity: O(m*n)
// Space complexity: O(n)

// Note: Can be done better with path compression, and maintaining size.

bool compareTs(vector<int> a, vector<int> b) {
    return a[0] < b[0];
}

class Solution {
public:
    
    int earliestAcq(vector<vector<int>>& logs, int N) {
        sort(logs.begin(), logs.end(), compareTs);
        int comp = N;
        
        vector<int> parent(N, -1);
        
        for(vector<int> log : logs) {
             connect(parent, log[1], log[2], comp);
            if(comp == 1) {
                return log[0];
            }
        }
        return -1;
    }
    
    void connect(vector<int> &parent, int s, int d, int &comp) {
        int ps = getParent(parent, s);
        int pd = getParent(parent, d);
        
        if(ps != pd) {
            parent[ps] = pd;
            comp--;
        }
    }
    
    int getParent(vector<int> parent, int node) {
        while(parent[node] != -1) {
            node = parent[node];
        }
        return node;
    }
};
