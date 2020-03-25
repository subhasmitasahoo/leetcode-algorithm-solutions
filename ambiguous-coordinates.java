//Problem link: https://leetcode.com/problems/ambiguous-coordinates/submissions/
//Time complexity: O(n^3)
//Space complexity: O(n^3)

class Solution {
    
    public List<String> ambiguousCoordinates(String S) {
        List<String> res = new ArrayList();
        int len = S.length();
        S = S.substring(1, len-1);
        len -= 2;
        if(len <= 1) {
            return res;
        }
        for(int i=1; i<len; i++) {
            for(String l : populate(S, 0, i)) {
                for(String r: populate(S, i, len)) {
                    res.add("(" + l + ", " + r + ")");
                }
            }
        }
        
        return res;
    }
    
    private List<String> populate(String S, int s, int e) {
        List<String> cur = new ArrayList();
        for(int i=1; i<=(e-s-1); i++) {
            String l = S.substring(s, s+i);
            String r = S.substring(s+i, e);
            if((l.equals("0") || !l.startsWith("0")) && (!r.endsWith("0"))) {
                cur.add(l + "." + r);
            }            
        }
        if((e-s)==1 || (S.charAt(s) != '0')) {
            cur.add(S.substring(s, e));
        }
        
        return cur;
    }
}
