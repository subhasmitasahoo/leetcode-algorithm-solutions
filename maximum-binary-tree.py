# Problem link: https://leetcode.com/problems/maximum-binary-tree/
# Time complexity: O(nlogn)
# Space complexity: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class RangeNode:
    def __init__(self, val=0, start=-1, end=-1, left=None, right=None, index=-1):
        self.val = val
        self.start = start
        self.end = end
        self.left = left
        self.right = right
        self.index = index
class Solution:
    
    def buildRangeTree(self, nums, start, end):
        if start > end:
            return None
        if start == end:
            return RangeNode(nums[start], start, end, None, None, start)
        mid = start + (end-start)//2
        lRoot = self.buildRangeTree(nums, start, mid)
        rRoot = self.buildRangeTree(nums, mid+1, end)
        node = RangeNode()
        val = 0
        index = -1
        if lRoot is not None:
            node.left = lRoot
            val = lRoot.val
            index = lRoot.index
        if rRoot is not None:
            node.right = rRoot
            if val < rRoot.val:
                val = rRoot.val
                index = rRoot.index
        return RangeNode(val, start, end, lRoot, rRoot, index)
    
    def getMaximum(self, start, end, rangeRoot, nums):
        # print(str(start) + " " + str(end) + " : " + str(rangeRoot.start) + " " + str(rangeRoot.end))
        if start <= rangeRoot.start and rangeRoot.end <= end:
            return rangeRoot.index
        if start > rangeRoot.end or end < rangeRoot.start:
            return -1
        index = -1
        val = float('-inf')
        if rangeRoot.left:
            temp = self.getMaximum(start, end, rangeRoot.left, nums)
            if temp != -1:
                index = temp
        if rangeRoot.right:
            temp = self.getMaximum(start, end, rangeRoot.right, nums)
            if index == -1 or (temp != -1 and nums[temp] > nums[index]):
                index = temp
        return index
        
        
    def createMaxTree(self, nums, start, end):
        if start > end:
            return None
        if start == end:
            return TreeNode(nums[start])
        index = self.getMaximum(start, end, self.rangeRoot, nums)
        # print(str(index))
        lRoot = self.createMaxTree(nums, start, index-1)
        rRoot = self.createMaxTree(nums, index+1, end)
        return TreeNode(nums[index], lRoot, rRoot)
        
    def constructMaximumBinaryTree(self, nums: List[int]) -> TreeNode:
        self.rangeRoot = self.buildRangeTree(nums, 0, len(nums)-1)
        return self.createMaxTree(nums, 0, len(nums)-1)
        
