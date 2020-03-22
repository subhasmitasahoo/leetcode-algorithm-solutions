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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        if(root == null) {
            return res;
        }
        
        Stack<TreeNode> temp = new Stack();
        TreeNode cur = root;
        while(!temp.isEmpty() || cur != null) {
            while(cur != null) {
                temp.push(cur);
                cur = cur.left;
            }
            cur = temp.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
