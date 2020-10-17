# Problem link: https://leetcode.com/problems/partition-labels/
# Time complexity: O(n)
# Space complexity: O(1)

class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        let_ind = {}
        
        ind = 0
        for s in S:
            let_ind[s] = ind
            ind += 1
        
        ind = 0
        res = []
        maxi = 0
        prev = 0
        while ind < len(S):
            if ind > maxi:
                res.append(maxi-prev+1)
                prev = ind
                maxi = ind
            maxi = max(maxi, let_ind[S[ind]])
            ind += 1
        res.append(maxi-prev+1) 
        return res
        
