class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        for(int i=0; i<nums.length; i++) {
            int j = i+1; 
            int k = nums.length-1;
            int cur = target-nums[i];
            while(j<k) {
                if(nums[j]+nums[k] < cur) {
                    res+= (k-j);
                    j++;
                } else {
                    k--;
                }
            }
        }      
        return res;
    }
}
