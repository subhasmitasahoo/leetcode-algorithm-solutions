Problem link: https://leetcode.com/problems/all-paths-from-source-lead-to-destination/

//Time complexity: O(E)
//Space complexity: O(E)

class Solution {
    
     Map<Integer, List<Integer>> graph = new HashMap();
    
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {   
        
        //Create the graph
        for(int[] e: edges) {
            graph.computeIfAbsent(e[0], x -> new ArrayList()).add(e[1]);
        }
        
        //To track which all nodes are visited during the DFS traversal from source
        Set<Integer> seen = new HashSet();
        return DFS(source, destination, seen);
    }
    
    private boolean DFS(int s, int d, Set<Integer> seen) {
        
        //It means there is a cycle in the path, and we will be stuck here forever
        if(seen.contains(s)) {
            return false;
        }
        
        List<Integer> nei = graph.get(s);
        
        //We have reached the end of a path, check if the end is destination or not
        if(nei == null) {
            if(s == d) {
                return true;
            }
            return false;
        }
        
        seen.add(s);
        
        //Explore all the paths from the current source. If in any of the paths, we don't reach the destination retun false. 
        for(int n: nei) {
            System.out.println(s+" "+n);
            if(!DFS(n, d, seen)) {
                return false;
            }
        }
        
        seen.remove(s);
        return true;
    }
}
