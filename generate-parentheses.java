//Problem link: https://leetcode.com/problems/generate-parentheses/solution/
//Time/space complexity: Didn't calculate

class Solution {
    Map<Integer, List<String>> res = new HashMap();
    public List<String> generateParenthesis(int n) {
        Set<String> cur = new HashSet();
        if(n==0) {
            return new ArrayList();
        }
        if(n==1) {
            cur.add("()");
        }
        if(res.containsKey(n)) {
            return res.get(n);
        }
        for(int i=1; i<=n/2; i++) {
            for(String s: generateParenthesis(i)) {
                for(String t: generateParenthesis(n-i)) {
                    cur.add(s+t);
                    cur.add(t+s);
                    if(i==1) {
                        cur.add("(" + t + ")");
                    }
                }
            }
        }
        List<String> ans = new ArrayList<String>(cur);
        res.put(n, ans);
        return ans;
    }
}
