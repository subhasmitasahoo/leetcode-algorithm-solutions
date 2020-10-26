# Problem link: https://leetcode.com/problems/allocate-mailboxes/
# Time complexity: O(n*n*k)
# Space complexity: O(n*n)

class Solution:
    def getMedian(self, houses, i, j):
        cnt = (j-i+1)
        if cnt%2 == 0:
            return (houses[(i+j)//2] + houses[(i+j)//2 + 1])//2
        return houses[(i+j)//2]
    
    def populateMedian(self, houses, dist):
        for i in range(len(houses)):
            for j in range(i, len(houses)):
                med = self.getMedian(houses, i, j)
                sums = 0
                for k in range(i, j+1):
                    sums += abs(med - houses[k])
                dist[i][j] = sums
                
                print("i. " + str(i) + " j. " + str(j) + " val: " + str(dist[i][j]))
    
    
    def minDistance(self, houses: List[int], k: int) -> int:
        houses.sort()
        sz = len(houses)
        store = [[float('inf') for i in range(k+3)] for m in range(sz+3)]
        dist = [[float('inf') for i in range(sz+3)] for m in range(sz+3)]
        self.populateMedian(houses, dist)
        
        for m in range(1, k+1):
            for i in range(0, sz):
                if m == sz-i:
                    store[i][m] = 0
                elif m < sz-i:
                    if m==1:
                        store[i][m] = dist[i][sz-1]
                    for x in range(i, sz-1):
                        store[i][m] = min(store[i][m], dist[i][x]+store[x+1][m-1])
#                         print("i. " + str(i) + " m. " + str(m) + " val: " + str(store[i][m]))
        
        return store[0][k]
