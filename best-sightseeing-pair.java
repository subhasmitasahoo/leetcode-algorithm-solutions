//Problem link: https://leetcode.com/problems/best-sightseeing-pair/submissions/
//Time complexity: O(n)
//Space complexity: O(1)

class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int len = A.length;
        int maxi = 0;
        
        int ind = 0;
        for(int i=1; i<len; i++) {
            maxi = Math.max(maxi, A[ind]+ind + A[i]-i);
            if(A[i]+i > A[ind]+ind) {
                ind = i;
            }
        }
        return maxi;
    }
}
