//Problem link: https://leetcode.com/problems/binary-tree-tilt/

//Time complexity: O(n)
//Space complexity: O(n)

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
    int res = 0;
    public int findTilt(TreeNode root) {
        traverse(root);
        return res;
    }
    
    private int traverse(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int l = traverse(root.left);
        int r = traverse(root.right);
        res += Math.abs(l-r);
        return l+r+root.val;
    }
}
