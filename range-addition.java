//Problem link: https://leetcode.com/problems/range-addition/
//Time complexity: O(n)
//Space complexity: O(1), exluding output size
class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];
        
        for(int[] u: updates) {
            arr[u[0]] += u[2];
            if(u[1] + 1 < length) {
                arr[u[1]+1] -= u[2];
            }
        }
        
        for(int i=1; i<length; i++) {
            arr[i] += arr[i-1];
        }
        return arr;
    }
}
