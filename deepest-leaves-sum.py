# Problem link: https://leetcode.com/problems/deepest-leaves-sum/solution/
# Time complexity: O(n)
# Space complexity: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def traverse(self, root, dep):
        if not root:
            return
        if not root.left and not root.right:
            if dep == self.depth:
                self.ans += root.val
            elif dep > self.depth:
                self.depth = dep
                self.ans = root.val
            return
        self.traverse(root.left, dep+1)
        self.traverse(root.right, dep+1)
    def deepestLeavesSum(self, root: TreeNode) -> int:
        if not root:
            return 0
        self.depth = 0
        self.ans = 0
        self.traverse(root, 0)
        return self.ans
        
