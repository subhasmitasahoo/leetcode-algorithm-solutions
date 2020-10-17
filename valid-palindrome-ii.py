# Problem link: https://leetcode.com/problems/valid-palindrome-ii/
# Time complexity: O(n)
# Space complexity: O(1)

class Solution:
    
    def isPalin(self, s, i, j):
        while i<j and s[i] == s[j]:
            i += 1
            j -= 1
        return i>=j
    
    def validPalindrome(self, s: str) -> bool:
        i = 0
        j = len(s)-1
        
        while i<j and s[i] == s[j]:
            i += 1
            j -= 1
            
        if i<j:
            return self.isPalin(s, i+1, j) or self.isPalin(s, i, j-1)
        
        return True
            
        
