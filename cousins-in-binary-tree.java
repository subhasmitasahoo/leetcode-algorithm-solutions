#Problem link: https://leetcode.com/problems/cousins-in-binary-tree/solution/
#Time complexity: O(n)
#Space complexity: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        self.p1 = None
        self.p2 = None
        self.d1 = None
        self.d2 = None
        isDone = False
        def internal(self, root: TreeNode, parent: TreeNode, depth: int) -> bool:
            if (not root) or (isDone):
                return isDone
            if root.val == x:
                self.p1 = parent
                self.d1 = depth
            elif root.val == y:
                self.p2 = parent
                self.d2 = depth
            if self.p1 and self.p2:
                return (self.p1 != self.p2) and (self.d1 == self.d2)
            return internal(self, root.left, root, depth+1) or internal(self, root.right, root, depth+1)
        
        return internal(self, root, None, 0)
