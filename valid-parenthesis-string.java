//Greedy colution 

//Problem link: https://leetcode.com/problems/valid-parenthesis-string/
//Time complexity: Exponential
//Space complexity: O(N)

//Do it woth O(N) time complexity - https://leetcode.com/problems/valid-parenthesis-string/solution/

class Solution {
    public boolean checkValidString(String s) {
        return traverse(s, 0, 0, 0);
        
    }
    
    private boolean traverse(String s, int ind, int c, int o) {
        int len = s.length();
        if(ind == len) {
            return c==o;
        }
        
        char ch = s.charAt(ind);
        boolean res = false;
        if(ch != ')') {
            res |= traverse(s, ind+1, c, o+1);
        } 
        if(ch != '(') {
            if(o >= c+1) {
                res |= traverse(s, ind+1, c+1, o);
            }
        }
        if(ch == '*') {
            res |= traverse(s, ind+1, c, o);
        }
           return res;
    }
}
