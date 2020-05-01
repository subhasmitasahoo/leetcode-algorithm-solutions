//Problem link: https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/submissions/

//Time complexity: O(n)
//Space complexity: O(1)

class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int len = A.length;
        if(len == 0) {
            return 0;
        }
        
        int pind = 0;
        int maxi = 0;
        
        int res = 0;
        int prev = 0;
        
        for(int i=0; i<len; i++) {
            if(A[i] >=L && A[i] <= R) {
                maxi = Math.max(maxi, A[i]);
                prev = (i-pind+1);
                res += prev;   
            } else if(A[i]<L){
                res += prev;
            } else {
                pind = i+1;
                prev = 0;
                maxi = 0;
            }   
            //System.out.println(prev);
        }
        return res;
    }
}
