//Problem link: https://leetcode.com/problems/binary-tree-coloring-game/
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
    int lcount, rcount, sum;
    
    
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        traverse(root, x);
        if(sum <= (n/2)) {
            return true;
        }
        if(Math.max(lcount, rcount) > (n/2)) {
            return true;
        }
        return false;
    }
    
    private int traverse(TreeNode root, int x) {
        if(root == null) {
            return 0;
        }
        int lc = traverse(root.left,x);
        int rc = traverse(root.right,x);
        int tot = lc + rc + 1;
        if(root.val == x) {
            lcount = lc;
            rcount = rc;
            sum = tot;
        }
        return tot;
    }
}
