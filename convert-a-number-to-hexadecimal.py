#Problem link: https://leetcode.com/problems/convert-a-number-to-hexadecimal/
#Time complexity: O(log16(n))
#Space complecity: O(1) , excluding o/p

class Solution:
    def toHex(self, num: int) -> str:
        if num<0:
            num = 2**32 + num 
        if num == 0:
            return "0"
        res = ""
        while num>0:
            num, rem = divmod(num, 16)
            res = f'{rem if rem<10 else chr(ord("a")+rem%10)}{res}'
            
        return res
        
