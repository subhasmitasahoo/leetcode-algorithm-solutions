//Problem link: https://leetcode.com/problems/wiggle-sort/
//Time complexity: O(n)
//Space complexity: O(1)

class Solution {
    public void wiggleSort(int[] nums) {
        boolean flag = true;
        int len = nums.length;
        for(int i=0; i<len-1; i++) {
            if((flag && nums[i] > nums[i+1]) || (!flag && nums[i] < nums[i+1])) {
                int temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
            }
            flag = !flag;
        }
    }
}
