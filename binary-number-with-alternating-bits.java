//Problem link: https://leetcode.com/problems/binary-number-with-alternating-bits/
//Time complexity: O(logn)
//Space complexity: O(1)

class Solution {
    public boolean hasAlternatingBits(int n) {
        int cur = n%2;
        n/=2;
        
        while(n>0) {
            if(n%2 == cur)
                return false;
            n/=2;
        }
        return true;
    }
}
