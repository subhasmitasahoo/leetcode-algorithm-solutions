//Problem link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
//Time complexity: O(n)
//Space complexity: O(1), considering the character set size is fixed.

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> m = new HashMap();
        int l = 0;
        int r = 0;
        int res = 0;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            m.putIfAbsent(ch, 0);
            m.put(ch, m.get(ch)+1);
            while(m.get(ch) > 1) {
                char pch = s.charAt(l++);
                m.put(pch, m.get(pch)-1);
            }
            res = Math.max(res, i-l+1);
        }
        return res;
    }
}
