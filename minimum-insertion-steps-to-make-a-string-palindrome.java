//Problem link: https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
//Timg complexity: O(n*n)
//Space complexity: O(n*n)

class Solution {
    public int minInsertions(String s) {
        int len = s.length();
        
        if(len <= 1) {
            return 0;
        }
        
        int[][] res = new int[len][len];
        
        for(int i=0; i<len; i++) {
            res[i][i] = 0;
            for(int j=0; j<i; j++) {
                res[i][j] = 0;
            }
        }
        
        for(int l = 2; l<=len; l++) {
            for(int j=0; j<=len-l;j++) {
                int st = j;
                int e = j+l-1;
                int temp = res[st+1][e] + 1;
                temp = Math.min(temp, res[st][e-1]+1);
                if(s.charAt(st) == s.charAt(e)) {
                    temp = Math.min(temp, res[st+1][e-1]);
                }
                res[st][e] = temp;
            }
        }
        return res[0][len-1];
    }
}
