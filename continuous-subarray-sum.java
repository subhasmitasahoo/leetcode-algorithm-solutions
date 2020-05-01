//Problem link: https://leetcode.com/problems/continuous-subarray-sum/
//Time complexity: O(n)
//Space complexity: O(min(n, k))

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        map.put(0,-1);
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            if(k != 0)
                sum %= k;
            if(map.containsKey(sum) && i-map.get(sum)>1) {
                return true;
            }
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
            
        }
        return false;
    }
}
