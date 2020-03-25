//Problem link: https://leetcode.com/problems/angle-between-hands-of-a-clock/submissions/

//Time complexity: O(1)
//Space complexity: O(1)

class Solution {
    public double angleClock(int hour, int minutes) {
        double hn = hour%12;
        hn *= 5;
        double mn = minutes;
        
        hn += (minutes/12.0);
                
        double res = Math.abs(hn-mn);
        res = Math.min(res, 60-res);
        return res*6;
    }
}
