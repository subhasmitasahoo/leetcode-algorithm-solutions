//Problem link: https://leetcode.com/problems/group-anagrams/submissions/
//Time complexity: O(n*m) , n = no. of strings, m = max.length of string 
//Space complexity: O(n*m), n = no. of strings, m = max.length of string 

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<Integer>> m = new HashMap();
        
        int i = 0;
        for(String s: strs) {
            int len = s.length();
            int[] cur = new int[26];
            Arrays.fill(cur, '0');
            for(char ch: s.toCharArray()) {
                cur[ch-'a']++;
            }
            String curs = "";
            for(int j=0; j<26; j++) {
                curs += String.valueOf(cur[j])+"#";
            }
            m.computeIfAbsent(curs, x->new ArrayList()).add(i);
            i++;
        }
        List<List<String>> res = new ArrayList();
        for(List<Integer> l: m.values()) {
            List<String> t = new ArrayList();
            for(int ind: l) {
                t.add(strs[ind]);
            }
            res.add(t);
        }
        return res;
    }
}
