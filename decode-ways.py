# Problem link: https://leetcode.com/problems/decode-ways/
# Time complexity: O(n)
# Space complexity: O(1)

class Solution:
    def numDecodings(self, s: str) -> int:
        sz = len(s)
        if sz == 0:
            return 0
        if sz == 1 and s[0] == '0':
            return 0
        prev2 = 1
        prev1 = 0
        if s[0] > '0':
            prev1 = 1
        
        for i in range(1, sz):
            cur = 0
            if s[i] > '0':
                cur += prev1
            
            tmp = int(s[i-1:i+1])
            #print(tmp)
            if tmp > 9 and tmp <= 26:
                cur += prev2
            
            prev2 = prev1
            prev1 = cur
        
        return prev1
