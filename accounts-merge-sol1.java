//Time complexity: O(sum(resi.log(resi)))
//Space complexity: O(sum(ai.length))

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> mailToName = new HashMap();
        Map<String, List<String>> graph = new HashMap();
        
        for(List<String> a: accounts) {
            
            String name = null;
            for(String email: a) {
                if(name == null) {
                    name = email;
                    continue;
                }
                mailToName.put(email, name);
                if(!graph.containsKey(email)) {
                    graph.put(email, new ArrayList());
                }
                if(!graph.containsKey(a.get(1))) {
                    graph.put(a.get(1), new ArrayList());
                }
                graph.get(a.get(1)).add(email);
                graph.get(email).add(a.get(1));
            }
        }
        
        Set<String> seen = new HashSet();
        List<List<String>> res = new ArrayList();
        
        for(String key: graph.keySet()) {
            if(!seen.contains(key)) {
                seen.add(key);
                Queue<String> q = new LinkedList();
                q.add(key);
                List<String> temp = new ArrayList();
                
                while(!q.isEmpty()) {
                    String cur = q.poll();
                    temp.add(cur);
                    for(String nei: graph.get(cur)) {
                        if(!seen.contains(nei)) {
                            seen.add(nei);
                            q.add(nei);
                        }
                    }
                }
                Collections.sort(temp);
                temp.add(0, mailToName.get(key));
                res.add(temp);
            }
        }
        return res;
    }
}
