//Time complexity: O(N^2)
//Space complexity: O(N) - To store the result

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> res = new ArrayList();
        
        for(int i=0; i<nums.length; i++) {
            if(i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i+1; 
            int k = nums.length-1;
            int target = -(nums[i]);
            while(j<k) {
                if(nums[j]+nums[k] == target) {
                    res.add(Arrays.asList(new Integer[]{nums[i], nums[j], nums[k]}));
                    while(j<k && nums[j+1] == nums[j]) {
                        j++;
                    }
                    while(j<k && nums[k-1] == nums[k]) {
                        k--;
                    }
                    j++;
                    k--;
                } else if(nums[j]+nums[k] < target) {
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
