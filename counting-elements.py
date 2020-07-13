#Problem link: https://leetcode.com/problems/counting-elements/solution/
#Time complexity: O(n)
#Space complexity: O(n)

class Solution:
    def countElements(self, arr: List[int]) -> int:
        temp = [0]*1001
        for a in arr:
            temp[a] += 1
        
        res = 0
        for a in range(1001):
            if a+1 <= 1000 and temp[a+1]>0:
                res += temp[a]
        return res
                
                
