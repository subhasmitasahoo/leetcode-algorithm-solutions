#Problem link: https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/submissions/

#Time complexity: O(n)
#Space complexity: O(1)

class Solution:
    def canMakeArithmeticProgression(self, arr: List[int]) -> bool:
        mini = min(arr)
        maxi = max(arr)
        size = len(arr)
        
        if maxi==mini or size<=2:
            return True
        if (maxi-mini)%(size-1) != 0:
            return False
        
        diff = (maxi-mini)/(size-1)
        
        i = 0
        
        while i<size:
            if arr[i] == mini + i*diff:
                i += 1
            elif (arr[i]-mini)%diff != 0:
                return False
            else:
                pos = int((arr[i]-mini)/diff)
                if arr[pos] == arr[i]:
                    return False
                arr[pos], arr[i] = arr[i], arr[pos]
        
        return True
                
        
