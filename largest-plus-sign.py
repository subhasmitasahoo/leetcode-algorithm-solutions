# Problem link: https://leetcode.com/problems/largest-plus-sign/
# Time complexity: O(N*N)
# Space complexity: O(N*N)

class Solution:
    def orderOfLargestPlusSign(self, N: int, mines: List[List[int]]) -> int:
        grid = [[1 for _ in range(N)] for _ in range(N)]
        
        for i,j in mines:
            grid[i][j] = 0
            
        left = [[0 for _ in range(N)] for _ in range(N)]
        right = [[0 for _ in range(N)] for _ in range(N)]
        up = [[0 for _ in range(N)] for _ in range(N)]
        down = [[0 for _ in range(N)] for _ in range(N)]
                       
        for i in range(0, N):
            for j in range(0, N):
                if grid[i][j] == 1:
                    left[i][j] = (left[i][j-1] if j>0 else 0) + 1
                    up[i][j] = (up[i-1][j] if i>0 else 0) + 1
                    
        for i in reversed(range(0, N)):
            for j in reversed(range(0, N)):
                if grid[i][j] == 1:
                    right[i][j] = (right[i][j+1] if j<N-1 else 0) + 1
                    down[i][j] = (down[i+1][j] if i<N-1 else 0) + 1
        res = 0
        for i in range(0, N):
            for j in range(0, N):
                res = max(res, min(left[i][j], min(right[i][j], min(up[i][j], down[i][j]))))        
        return res
