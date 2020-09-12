# Problem link: https://leetcode.com/problems/symmetric-tree/submissions/
# Time complexity: O(n)
# Space complexity: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def traverse(self, lTree, rTree):
        if not lTree and not rTree:
            return True
        if not lTree or not rTree:
            return False
        return lTree.val == rTree.val and self.traverse(lTree.left, rTree.right) and self.traverse(lTree.right, rTree.left)
        
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root:
            return True
        return self.traverse(root.left, root.right)
        
