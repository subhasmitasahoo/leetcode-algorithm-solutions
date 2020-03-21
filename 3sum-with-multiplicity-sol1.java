class Solution {
    public int threeSumMulti(int[] A, int target) {
        Arrays.sort(A);
        long MOD = 1000000007;
        long res = 0;
        
        for(int i=0; i<A.length; i++) {
            int j = i+1; 
            int k = A.length-1;
            int req = target-A[i];
            while(j<k) {
                if(A[j]+A[k] < req) {
                    j++;
                } else if(A[j]+A[k] > req){
                    k--;
                } else {
                    if(A[j] == A[k]) { //Corner case that must be handled.
                        int cnt = k-j;
                        res += ((cnt*(cnt+1))/2)%MOD;
                        res %= MOD;
                        break;
                    } else {
                        int lcnt = 0, rcnt = 0;
                        while(A[j] == A[j+lcnt]) {
                            lcnt++;
                        }
                        
                        while(A[k] == A[k-rcnt]) {
                            rcnt++;
                        }
                        res += (lcnt*rcnt)%MOD;
                        res %= MOD;
                        j = j+lcnt;
                        k = k-rcnt;
                    }
                }
            }
        }
        return (int)res;
    }
}
