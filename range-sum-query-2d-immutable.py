# Problem link: https://leetcode.com/problems/range-sum-query-2d-immutable/submissions/
# Time complexity: O(m*n)
# space complexity: O(1)

class NumMatrix:
    
    def __init__(self, matrix: List[List[int]]):
        self.rows = len(matrix)
        self.cols = len(matrix[0]) if self.rows>0 else 0 
        
        for i in range(self.rows):
            for j in range(self.cols):
                if j-1 >= 0:
                    matrix[i][j] += matrix[i][j-1]
                if i-1 >= 0:
                    matrix[i][j] += matrix[i-1][j]
                if i-1 >= 0 and j-1 >= 0:
                    matrix[i][j] -= matrix[i-1][j-1]
        
        self.store = matrix

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        res = self.store[row2][col2]
        if row1-1 >= 0:
            res -= self.store[row1-1][col2]
        if col1-1 >= 0:
            res -= self.store[row2][col1-1]
        if row1-1 >= 0 and col1-1 >= 0:
            res += self.store[row1-1][col1-1]
        return res
        
        
        


# Your NumMatrix object will be instantiated and called as such:
# obj = NumMatrix(matrix)
# param_1 = obj.sumRegion(row1,col1,row2,col2)
