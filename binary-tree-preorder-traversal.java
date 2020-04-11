//Problem link: https://leetcode.com/problems/binary-tree-preorder-traversal/solution/
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        
        if(root == null) {
            return res;
        }
        
        Stack<TreeNode> st = new Stack();
        while(root != null) {
            res.add(root.val);
            st.push(root);
            root = root.left;
        }
        while(!st.isEmpty()) {
            TreeNode cur = st.pop();
            cur = cur.right;
            while(cur != null) {
                res.add(cur.val);
                st.push(cur);
                cur = cur.left;
            }
        }
        return res;
    }
}
