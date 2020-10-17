# Problem link: https://leetcode.com/problems/integer-to-roman/submissions/
# Time complexity: O(1)
# Space complexity: O(1)

class Solution:
    def intToRoman(self, num: int) -> str:
        dTor = {1:"I", 4:"IV", 5:"V", 9:"IX", 10:"X", 40:"XL", 50:"L", 90:"XC", 100:"C", 400:"CD", 500:"D", 900:"CM", 1000:"M"}
        
        res = ""
        
        base = 1
        while num > 0:
            rem = int(num%10)
            num/=10
            
            cnt = rem
            rem *= base
            
            if rem in dTor:
                res += dTor[rem][::-1]
            else:
                cur = ""
                if cnt >= 5:
                    cur += dTor[5*base]
                    cnt -= 5
                for i in range(cnt):
                    cur += dTor[base]
                res += cur[::-1]
            
            base *= 10
        return res[::-1]
            
            
            
            
            
            
            
        
