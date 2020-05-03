//Problem link: https://leetcode.com/problems/next-permutation/
//Time complexity: O(n)
//Space complexity: O(1)

class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        
        int i = len-2;
        
        while(i>=0 && nums[i+1]<=nums[i]) {
            i--;
        }
        
        if(i>=0) {
            int j = len-1;
            while(j>i && nums[j] <= nums[i]) {
                j--;
            }
            if(j>i) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        int s = i+1;
        int l = len-1;
        while(s<l) {
            int temp = nums[s];
            nums[s] = nums[l];
            nums[l] = temp;
            s++;
            l--;
        }
    }
}
