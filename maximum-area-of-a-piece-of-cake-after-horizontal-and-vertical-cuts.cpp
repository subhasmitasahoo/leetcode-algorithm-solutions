// Problem link: https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
// Time complexity: O(nlogn)
// Space complexity: O(1), not considering space taken for sorting

class Solution {
public:
    int maxArea(int h, int w, vector<int>& horizontalCuts, vector<int>& verticalCuts) {
        long long mod = 1000000007;
        sort(horizontalCuts.begin(), horizontalCuts.end());
        sort(verticalCuts.begin(), verticalCuts.end());
        
        long long mh = horizontalCuts[0];
        long long mw = verticalCuts[0];
        int hsz = horizontalCuts.size();
        int wsz = verticalCuts.size();
        
        for(int i=1; i<hsz; i++) {
            mh = max(mh, (long long)(horizontalCuts[i] - horizontalCuts[i-1]));
        }
        mh = max(mh, (long long)(h-horizontalCuts[hsz-1]));
        
        for(int i=1; i<wsz; i++) {
            mw = max(mw, (long long)(verticalCuts[i] - verticalCuts[i-1]));
        }
        mw = max(mw, (long long)(w-verticalCuts[wsz-1]));
        
        return (mh*mw)%mod;
        
    }
};
