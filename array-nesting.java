//Problem link: https://leetcode.com/problems/array-nesting/

//Time complexity: O(n)
//Space complexity: O(1)

class Solution {
    public int arrayNesting(int[] nums) {
        int len = 0;
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != -1) {
                int first = i;
                int clen = 1;
                int cur = nums[i];
                nums[i] = -1;
                while(first != cur) {
                    clen++;
                    int temp = cur;
                    cur = nums[cur];
                    nums[temp] = -1;
                }
                len = Math.max(len, clen);
            }
        }
        return len;
    }
}
