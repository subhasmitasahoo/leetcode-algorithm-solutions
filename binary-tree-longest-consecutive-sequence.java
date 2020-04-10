//Problem link: https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/
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
    int res = 0;
    public int longestConsecutive(TreeNode root) {
        traverse(root);
        return res;
    }
    
    private int traverse(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int lv = traverse(root.left);
        int rv = traverse(root.right);
        System.out.println(root.val + " " + lv + " " + rv);
        if(lv>0 && root.left.val == root.val+1) {
            lv++;
        } else {
           lv = 1; 
        }
        if(rv>0 && root.right.val == root.val+1) {
            rv++;
        } else {
            rv = 1;
        }
        res = Math.max(res,Math.max(lv, rv));
        return Math.max(lv, rv);
    }
}
