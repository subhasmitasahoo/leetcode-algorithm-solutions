# Problem link: https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
# Time complexity: O(n*n)
# Time complexity: O(n*n)

class Solution:
    def mctFromLeafValues(self, arr: List[int]) -> int:
        self.store = []
        for i in range(len(arr)):
            temp = []
            for j in range(len(arr)):
                temp.append({"max":-1, "sum":-1})
            self.store.append(temp)
            
        self.traverse(arr, 0, len(arr)-1)
        return self.store[0][len(arr)-1]["sum"]
    
    def traverse(self, arr, left, right):
        if self.store[left][right]["sum"] >= 0:
            return
        if left == right:
            self.store[left][right] = {"max":arr[left], "sum":0}
            return
            
        cur = {"max":-1, "sum":-1}
        
        for m in range(left, right):
            self.traverse(arr, left, m)
            self.traverse(arr, m+1, right)
            
            lval = self.store[left][m]
            rval = self.store[m+1][right]
            
#             print(" lval left: " + str(left) + " right: " + str(m) + " sum: " + str(lval["sum"]) + " max. " + str(lval["max"]))
            
#             print(" rval left: " + str(m+1) + " right: " + str(right) + " sum: " + str(rval["sum"]) + " max. " + str(rval["max"]))
            
            temps = lval["sum"] + rval["sum"] + lval["max"]*rval["max"]
            
            if cur["sum"] == -1 or cur["sum"] > temps:
                cur["sum"] = temps
                cur["max"] = max(lval["max"],rval["max"])
        
        self.store[left][right]["sum"] = cur["sum"]
        self.store[left][right]["max"] = cur["max"]
        # print("up left: " + str(left) + " right: " + str(right) + " val: " + str(self.store[left][right]["sum"]))
            
        
