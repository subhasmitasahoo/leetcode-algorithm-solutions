#Problem link: https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/
#Time complexity: O(n)
#Space complexity: O(1) , excluding o/p

class Solution:
    def getFreq(self, word:str) -> int:
        mini = min(word)
        cnt = 0
        for w in word:
            if w == mini:
                cnt += 1
        return cnt

    def numSmallerByFrequency(self, queries: List[str], words: List[str]) -> List[int]:

        freq = [0]*20
        res = []

        for w in words:
            freq[self.getFreq(w)] += 1
        
        for i in range(1, 20):
            freq[i] += freq[i-1]

        for q in queries:
            qf = self.getFreq(q)
            res.append(freq[19]-freq[qf])
        
        return res
