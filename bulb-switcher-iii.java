//Problem link: https://leetcode.com/problems/bulb-switcher-iii/submissions/
//Time complexity: O(n)
//Space complexity: O(1)

class Solution {
    public int numTimesAllBlue(int[] light) {
        int maxi = 0;
        int res = 0;
        
        for(int i=0; i<light.length; i++) {
            if(light[i]>maxi) {
                maxi = light[i];
            }
            if(maxi == i+1) {
                res++;
            }
        }
        return res;
    }
}
