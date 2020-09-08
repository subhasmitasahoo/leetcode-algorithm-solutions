# Problem link: https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
# Time complexity: O(n)
# Space complexity: O(1) // 2^31

class Solution:
    def findMaximumXOR(self, nums: List[int]) -> int:
        L = len(bin(max(nums)))
        nums = [[(x >> i) & 1 for i in range(L)][::-1] for x in nums]
        self.createTrie(nums)
        return self.getMax(nums)
    
    def getMax(self, nums):
        maxi = 0
        for n in nums:
            cur = 0
            node = self.trie
            for bit in n:
                if 1-bit in node:
                    cur = cur << 1 | 1
                    node = node[1-bit]
                else:
                    cur = cur << 1
                    node = node[bit]
            print(str(n) + " " + str(cur)) 
            maxi = max(maxi, cur)
        return maxi
                
        
    def createTrie(self, nums):
        self.trie = {}
        for n in nums:
            node = self.trie
            for bit in n:
                if not bit in node:
                    node[bit] = {}
                node = node[bit]
        
