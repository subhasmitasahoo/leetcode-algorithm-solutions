// Problem link: https://leetcode.com/problems/leftmost-column-with-at-least-a-one/
// Time complexity: O(M+N)
// Space complexity: O(1)

/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * class BinaryMatrix {
 *   public:
 *     int get(int row, int col);
 *     vector<int> dimensions();
 * };
 */

class Solution {
public:
    int leftMostColumnWithOne(BinaryMatrix &binaryMatrix) {
        vector<int> dim = binaryMatrix.dimensions();
        
        int r = 0, c = dim[1]-1;
        
        int ans = -1;
        
        while(r<dim[0] && c>= 0) {
            if(binaryMatrix.get(r,c) == 1) {
                ans = c;
                c -= 1;
            } else {
                r += 1;
            }
        }
        return ans;
    }
};
