//Problem link: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

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
    TreeMap<Integer, List<Integer>> res = new TreeMap(Collections.reverseOrder());
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        if(root == null) {
            return ans;
        }
        traverse(root, 0);
        
        for(List<Integer> r : res.values()) {
            ans.add(r);
        } 
        return ans;
    }
    
    private void traverse(TreeNode root, int l) {
        if(root == null) {
            return;
        }
        List<Integer> cur = new ArrayList();
        res.putIfAbsent(l, cur);
        res.get(l).add(root.val);
        traverse(root.left, l+1);
        traverse(root.right, l+1);
    }
}
