#Problem link: https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/submissions/
#Time complexity: O(nlogn)
#Space complexity: O(1)

class Solution:
    
    def noZero(self, a:int) -> bool:
        while a:
            if a%10 == 0:
                return False
            a//=10
        return True
    
    def getNoZeroIntegers(self, n: int) -> List[int]:
        a = 1
        b = n-1
        while True:
            na = self.noZero(a)
            nb = self.noZero(b)
            if na and nb:
                return [a,b]
            a += 1
            b -= 1
    
        
