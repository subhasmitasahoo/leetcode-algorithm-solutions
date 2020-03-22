//Problem link: https://leetcode.com/problems/all-paths-from-source-to-target/submissions/

//P - No. of paths
//Time complexity: O(E) + O(P*N)
//Space complexity: O(P*N)

class Solution {
    
    List<List<Integer>> res = new ArrayList();
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> arr = new ArrayList();
        DFS(graph, 0, graph.length-1, arr);    
        return res;
    }
    
    private void DFS(int[][] graph, int src, int dest, List<Integer> arr) {
        arr.add(src);
        
        if(src == dest) {
            List<Integer> temp = new ArrayList(arr);
            res.add(temp);
            arr.remove(arr.size()-1);
            return;
        }
        
        int[] nei = graph[src];
        for(int n: nei) {
            DFS(graph, n, dest, arr);
        }
        arr.remove(arr.size()-1);
    }
}
