//Problem link: https://leetcode.com/problems/majority-element/
//Time complexity: O(n)
//Space complexity: O(1)

class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int cur = nums[0];
        for(int n: nums) {
            if(cnt == 0) {
                cur = n;
            }
            if(cur == n) {
                cnt++;
            } else {
                cnt--;
            }
        }
        return cur;
    }
}
