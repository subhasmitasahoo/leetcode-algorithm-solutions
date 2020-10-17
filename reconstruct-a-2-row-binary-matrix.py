# Problem link: https://leetcode.com/problems/reconstruct-a-2-row-binary-matrix/submissions/
# Time complexity: O(n)
# Space complexity: O(n), to store the result. 

class Solution:
    def reconstructMatrix(self, upper: int, lower: int, colsum: List[int]) -> List[List[int]]:
        res = [[0 for i in range(len(colsum))] for j in range(2)]
        
        for i in range(len(colsum)):
            if colsum[i] == 2:
                if upper>0 and lower>0:
                    res[0][i] = res[1][i] = 1
                    upper -= 1
                    lower -= 1
                else:
                    return []
        
        for i in range(len(colsum)):
            if colsum[i] == 1:
                if res[0][i] == 0 and upper>0:
                    res[0][i] = 1
                    upper -= 1
                elif res[1][i] == 0 and lower>0:
                    res[1][i] = 1
                    lower -= 1
                else:
                    return []
        
        if upper>0 or lower>0:
            return []
        return res
                    
                
        
