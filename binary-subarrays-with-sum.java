//Problem link: https://leetcode.com/problems/binary-subarrays-with-sum/
//Time complexity: O(n)
//Space complexity: O(1)

class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        int l = 0;
        int h = 0;
        int len = A.length;
        
        int curl = 0, curh = 0;
        int res = 0;
        int lz = 0, rz = 0;
        for(int i=0; i<len; i++) {
            curl += A[i];
            curh += A[i];
            while(l<=i && curl > S) {
                curl -= A[l];
                l++;
            }
            
            while(h<i && (curh>S || (curh==S && A[h]==0))) {
                curh -= A[h];
                h++;
            }
            // System.out.println(l + " " + h);
            if(curl == S) {
                res += h-l+1;
            }
            
        }
        return res;
    }
}
