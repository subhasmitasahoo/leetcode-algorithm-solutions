//Problem link: https://leetcode.com/problems/all-possible-full-binary-trees/
//Time complexity: O(2^N)
//Space complexity: O(2^N)

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
    
    Map<Integer, List<TreeNode>> rem = new HashMap();
    
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList();
        if(rem.containsKey(N)) {
            return rem.get(N);
        }
    
        if(N==1) {
            res.add(new TreeNode(0));
        } else if(N%2 == 1) {
            for(int i=0; i<N; i++) {
                int j = N-i-1;
                    for(TreeNode l: allPossibleFBT(i)) {
                        for(TreeNode r: allPossibleFBT(j)) {
                            TreeNode cur = new TreeNode(0);
                            cur.left = l;
                            cur.right = r;
                            res.add(cur);
                        }
                    }
            }
        }
        rem.put(N, res);
        return res;
    }
}
