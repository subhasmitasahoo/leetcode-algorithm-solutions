//Problem link: https://leetcode.com/problems/brick-wall/solution/
//Time complexity: O(n), n - no. of bricks
//Space complexity: O(m), m - width of the wall

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> m = new HashMap();
        
        for(List<Integer> w: wall) {
            int cur = 0;
            for(int i=0; i<w.size()-1; i++) {
                cur += w.get(i);
                m.putIfAbsent(cur, 0);
                m.put(cur, m.get(cur)+1);
            }
        }
        
        int res = 0;
        
        for(int i:m.values()) {
            res = Math.max(res, i);    
        }
        return wall.size()-res;
    }
}
