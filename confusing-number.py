#Problem link: https://leetcode.com/problems/confusing-number/
#Time complexity: O(len(number))
#Space complexity: O(len(number))

class Solution:
    def confusingNumber(self, N: int) -> bool:
        reflect = {0:0,1:1,6:9,8:8,9:6}
        temp = str(N)
        length = len(temp)
        
        ne = False
        for i in range(ceil(length/2)):
            if int(temp[i]) not in reflect or int(temp[length-i-1]) not in reflect:
                return False
            if reflect[int(temp[i])] != int(temp[length-i-1]):
                ne = True
        
        return ne
        
        
        
