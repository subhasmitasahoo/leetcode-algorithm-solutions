//Time complexity: O(sum(words length))
//Space complexity: O(sum(words length)*26)

class WordDictionary {
    
    class Trie {
        Trie[] next;
        boolean isLeaf;
        
        Trie() {
            next = new Trie[26];
            isLeaf = false;
        }
    
    }
    
    Trie head;

    /** Initialize your data structure here. */
    public WordDictionary() {
        head = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trie cur = head;
        for(char ch: word.toCharArray()) {
            if(cur.next[ch-'a'] == null) {
                cur.next[ch-'a'] = new Trie();
            }
            cur = cur.next[ch-'a'];
        }
        cur.isLeaf = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        Trie cur = head;
        return searchTrie(word, cur, 0);
    }
    
    private boolean searchTrie(String word, Trie cur, int index) {
         if(cur == null) {
            return false;
        }
        
        char ch = word.charAt(index);
        
        if(index == word.length() -1) {
            if(ch != '.') {
                if(cur.next[ch-'a'] != null && cur.next[ch-'a'].isLeaf) {
                    return true;
                }
                return false;
            } else {
                for(int i=0; i<26; i++) {
                    if(cur.next[i] != null && cur.next[i].isLeaf) {
                        return true;
                }
                }
                return false;
            }
        }
        
        if(ch != '.') {
            return searchTrie(word, cur.next[ch-'a'], index+1);
        } else {
            for(int i=0; i<26; i++) {
                if(searchTrie(word, cur.next[i], index+1))
                    return true;
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
