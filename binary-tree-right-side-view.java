//Problem link: https://leetcode.com/problems/binary-tree-right-side-view/
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
    List<Integer> res = new ArrayList();
    public List<Integer> rightSideView(TreeNode root) {
        traverse(root, 0);
        return res;
    }
    
    private void traverse(TreeNode root, int l) {
        if(root == null) {
            return;
        }
        if(res.size() == l) {
            res.add(root.val);
        }
        traverse(root.right, l+1);
        traverse(root.left, l+1);
    }
}
