//Problem link: https://leetcode.com/problems/binary-prefix-divisible-by-5/submissions/

//Time complexity: O(n)
//Space complexity: O(1) - excluding the result
class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList();
        
        int cur = 0;
        
        for(int a: A) {
            cur = (cur*2 + a)%5;
            if(cur == 0) {
                res.add(true);
                continue;
            }
            res.add(false);
        }
        
        return res;
    }
}
