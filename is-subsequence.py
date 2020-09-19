# Problem link: https://leetcode.com/problems/is-subsequence/
# Time complexity: O(len(t))
# Space complexity: O(1)

class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        ls = len(s)
        lt = len(t)
            
        if ls > lt:
            return False
        
        if s == "":
            return True
        
        i = 0
                
        for j in range(lt):
            if t[j] == s[i]:
                i += 1
                if i == ls:
                    return True
        return False
        
