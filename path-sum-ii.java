//Problem link: https://leetcode.com/problems/path-sum-ii/
//Time complexity: O(n^2)
//Space complexity: O(n)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) {
            return res;
        }
        traverse(root, 0, sum, new ArrayList());
        return res;
    }
    
    private void traverse(TreeNode root, int csum, int tsum, List<Integer> cur) {
        if(root == null) {
            return;
        }
        csum += root.val;
        cur.add(root.val);
        if(root.left == null && root.right == null) {
            if(csum == tsum) {
                List<Integer> temp = new ArrayList(cur);
                res.add(temp);
            }
        } else {
            traverse(root.left, csum, tsum, cur);
            traverse(root.right, csum, tsum, cur);
        }
        cur.remove(cur.size()-1);
    }
    
    
}
