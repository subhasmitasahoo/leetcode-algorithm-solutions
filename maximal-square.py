# Problem link: https://leetcode.com/problems/maximal-square/
# Time complexity: O(m*n)
# Space complexity: O(n)

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        rsz = len(matrix)
        if rsz == 0:
            return 0
        csz = len(matrix[0])
        if csz == 0:
            return 0
        res = [0]*(csz+1)
        maxi = 0
        for i in range(0, rsz):
            prev = 0
            for j in range(0, csz):
                temp = res[j+1]
                if matrix[i][j] == '1':
                    res[j+1] = min(prev, min(res[j], res[j+1])) + 1
                    maxi = max(maxi, res[j+1])
                else:
                    res[j+1] = 0
                prev = temp
                #print(str(i) + " " + str(j) + " : " + str(res[j+1]))
        
        return maxi*maxi
        
