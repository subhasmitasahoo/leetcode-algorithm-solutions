# Problem link: https://leetcode.com/problems/search-a-2d-matrix-ii/
# Time complexity: O(m+n)
# Space complexity: O(1)

class Solution:
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        rlen = len(matrix)
        if rlen==0:
            return False
        clen = len(matrix[0])
        
        i,j = 0,clen-1
        while i<rlen and j>=0:
            if matrix[i][j] == target:
                return True
            if matrix[i][j] < target:
                i+=1
            else:
                j-=1
        return False
        
