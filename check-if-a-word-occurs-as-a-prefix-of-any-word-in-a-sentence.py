#Problem link: https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
#Time complexity: O(len(sentence))
#Space complexity: O(len(sentence))

class Trie:
        def __init__(self,ch:str, index:int):
            self.char = ch
            self.children = {}
            self.index = index
        
        def add(self, word:str, index:int):
            node = self
            for ch in word:
                if ch not in node.children:
                    node.children[ch] = Trie(ch, index)
                node = node.children[ch]
        
        def search(self, prefix:str) -> int:
            node = self
            for ch in prefix:
                if ch not in node.children:
                    return -1
                node = node.children[ch]
            return node.index
class Solution: 
    def isPrefixOfWord(self, sentence: str, searchWord: str) -> int:
        words = sentence.split(" ")
        root = Trie(" ", -1)
        index = 1
        for w in words:
            root.add(w, index)
            index += 1
        return root.search(searchWord)
            
        
        
