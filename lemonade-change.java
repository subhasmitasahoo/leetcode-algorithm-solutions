//Problem link: https://leetcode.com/problems/lemonade-change/
//Time complexity: O(n)
//Space complexity: O(1)

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int rem10 = 0, rem5 = 0;
        
        for(int b: bills) {
            if(b==5) {
                rem5++;
            }
            else if(b==10) {
                if(rem5 == 0) {
                    return false;
                }
                rem5--;
                rem10++;
            } else {
                if(rem10>0 && rem5>0) {
                    rem10--;
                    rem5--;
                } else if(rem5>=3) {
                    rem5-=3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
