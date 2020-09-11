# Problem link: https://leetcode.com/problems/minimum-absolute-difference-in-bst/
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
            return [-1,-1]
        [ml, Ml] = self.traverse(root.left)
        [mr, Mr] = self.traverse(root.right)
        if Ml >= 0:
            self.res = min(self.res, abs(root.val-Ml)) if self.res >= 0 else abs(root.val-Ml)
        if mr >= 0:
            self.res = min(self.res, abs(root.val-mr)) if self.res >= 0 else abs(root.val-mr)
        mini = min(ml, root.val) if ml!=-1 else root.val
        maxi = max(root.val, Mr) if Mr!=-1 else root.val
        return [mini, maxi]
        
    def getMinimumDifference(self, root: TreeNode) -> int:
        self.res = -1
        self.traverse(root)
        return self.res
        
