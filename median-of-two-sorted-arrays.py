# Problem link: https://leetcode.com/problems/median-of-two-sorted-arrays/
# Time complexity: O(log(min(len(num1), len(num2))))
# Space complexity: O(1)

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        len1 = len(nums1)
        len2 = len(nums2)
        
        if len1 > len2:
            return self.findMedianSortedArrays(nums2, nums1)
        
        
        partition = (len1+len2+1)//2
        
        start = 0
        end = len1
        while start <= end:
            partx = (start+end)//2
            party = partition - partx
            
            leftx = nums1[partx-1] if (partx > 0) else float('-inf')
            rightx = nums1[partx] if (partx < len1) else float('inf')
            
            lefty = nums2[party-1] if (party > 0) else float('-inf')
            righty = nums2[party] if (party < len2) else float('inf')
            
            if leftx <= righty and lefty <= rightx:
                if (len1+len2)%2 == 0:
                    return (max(leftx, lefty) + min(rightx, righty))/2.0
                return max(leftx, lefty)
                
            elif leftx > righty:
                end = partx - 1
            else:
                start = partx + 1
        
        
