# Problem link: https://leetcode.com/problems/find-all-the-lonely-nodes/submissions/
# Time complexity: O(n)
# Space complecity: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def getLonelyNodes(self, root: TreeNode) -> List[int]:
        res = []
        temp = []
        if not root:
            return res
        temp.append(root)
        
        while len(temp)>0:
            cur = temp.pop()
            if cur.left and not cur.right:
                res.append(cur.left.val)
                temp.append(cur.left)
            elif cur.right and not cur.left:
                res.append(cur.right.val)
                temp.append(cur.right)
            elif cur.left and cur.right:
                temp.append(cur.left)
                temp.append(cur.right)
                
        return res
        
