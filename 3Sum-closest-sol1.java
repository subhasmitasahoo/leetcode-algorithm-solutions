//Time complexity: O(N^2)
//Space complexity: O(1)

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int res = nums[0]+nums[1]+nums[2];
        int diff = Math.abs(target - res);
        if(diff == 0) {
            return target;
        }
        
        for(int i=0; i<nums.length; i++) {
            if(i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i+1; 
            int k = nums.length-1;
            int rem = target-nums[i];
            while(j<k) {
                int cDiff = rem-nums[j]-nums[k];
                if(Math.abs(cDiff) < diff) {
                    diff = Math.abs(cDiff);
                    res = target - cDiff;
                }
                if(cDiff == 0) {
                    return target;
                } else if(cDiff > 0) {
                    while(j<k && nums[j+1] == nums[j]) {
                        j++;
                    }
                    j++;
                } else {
                    while(j<k && nums[k-1] == nums[k]) {
                        k--;
                    }
                    k--;
                }
            }
        }   
        return res;
    }
}
