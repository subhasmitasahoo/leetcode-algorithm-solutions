//Problem link: https://leetcode.com/problems/bulb-switcher-ii/
//Time complexity: O(1)
//Space complexity: O(1)

class Solution {
    public int flipLights(int n, int m) {
        if(n==0) {
            return 0;
        }
        if(m==0) {
            return 1;
        }
        if(n==1) {
            return 2;
        }
        if(n==2) {
            return m==1?3:4;
        }
        return m==1?4:(m==2?7:8);
    }
}
