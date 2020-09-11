# Problem link: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/submissions/
# Time complexity: O(n)
# Space complexity: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:     
    def inorder(self, root, ordered):
        if not root:
            return
        self.inorder(root.left, ordered)
        ordered.append(root.val)
        self.inorder(root.right, ordered)
        
    def findTarget(self, root: TreeNode, k: int) -> bool:
        
        ordered = [] 
        self.inorder(root, ordered)
        
        i = 0
        j = len(ordered)-1
        
        while i<j:
            if ordered[i]+ordered[j] == k:
                return True
            elif ordered[i]+ordered[j] < k:
                i += 1
            else:
                j -= 1
        
        return False
        
