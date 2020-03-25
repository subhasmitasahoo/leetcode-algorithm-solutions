//Problem link: https://leetcode.com/problems/bag-of-tokens/

//Time complexity: O(nlogn)
//Space complexity: O(1)

class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        
        int res = 0, cur = 0;
        int l = 0, h = tokens.length-1;
        
        while(l<=h) {
            while(l<=h && tokens[l] <= P) {
                P -= tokens[l++];
                cur++;
            }
            
            res = Math.max(res, cur);
            if(l<=h) {
                if(cur > 0) {
                    cur--;
                    P += tokens[h--];
                } else {
                    break;
                }
            }
        }
        return res;
    }
}
