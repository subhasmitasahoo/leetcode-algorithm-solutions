# Problem link: https://leetcode.com/problems/roman-to-integer/
# Time complexity: O(n)
# Space complexity: O(1)

class Solution:
    def romanToInt(self, s: str) -> int:
        romToDec = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C':100, 'D': 500, 'M':1000}
        
        res = 0
        
        for i in range(len(s)):
            res += romToDec[s[i]]
            if i>0 and romToDec[s[i]] > romToDec[s[i-1]]:
                res -= 2*romToDec[s[i-1]]
        
        return res
        
