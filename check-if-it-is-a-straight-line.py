#Problem link: https://leetcode.com/problems/check-if-it-is-a-straight-line/submissions/

#Time complexity: O(n)
#Space complexity: O(1)

class Solution:
    def checkStraightLine(self, coordinates: List[List[int]]) -> bool:
        
        isHor = False
        yVal = None
        slope = None
        if coordinates[0][1] == coordinates[1][1]:
            isHor = True
            yVal = coordinates[0][1]
        else:
            slope = (coordinates[0][0] - coordinates[1][0])/(coordinates[0][1] - coordinates[1][1])
            
        for i in range(2, len(coordinates)):
            if isHor:
                if coordinates[i][1] != yVal:
                    return False
            else:
                if coordinates[i-1][1] == coordinates[i][1]:
                    return False
                cslope = (coordinates[i-1][0] - coordinates[i][0])/(coordinates[i-1][1] - coordinates[i][1])
                if cslope != slope:
                    return False
        
        return True
        
