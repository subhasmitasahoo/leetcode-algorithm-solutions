# Problem link: https://leetcode.com/problems/paint-house/
# Time complexity: O(n)
# Space complexity: O(n)

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        mini = 0
        for i in range(len(costs)):
            for j in range(len(costs[i])):
                if i>0:
                    costs[i][j] += min(costs[i-1][(j+1)%3], costs[i-1][(j+2)%3])
                if i == len(costs)-1:
                    mini = min(mini, costs[i][j]) if mini else costs[i][j]
        return mini
                
        
