#Problem link: https://leetcode.com/problems/construct-string-from-binary-tree/
#Time complexity: O(n)
#Space complexity: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def tree2str(self, t: TreeNode) -> str:
        if not t:
            return ""
        cur = str(t.val)
        if not t.left and not t.right:
            return cur
        cur += "(" + self.tree2str(t.left) + ")"
        if t.right:
            cur += "(" + self.tree2str(t.right) + ")"
        return cur

        
