//Problem link: https://leetcode.com/problems/binary-tree-paths/

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
    List<String> res = new ArrayList();
    public List<String> binaryTreePaths(TreeNode root) {
        traverse(root, "");
        return res;
    }
    
    private void traverse(TreeNode root, String cur) {
        if(root == null) {
            return;
        }
        if(cur.length() > 0) {
            cur += "->";
        }
        cur += String.valueOf(root.val);
        if(root.left == null && root.right == null) {
            res.add(cur);
            return;
        }
        traverse(root.left, cur);
        traverse(root.right, cur);
    }
}
