# Problem link: https://leetcode.com/problems/verifying-an-alien-dictionary/
# Time complexity: O(n)
# Space complexity: O(1)

class Solution:
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        ordered = {}
        i = 0
        for c in order:
            ordered[c] = i
            i += 1
        
        for i in range(len(words)-1):
            cur = words[i]
            nex = words[i+1]
            
            flag = False
            for j in range(min(len(cur), len(nex))):
                if ordered[cur[j]] > ordered[nex[j]]:
                    return False
                elif ordered[cur[j]] < ordered[nex[j]]:
                    flag = True
                    break
                
            if not flag and len(cur) > len(nex):
                return False
            
        return True
