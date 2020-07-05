#Problem link: https://leetcode.com/problems/check-if-n-and-its-double-exist/

#Time complexity: O(n)
#Space complexity: O(n)

class Solution:
    def checkIfExist(self, arr: List[int]) -> bool:
        store = set()
        for a in arr:
            if a*2 in store:
                return True
            if a%2==0 and a/2 in store:
                return True
            store.add(a)
        
        return False
        
