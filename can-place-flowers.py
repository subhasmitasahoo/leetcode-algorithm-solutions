#Problem link: https://leetcode.com/problems/can-place-flowers/

#Time complexity: O(n)
#Space complexity: O(1)

class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        i = 0
        for i in range(len(flowerbed)):
            if(flowerbed[i] == 0 and (i == 0 or flowerbed[i-1] == 0) and (i==len(flowerbed)-1 or flowerbed[i+1] ==0)):
                flowerbed[i] =1
                n -= 1
                if n<=0 :
                    return True
        return n<=0
