//Problem link: https://leetcode.com/problems/jump-game/solution/
//Time complexity: O(n)
//Space complexity: O(1)

class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        
        int maxi = 0;
        int ind = 0;
        while(true) {
            if(maxi >= nums.length-1) {
                return true;
            }
            if(ind > maxi) {
                return false;
            }
            int temp = 0;
            for(int i=ind; i<=maxi; i++) {
                temp = Math.max(temp, nums[i]+i);
            }
            ind = maxi+1;
            maxi = temp;
        }
    }
}
