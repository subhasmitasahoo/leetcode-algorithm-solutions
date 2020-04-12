//Problem link: https://leetcode.com/problems/perfect-squares/
//Time complexity: O(sqrt(n))
//Space complexity: O(1)

//Hint (Provided by Leetcode)
//1. Lagrange's four-square theorem: every natural number can be represented by sum of four integer squares
//2. Three square theorem: A positive integer can be expressed as sum of three squares, if N != Pow(4,k)*(8*m + 7), k,m are integers.

class Solution {
    public int numSquares(int n) {
        return getSqr(n);
    }
    
    private boolean isSqr(int n) {
        int k = (int) Math.sqrt(n);
        return k*k == n;
    }
    
    private int getSqr(int n) {
        while(n%4 == 0) {
            n/=4;
        }
        if(n%8 == 7) {
            return 4;
        }
        
        if(isSqr(n)) {
            return 1;
        }
        
        for(int i=1; i*i<=n; i++) {
            if(isSqr(n-i*i)) {
                return 2;
            }
        }
        return 3;
    }
}
