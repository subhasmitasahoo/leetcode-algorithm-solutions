# Problem link: https://leetcode.com/problems/longest-common-prefix/submissions/
# Time complexity: O(m*n), m = no. of words, n = min. length among all words
# Space complexity: O(n)

class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if len(strs) == 0:
            return ""
        
        res = ""
        for i in range(len(strs[0])):  
            for j in range(1, len(strs)):
                if i >= len(strs[j]) or strs[j][i] != strs[0][i]:
                    return res
            res += strs[0][i]
            print(res)
        
        return res
            
        
