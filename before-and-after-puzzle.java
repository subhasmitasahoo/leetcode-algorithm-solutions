//Problem link: https://leetcode.com/problems/before-and-after-puzzle/submissions/
//Time complexity: O(nlogn)
//Space complexity: O(n)

class Solution {
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        Map<String, Set<Integer>> m = new HashMap();
        
        String[] temp;
        int ind = 0;
        for(String s: phrases) {
            temp = s.split(" ");
            m.putIfAbsent(temp[0], new HashSet());
            m.get(temp[0]).add(ind);
            ind++;
        }
        
        Set<String> res = new TreeSet();
        
        ind = 0;
        
        for(String s: phrases) {
            temp = s.split(" ");
            String lw = temp[temp.length-1];
            if(m.containsKey(lw)) {
                for(int i: m.get(lw)) {
                    if(ind != i) {
                        temp[temp.length-1] = "";
                        String news = String.join(" ", temp);
                        news += phrases[i];
                        res.add(news);                       
                    }
                }
            }
            ind++;
        }
        return new ArrayList<>(res);
    }
}
