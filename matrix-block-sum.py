# Problem link: https://leetcode.com/problems/matrix-block-sum/
# Time complexity: O(m*n)
# Space complexity: O(m*n)

class Solution:
 
    def getSum(self, mat, r, c):
        if r<0 or c<0:
            return 0;
        if r>=self.rlen:
            r = self.rlen-1
        if c>= self.clen:
            c = self.clen-1
        return mat[r][c]
        
    def matrixBlockSum(self, mat: List[List[int]], K: int) -> List[List[int]]:
        self.rlen = len(mat)
        self.clen = len(mat[0])
        
        for i in range(self.rlen):
            for j in range(self.clen):
                mat[i][j] += (mat[i][j-1] if j>0 else 0)
        
        for i in range(len(mat)):
            for j in range(len(mat[i])):
                mat[i][j] += (mat[i-1][j] if i>0 else 0)
                
        ans = []
        
        for i in range(0,self.rlen):
            tempArray = []
            for j in range(0,self.clen):
                temp = (self.getSum(mat, i+K, j+K) - self.getSum(mat, i+K, j-K-1) 
                - self.getSum(mat, i-K-1, j+K) + self.getSum(mat, i-K-1, j-K-1))
                tempArray.append(temp)
            ans.append(tempArray)
        
        return ans
        
        
