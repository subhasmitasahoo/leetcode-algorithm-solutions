# Problem link: https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
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
            return [0, 0]
        [l1, l2] = self.traverse(root.left)
        [r1, r2] = self.traverse(root.right)
        if root.val % 2 == 0:
            self.res += l2 + r2
        return [root.val, l1+r1]
    
    def sumEvenGrandparent(self, root: TreeNode) -> int:
        self.res = 0
        self.traverse(root)
        return self.res
        
