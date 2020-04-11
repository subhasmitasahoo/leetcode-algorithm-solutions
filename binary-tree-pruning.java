//Problem link: https://leetcode.com/problems/binary-tree-pruning/
//Time complexity: O(n)
//Space complexity: O(h)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        return traverse(root);
    }
    
    private TreeNode traverse(TreeNode root) {
        if(root == null) {
            return root;
        }
        root.left = traverse(root.left);
        root.right = traverse(root.right);
        
        if(root.left==null && root.right==null && root.val==0) {
            return null;
        }
        return root;
    }
}
