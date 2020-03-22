Problem link: https://leetcode.com/problems/all-elements-in-two-binary-search-trees/

//Time complexity: O(m+n)
//Space complexity: O(m+n)

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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList();
        
        Stack<TreeNode> st1 = new Stack();
        Stack<TreeNode> st2 = new Stack();
        
        TreeNode cur1 = root1;
        TreeNode cur2 = root2;
        
        while(!st1.isEmpty() || !st2.isEmpty() || cur1 != null || cur2 != null) {
            while(cur1 != null) {
                st1.push(cur1);
                cur1 = cur1.left;
            }
            
            while(cur2 != null) {
                st2.push(cur2);
                cur2 = cur2.left;
            }
            
            if(st1.isEmpty() || (!st2.isEmpty() && st2.peek().val <= st1.peek().val)) {
                cur2 = st2.pop();
                res.add(cur2.val);
                cur2 = cur2.right;
            } else {
                cur1 = st1.pop();
                res.add(cur1.val);
                cur1 = cur1.right;
            }
        }
        return res;
    }
}
