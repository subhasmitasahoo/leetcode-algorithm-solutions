Problem link: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/solution/

//Time complexity: O(n), At max a node is visited twice.
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
    int K;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        this.K = K;
        traverse(root, target);
        return res;
    }
    
    private int traverse(TreeNode root, TreeNode target) {
        if(root == null) {
            return -1;
        }
        if(root == target) {
            findNodes(root, K);
            return 0;
        }
        int val = traverse(root.left, target);
        if(val >= 0) {
            if(val+1 == K) {
                res.add(root.val);
            } else if(val + 1 < K) {
                
                findNodes(root.right, K-val-2);
            }
            return val+1;
        }
        val = traverse(root.right, target);
        if(val>=0) {
           if(val+1 == K) {
                res.add(root.val);
            } else if(val + 1 < K) {
                findNodes(root.left, K-val-2);
            }
            return val+1; 
        }
        return -1;
    }
    
    private void findNodes(TreeNode root, int dist) {
        if(root == null || dist<0) {
            return;
        }
        if(dist==0) {
            res.add(root.val);
            return;
        }
        findNodes(root.left, dist-1);
        findNodes(root.right, dist-1);
    }
}
