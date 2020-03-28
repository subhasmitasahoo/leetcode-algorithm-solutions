//Problem link: https://leetcode.com/problems/balance-a-binary-search-tree/

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
    List<TreeNode> res = new ArrayList();
    
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return getBalancedTree(0, res.size()-1);
    }
    
    private TreeNode getBalancedTree(int l, int r) {
        if(l > r) {
            return null;
        }
        int mid = l+ (r-l)/2;
        TreeNode root = res.get(mid);
        root.left = getBalancedTree(l, mid-1);
        root.right = getBalancedTree(mid+1, r);
        return root;
    }
    
    private void inorder(TreeNode root) {
        if(root == null)
            return;
        inorder(root.left);
        res.add(root);
        inorder(root.right);
    }
}
