//Problem link: https://leetcode.com/problems/minimum-increment-to-make-array-unique/
//Time complexity: O(nlogn)
//Space complexity: O(1)

class Solution {
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int next = -1;
        int res = 0;
        for(int a: A) {
            if(next <= a) {
                next = a+1;
            } else {
                res += (next-a);
                next++;
            }
        }
        return res;
    }
}
