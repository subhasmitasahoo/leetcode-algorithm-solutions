// Problem link: https://leetcode.com/problems/circular-array-loop/
// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
    int sz;
public:
    bool circularArrayLoop(vector<int>& nums) {
        sz = nums.size();
        if(sz ==0) {
            return false;
        }
        vector<int> vis(sz, 0);
        // 0 - Not visited
        // 1 - current loop
        // 2 - visited in a different loop
        
        for(int i=0; i<sz; i++) {
            if(!vis[i]) {
                if(checkLoop(nums, vis, i)) {
                    return true;
                }
                markVisit(nums, vis, i);
            }
        }
        return false;
    }
    
    bool checkLoop(vector<int> nums, vector<int>& vis, int i) {
        int cur = i;
        bool posDir = nums[cur] > 0;
        do {
            if(vis[cur] == 1) {
                return true;
            }
            //cout<<cur<<endl;
            vis[cur] = 1;
            int next = ((cur+nums[cur])%sz + sz)%sz;
            if(next == cur || (posDir != (nums[next]>0)) || vis[next]==2) {
                break;
            }
            cur = next;
        } while(true); 
        return false;
    }
    
    //This can be merged with the checkLoop method.  
    void markVisit(vector<int> nums, vector<int>& vis, int i) {
        int cur = i;
        bool posDir = nums[cur] > 0;
        do {
            vis[cur] = 2;
            int next = ((cur+nums[cur])%sz + sz)%sz;
            if(next == cur || (posDir != (nums[next]>0)) || vis[next]==2) {
                break;
            }
            cur = next;
        } while(true); 
    }
};
