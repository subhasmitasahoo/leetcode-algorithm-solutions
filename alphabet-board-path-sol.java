//Problem link: https://leetcode.com/problems/alphabet-board-path/
//Time complexity: O(n)
//Space complexity: O(n)

class Solution {
    public String alphabetBoardPath(String target) {
        int pi = 0, pj = 0;
        String res = "";
        
        for(int i=0; i<target.length(); i++) {
            char cc = target.charAt(i);
            int cj = (cc-'a')%5;
            int ci = (cc-'a')/5;
            if(ci == pi && cj == pj) {
                res += "!";
                continue;
            }
            if(cc == 'z') {
                ci--;
            }
            if(ci > pi) {
                for(int d=0; d<ci-pi; d++) {
                    res+="D";
                }
            } else {
                for(int d=0; d<pi-ci; d++) {
                    res+="U";
                }
            }
            
            if(cj > pj) {
                for(int d=0; d<cj-pj; d++) {
                    res+="R";
                }
            } else {
                for(int d=0; d<pj-cj; d++) {
                    res+="L";
                }
            }
            if(cc == 'z') {
                res += "D";
                ci+=1;
            }
            res += "!";
            pi = ci;
            pj = cj;
        }
        return res;
    }
}
