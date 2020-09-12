# Problem link: https://leetcode.com/problems/find-mode-in-binary-search-tree/submissions/
# Time complexity: O(n)
# Space complexity: O(1), without stack space and result

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def traverse(self, root):
        if root:
            self.traverse(root.left)
            if self.prev == root.val:
                self.freq += 1
            else:
                self.freq = 1
            if self.freq > self.max_freq:
                self.mode = [root.val]
                self.max_freq = self.freq
            elif self.freq == self.max_freq:
                self.mode.append(root.val)
            self.prev = root.val
            self.traverse(root.right)
    def findMode(self, root: TreeNode) -> List[int]:
        self.mode = []
        self.prev = None
        self.freq = 0
        self.max_freq=0
        if not root:
            return self.mode
        self.traverse(root)
        return self.mode
        
