//Problem link: https://leetcode.com/problems/binary-tree-vertical-order-traversal/submissions/
//Time complexity: O(nlogn) 
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
    TreeMap<Integer, List<Integer>> m = new TreeMap();
    public List<List<Integer>> verticalOrder(TreeNode root) {
        traverse(root, 0);
        List<List<Integer>> res = new ArrayList();
        for(List<Integer> v: m.values()) {
            res.add(v);
        }
        return res;
    }
    
    private void traverse(TreeNode root, int l) {
        if(root == null) {
            return;
        }
       Queue<TreeNodeWide> q = new LinkedList();
        q.add(new TreeNodeWide(root, l));
        
        while(!q.isEmpty()) {
            TreeNodeWide cur = q.poll();
            m.putIfAbsent(cur.wide, new ArrayList());
            m.get(cur.wide).add(cur.node.val);
            if(cur.node.left != null) {
                q.add(new TreeNodeWide(cur.node.left, cur.wide-1));
            }
            if(cur.node.right != null) {
                q.add(new TreeNodeWide(cur.node.right, cur.wide+1));
            }
        }
    }
    
    private class TreeNodeWide {
        TreeNode node;
        int wide;
        
        TreeNodeWide(TreeNode node, int wide) {
            this.node = node;
            this.wide = wide;
        }
    }
}
