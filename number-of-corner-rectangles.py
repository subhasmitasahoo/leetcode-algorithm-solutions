# Problem link: https://leetcode.com/problems/number-of-corner-rectangles/
# Time complexity: O(R*C*C)
# Space complexity: O(C*C)

class Solution:
    def countCornerRectangles(self, grid: List[List[int]]) -> int:
        store = {}
        
        rlen = len(grid)
        clen = len(grid[0])
        
        res = 0
        
        for i in range(rlen):
            for j in range(clen):
                if grid[i][j] == 1:
                    for k in range(j+1, clen):
                        if grid[i][k] == 1:
                            index = j*200 + k
                            cnt = 0
                            if index in store:
                                cnt = store[index]
                            res += cnt
                            store[index] = cnt+1
        return res
