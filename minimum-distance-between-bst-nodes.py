
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def traverse(self, root):
        if not root:
            return [None,None]
        [ml, Ml] = self.traverse(root.left)
        [mr, Mr] = self.traverse(root.right)
        if Ml is not None:
            self.res = min(self.res, abs(root.val-Ml)) if self.res >= 0 else abs(root.val-Ml)
        if mr is not None:
            self.res = min(self.res, abs(root.val-mr)) if self.res >= 0 else abs(root.val-mr)
        mini = min(ml, root.val) if ml is not None else root.val
        maxi = max(root.val, Mr) if Mr is not None else root.val
        #print(str(mini) + " " + str(maxi))
        return [mini, maxi]
    
        
    def minDiffInBST(self, root: TreeNode) -> int:
        self.res = -1
        self.traverse(root)
        return self.res
        
