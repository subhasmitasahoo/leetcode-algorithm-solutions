# Problem link: https://leetcode.com/problems/longest-univalue-path/submissions/
# Time complexity: O(n)
# Space complexity: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def traverse(self, root, val):
        if not root:
            return 0
        lval = self.traverse(root.left, root.val)
        rval = self.traverse(root.right, root.val)
        #print(str(lval) + str(rval))
        
        self.res = max(self.res, lval + rval + 1)
        
        if val == root.val:
            return max(lval, rval) + 1
        else:
            return 0
            
    def longestUnivaluePath(self, root: TreeNode) -> int:
        if not root:
            return 0
        self.res = 0
        self.traverse(root, 0)
        return self.res-1
        
