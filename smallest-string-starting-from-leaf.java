//Problem link: https://leetcode.com/problems/smallest-string-starting-from-leaf/
//Time complexity: O(NlogN)
//Space complexity: O(logN)

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
    String ans = null;
    public String smallestFromLeaf(TreeNode root) {
        if(root == null) {
            return "";
        }
        dfs(root, new StringBuilder());
        return ans;
    }
    
    private void dfs(TreeNode root, StringBuilder sb) {
        if(root == null) {
            return;
        }
        sb.append(((char)('a' + root.val)));
        
        if(root.left == null && root.right == null) {
            sb.reverse();
            String cur = sb.toString();
            sb.reverse();
            if(ans == null || ans.compareTo(cur) > 0) {
                ans = cur;
            }
        }
        dfs(root.left, sb);
        dfs(root.right, sb);
        sb.deleteCharAt(sb.length()-1);
    }
}
