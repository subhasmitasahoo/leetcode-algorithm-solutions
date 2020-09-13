# Problem link: https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/solution/
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
        if root.val > self.mini:
            if self.res == -1 or self.res > root.val:
                self.res = root.val
            return
        self.traverse(root.left)
        self.traverse(root.right)
        
        
    def findSecondMinimumValue(self, root: TreeNode) -> int:
        self.res = -1
        if not root:
            return res
        self.mini = root.val
        self.traverse(root)
        return self.res
    
