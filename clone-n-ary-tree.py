# Problem link: https://leetcode.com/problems/clone-n-ary-tree/
# Time complexity: O(n)
# Space complexity: O(n)

"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children if children is not None else []
"""

class Solution:
    def cloneTree(self, root: 'Node') -> 'Node':
        if not root:
            return root
        cloneRoot = Node(root.val)
        for c in root.children:
            cloneRoot.children.append(self.cloneTree(c))
        return cloneRoot
        
