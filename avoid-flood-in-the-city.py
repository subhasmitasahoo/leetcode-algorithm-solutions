# Problem link: https://leetcode.com/problems/avoid-flood-in-the-city/
# Time complexity: O(nlogn)
# Space complexity: O(n)
from sortedcontainers import SortedList as sl
class Solution:
    def avoidFlood(self, rains: List[int]) -> List[int]:
        res = [-1]*(len(rains))
        no_rain = sl()
        has_rain = dict()
        for i in range(len(rains)):
            if rains[i] == 0:
                no_rain.add(i)
            else:
                if rains[i] in has_rain:
                    if len(no_rain) == 0:
                        return []
                    index = no_rain.bisect_left(has_rain[rains[i]])
                    if index < len(no_rain):
                        #print("ll"+str(index))
                        res[no_rain[index]] = rains[i]
                        no_rain.remove(no_rain[index])
                        has_rain[rains[i]] = i
                    else:
                        return []
                else:
                    has_rain[rains[i]] = i
        for i in range(len(no_rain)):
            res[no_rain[i]] = 1
        return res
                    
        
