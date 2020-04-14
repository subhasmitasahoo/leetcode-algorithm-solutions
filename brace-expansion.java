//Problem link: https://leetcode.com/problems/brace-expansion/
//Time complexity: Result length
//Space complexity: O(n)

class Solution {
    public String[] expand(String S) {
        List<String> res = new ArrayList();
        res.add("");
        List<String> temp = new ArrayList();
        boolean store = false;
        for(char ch: S.toCharArray()) {
            if(ch == ',') {
                continue;
            }
            if(ch == '{') {
                store = true;
                continue;
            }
            if(ch == '}') {
                store = false;
                List<String> cur = new ArrayList();
 
                    for(String t: temp) {
                        for(String r: res) {
                            cur.add(r+t);
                        }
                    }
                
                res.clear();
                res.addAll(cur);
                temp.clear();
                continue;
            }
            if(store) {
                temp.add(String.valueOf(ch));
            } else {
                List<String> cur = new ArrayList();
                for(int i=0; i<res.size(); i++) {
                    cur.add(res.get(i)+String.valueOf(ch));
                }
                res = cur;
            }
        }
        Collections.sort(res);
        return res.toArray(new String[res.size()]);
    }
}
