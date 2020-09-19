# Problem link: https://leetcode.com/problems/house-robber/
# Time complexity: O(n)
# Space complexity: O(1)

class Solution:
    def rob(self, nums: List[int]) -> int:
        l = len(nums)
        if l==0:
            return 0
        
        for i in range(1, l):
            nums[i] += (nums[i-2] if i>1 else 0)
            nums[i] = max(nums[i], nums[i-1])
        
        return nums[l-1]
        
