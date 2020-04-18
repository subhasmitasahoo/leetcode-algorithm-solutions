//Problem link: https://leetcode.com/problems/broken-calculator/
//Time complexity: O(log(Y/X))
//Space complexity: O(1)

//For better understanding: https://leetcode.com/problems/broken-calculator/discuss/234484/JavaC%2B%2BPython-Change-Y-to-X-in-1-Line

class Solution {
    public int brokenCalc(int X, int Y) {
        int cnt = 0;
        while(Y > X) {
            if(Y%2 != 0) {
                Y++;
                cnt++;
            } else {
                Y/=2;
                cnt++;
            }
        }
        return cnt + X-Y;
    }
}
