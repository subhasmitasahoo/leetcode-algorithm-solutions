#Problem link: https://leetcode.com/problems/count-primes/
#Time complexity: O(nloglogn)
#Space complexity: O(n)

class Solution:
    def countPrimes(self, n: int) -> int:
        if n<2:
            return 0
        soe = [True]*(n)
        soe[0] = soe[1] = False
        res = 0
        for i in range(2,n):
            if soe[i]:
                res += 1
                mul = 2
                while i*mul < n:
                    soe[i*mul] = False
                    mul += 1 
        return res
