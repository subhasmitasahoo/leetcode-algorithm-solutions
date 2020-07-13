#problem link: https://leetcode.com/problems/convert-bst-to-greater-tree/
#Time complexity: O(n)
#Space complexity: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    sums = 0
    def convertBST(self, root: TreeNode) -> TreeNode:
        if not root:
            return root
        root.right = self.convertBST(root.right)
        root.val += self.sums
        self.sums = root.val
        root.left = self.convertBST(root.left)
        return root
        
        
