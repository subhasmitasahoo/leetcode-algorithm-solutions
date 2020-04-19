//Problem link: https://leetcode.com/problems/camelcase-matching/
//Time complexity: O(Sum(si_len))
//Space complexity: O(len)

class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList();
        
        for(String q: queries) {
            int index = 0;
            boolean res = true;
            int i;
            for(i=0; i<q.length(); i++) {
                if(index == pattern.length()) {
                    break;
                }
                if(q.charAt(i) == pattern.charAt(index)) {
                    index++;
                    continue;
                } else {
                    if(Character.isUpperCase(q.charAt(i))) {
                        res = false;
                        break;
                    }
                }
            }
            if(index<pattern.length()) {
                res = false;
            }
            for(;i<q.length() && res; i++) {
                if(Character.isUpperCase(q.charAt(i))) {
                    res = false;
                    break;
                }
            }
            ans.add(res);
        }
        return ans;
    }
}
