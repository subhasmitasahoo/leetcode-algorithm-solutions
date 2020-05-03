//Problem link: https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
//Time complexity: O(n)
//Space complexity: O(n)

class Solution {
    public String minRemoveToMakeValid(String s) {
        int len = s.length();
        
        int open = 0, extra = 0;
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<len; i++) {
            char ch = s.charAt(i);
            
            if(ch == '(') {
                open++;
                extra++;
            } else if(ch == ')') {
                if(extra == 0) {
                    continue;
                }
                extra--;
            }
            sb.append(ch);
        }
        
        StringBuilder res = new StringBuilder();
        for(int i=0; i<sb.length(); i++) {
            char ch = sb.charAt(i);
            if(ch == '(') {
                if(open == extra) {
                    continue;
                }
                open--;
            }
            res.append(ch);
        }
        
        return res.toString();
    }
}
