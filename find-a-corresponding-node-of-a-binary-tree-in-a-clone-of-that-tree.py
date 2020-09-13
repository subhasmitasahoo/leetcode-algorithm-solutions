# Problem link: https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
# Time complexity: O(n)
# Space complexity: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def traverse(self, original, cloned, target):
        if not cloned:
            return False 
        if original == target:
            self.res = cloned
            return True
        self.traverse(original.left, cloned.left, target) or self.traverse(original.right, cloned.right, target)
    def getTargetCopy(self, original: TreeNode, cloned: TreeNode, target: TreeNode) -> TreeNode:
        self.res = None
        self.traverse(original, cloned, target)
        return self.res
        
