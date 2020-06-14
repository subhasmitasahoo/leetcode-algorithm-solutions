class Solution:
    def minAvailableDuration(self, slots1: List[List[int]], slots2: List[List[int]], duration: int) -> List[int]:
        len1 = len(slots1)
        len2 = len(slots2)
        
        if len1==0 or len2==0:
            return []
        
        slots1 = sorted(slots1, key=lambda x:x[0])
        slots2 = sorted(slots2, key=lambda x:x[0])
        
        i,j = 0,0
        
        while i<len1 and j<len2:
            dur = self.intersect(slots1[i], slots2[j])
            if dur>=duration:
                s = max(slots1[i][0], slots2[j][0])
                return [s, s+duration]
            if slots1[i][0] < slots2[j][0]:
                i += 1
            else:
                j += 1
                
        return []
    
    def intersect(self, slot1, slot2):
        s = max(slot1[0], slot2[0])
        e = min(slot1[1], slot2[1])
        return e-s
                
        
