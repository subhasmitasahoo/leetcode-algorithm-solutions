# problem link: https://leetcode.com/problems/counting-bits/submissions/
# Time complexity: O(n)
# Space complexity: O(n)

class Solution:
    def countBits(self, num: int) -> List[int]:
        res = []
        res.append(0)
        if num==0:
            return res
        res.append(1)
        
        cbase = 1
        
        for i in range(2, num+1):
            if i == 2*cbase:
                cbase *= 2
                res.append(1)
            else:
                res.append(1+res[i-cbase])
        
        return res
        
        
