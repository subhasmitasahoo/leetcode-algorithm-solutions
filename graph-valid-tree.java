//Problem link: https://leetcode.com/problems/graph-valid-tree/

//Time complexity: O(n)
//Space complexity: O(n)

//Hint: 1. check if no. of edges == n-1 or not. If it is greater or less, there is either a loop or connectivity missing respectively. 
// 2. If no. of edges == n-1, if there is a cycle, thre must be connectivity missing. So, check if all nodes are visited or not. 

class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) {
            return false;
        }
        Map<Integer, List<Integer>> m = new HashMap();
        
        for(int[] e: edges) {
            m.computeIfAbsent(e[0], x -> new ArrayList()).add(e[1]);
            m.computeIfAbsent(e[1], x -> new ArrayList()).add(e[0]);
            
        }
        
        Set<Integer> vis = new HashSet();
        Stack<Integer> stk = new Stack();
        stk.push(0);
        vis.add(0);
        
        while(!stk.isEmpty()) {
            int cur = stk.pop();
            if(m.get(cur) == null) {
                continue;
            }
            for(int nei: m.get(cur)) {
                if(vis.contains(nei)) {
                    continue;
                }
                stk.push(nei);
                vis.add(nei);
            }
        }
        // System.out.println(vis.size());
        return vis.size() == n;
        
    }
}
