#Problem link: https://leetcode.com/problems/construct-the-rectangle/submissions/
#Time complexity: O(sqrt(n))
#Space complexity: O(1)

class Solution:
    def constructRectangle(self, area: int) -> List[int]:
        root = int(sqrt(area))
        for i in reversed(range(1, root+1)):
            if area%i == 0:
                l = i
                w = int(area/i)
                if l<w:
                    l,w = w,l
                return [l,w]
        
