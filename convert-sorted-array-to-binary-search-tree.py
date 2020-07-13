#Problem link: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/solution/
#Time complexity: O(n)
#Space complexity: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def createTree(self, nums:List[int], s:int, e:int) -> TreeNode:
        if s>e:
            return None
        if s==e:
            return TreeNode(nums[s])
        m = s + (e-s)//2
        root = TreeNode(nums[m])
        root.left = self.createTree(nums, s, m-1)
        root.right = self.createTree(nums, m+1, e)
        return root
    
    def sortedArrayToBST(self, nums: List[int]) -> TreeNode:
        return self.createTree(nums, 0, len(nums)-1)
        
