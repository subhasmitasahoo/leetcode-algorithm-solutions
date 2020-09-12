# Problem link: https://leetcode.com/problems/sum-of-left-leaves/submissions/
# Time complexity: O(n)
# Space complexity: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def traverse(self, root):
        if not root:
            return
        if root.left:
            if not root.left.left and not root.left.right:
                self.sum += root.left.val
        self.traverse(root.left)
        self.traverse(root.right)
    def sumOfLeftLeaves(self, root: TreeNode) -> int:
        self.sum = 0
        self.traverse(root)
        return self.sum
        
