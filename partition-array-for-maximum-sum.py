# Problem link: https://leetcode.com/problems/partition-array-for-maximum-sum/
# Time complexity: O(n*k)
# Space complexity: O(n)

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        res = [0]*len(arr)
        res[0] = arr[0]
        
        for i in range(1, len(arr)):
            res[i] = res[i-1] + arr[i]
            
            maxi = arr[i]
            for j in range(1, k):
                if i-j < 0:
                    break
                maxi = max(maxi, arr[i-j])
                cur = res[i-j-1] if i-j-1>=0 else 0
                cur += maxi*(j+1)
                res[i] = max(res[i], cur)
            # print("i. " + str(i) + " res. " + str(res[i]))
        
        return res[len(arr)-1]
