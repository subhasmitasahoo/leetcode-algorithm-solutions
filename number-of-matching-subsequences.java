//Problem link: https://leetcode.com/problems/number-of-matching-subsequences/
//Time complexity: O(S.length + Sum(words.length))
//Space complexity: O(Sum(words.length))
class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        List<Node>[] str = new ArrayList[26];
        int res = 0;
        for(int i=0; i<26; i++) {
            str[i] = new ArrayList<Node>();
        }
        for(String w: words) {
            str[w.charAt(0)-'a'].add(new Node(w, 0));
        }
        
        for(char c: S.toCharArray()) {
            List<Node> cur = str[c-'a'];
            str[c-'a'] = new ArrayList();
            for(Node temp: cur) {
                temp.index++;
                if(temp.index == temp.val.length()) {
                    res++;
                } else {
                    str[temp.val.charAt(temp.index)-'a'].add(temp);
                }
            }
        }
        return res;
    }
    
    private class Node {
        String val;
        int index;
        
        Node(String val, int index) {
            this.val = val;
            this.index = index;
        }
    } 
}
