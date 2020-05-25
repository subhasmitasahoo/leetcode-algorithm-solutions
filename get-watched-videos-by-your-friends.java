//Problem link: https://leetcode.com/problems/get-watched-videos-by-your-friends/
//Time complexity: O(n)
//Space complexity: O(n)

class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        
        boolean[] vis = new boolean[friends.length];
        
        int highest = 0;
        
        Map<String, Integer> res = new HashMap();
        List<String> ans = new LinkedList();
        
        Queue<int[]> q= new LinkedList();
        q.add(new int[]{id, 0});
        vis[id] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i=0; i<friends[cur[0]].length; i++) {
                if(!vis[friends[cur[0]][i]]) {
                    if(cur[1] + 1 == level) {
                        for(String v: watchedVideos.get(friends[cur[0]][i])) {
                            res.computeIfAbsent(v, x->0);
                            res.put(v, res.get(v)+1);
                        }
                    } else {
                        q.add(new int[]{friends[cur[0]][i], cur[1]+1});
                    }
                    vis[friends[cur[0]][i]] = true;
                }
            }
        }
        
        List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(res.entrySet());
        
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() { 
            public int compare(Map.Entry<String, Integer> o1,  
                               Map.Entry<String, Integer> o2) 
            { 
                if(o1.getValue().equals(o2.getValue())) {
                    return (o1.getKey()).compareTo(o2.getKey());
                }
                return (o1.getValue()).compareTo(o2.getValue()); 
            } 
        }); 
        
        for(Map.Entry<String, Integer> e: list) {
            ans.add(e.getKey());
        }
        return ans;
        
    }
}
