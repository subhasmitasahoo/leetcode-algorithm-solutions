//Problem link: https://leetcode.com/problems/binary-tree-level-order-traversal/solution/
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
    List<List<Integer>> res = new ArrayList();
    int len = 0;
    public List<List<Integer>> levelOrder(TreeNode root) {
        traverse(root, 0);
        return res;
    }
    
    private void traverse(TreeNode root, int l) {
        if(root == null) {
            return;
        }
        if(len==l) {
            res.add(new ArrayList());
            len++;
        }
        res.get(l).add(root.val);
        traverse(root.left, l+1);
        traverse(root.right, l+1);
    }
}
