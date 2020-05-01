//Problem link: https://leetcode.com/problems/reordered-power-of-2/
//Time compleexity: O(log(N)^2)
//Spaace complexity: O(1)

class Solution {
    public boolean reorderedPowerOf2(int N) {
        int[] cnt = dig(N);
        
        for(int i=0; i<32; i++) {
            if(Arrays.equals(cnt, dig(1<<i))) {
                return true;
            }
        }
        return false;
    }
    
    int[] dig(int n) {
        int[] digit = new int[10];
        while(n>0) {
            digit[n%10]++;
            n/=10;
        }
        return digit;
    }
}
