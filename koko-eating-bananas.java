//Probleem link: https://leetcode.com/problems/koko-eating-bananas/

//Time complexity: O(nlog(maax-min))
//Space complexity: O(1)

class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int l = 1;
        
        int h = 0;
        for(int p: piles) {
            h = Math.max(h, p);
        }
        
        int res = h;
        while(l<=h) {
            int m = l + (h-l)/2;
            
            if(canEat(piles, m, H)) {
                res = m;
                h = m-1;
            } else {
                l = m+1;
            }
        }
        return res;
    }
    
    private boolean canEat(int[] piles, int speed, int hr) {
        
        int cur = 0;
        for(int p: piles) {
            cur += Math.ceil(p*1.0/speed);
        }
        return cur <= hr;
    }
}
