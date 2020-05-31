# Problem link: https://leetcode.com/problems/xor-queries-of-a-subarray/
# Time complexity: O(n)
# Space complexity: O(n)

class Solution:
    def xorQueries(self, arr: List[int], queries: List[List[int]]) -> List[int]:
        res = [0 for i in range(len(arr)+1)]
        
        for i in range(0, len(arr)):
            res[i+1] = arr[i] ^ res[i]
            
        return [res[l]^res[h+1] for l,h in queries]
            
        
