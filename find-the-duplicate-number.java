//Problem link: https://leetcode.com/problems/find-the-duplicate-number/submissions/
//Time complexity: O(n)
//Space complexity: O(1)

class Solution {
    public int findDuplicate(int[] nums) {
        int t = 0;
        int h = 0;
        
        do {
            t = nums[t];
            h = nums[nums[h]];
        } while(t != h);
        
        t = 0;
        while(t != h) {
            t = nums[t];
            h = nums[h];
        }
        return t;
    }
    
}
