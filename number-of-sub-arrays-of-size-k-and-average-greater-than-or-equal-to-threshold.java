//Problem link: https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
//Time complexity: O(n)
//Space complexity: O(1)

class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int res = 0;
        int len = arr.length;
        if(k>len) {
            return 0;
        }
        int sum = 0;
        for(int i=0; i<k; i++) {
            sum += arr[i];
        }
        if(sum/k >= threshold) {
            res++;
        }
        
        for(int i=k; i<len; i++) {
            sum = sum-arr[i-k]+arr[i];
            if(sum/k >= threshold) {
                res++;
            }
        }
        return res;
    }
}
