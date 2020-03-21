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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(root == null) {
            return null;
        }
        
        if(d == 1) {
            TreeNode temp = new TreeNode(v);
            temp.left = root;
            return temp;
        }
        if(d == 2) {
            TreeNode l1 = new TreeNode(v);
            TreeNode l2 = new TreeNode(v);
            l1.left = root.left;
            l2.right = root.right;
            root.left = l1;
            root.right = l2;
            return root;
        }
        
        root.left = addOneRow(root.left, v, d-1);
        root.right = addOneRow(root.right, v, d-1);
        return root;
    }
}
