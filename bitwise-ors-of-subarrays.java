//Problem link: https://leetcode.com/problems/bitwise-ors-of-subarrays/solution/
//Time compleexity: O(Nlog(max(Ai)))
//Space complexity: O(N)

class Solution {
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> cur = new HashSet();
        Set<Integer> res = new HashSet();
        
        for(int a: A) {
            Set<Integer> temp = new HashSet();
            for(int c: cur) {
                temp.add(c | a);
            }
            temp.add(a);
            res.addAll(temp);
            cur = temp;
        }
        return res.size();
    }
}
