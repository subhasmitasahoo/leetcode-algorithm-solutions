# Problem link: https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/
# Time complexity: O(m*n)
# Space complexity: O(m*n), to store the result.

class Solution:
    def restoreMatrix(self, rowSum: List[int], colSum: List[int]) -> List[List[int]]:
        res = []
        
        for r in range(len(rowSum)):
            cur = [rowSum[r]]
            for c in range(1, len(colSum)):
                cur.append(0)
            res.append(cur)
            
        for c in range(len(colSum)):
            cur = 0
            for r in range(len(rowSum)):
                cur += res[r][c]
                if cur > colSum[c]:
                    res[r][c] -= (cur - colSum[c])
                    res[r][c+1] += (cur - colSum[c])
                    cur = colSum[c]
        return res
            
        
