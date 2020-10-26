# Problem link: https://leetcode.com/problems/count-univalue-subtrees/
# Time complexity: O(N)
# Space complexity: O(N) or O(H)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:    
    def traverse(self, root):
        if not root:
            return True
        if not root.left and not root.right:
            self.res += 1
            return True
        lCount = self.traverse(root.left)
        rCount = self.traverse(root.right)
        
        if lCount and rCount:
            cur = True
            if root.left:
                cur = cur and (root.left.val == root.val)
            if root.right:
                cur = cur and (root.right.val == root.val)
            if cur:
                self.res += 1
            return cur
        return False
        
        
    def countUnivalSubtrees(self, root: TreeNode) -> int:
        self.res = 0
        self.traverse(root)
        return self.res
        
        
