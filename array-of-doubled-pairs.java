//Problem link: https://leetcode.com/problems/array-of-doubled-pairs/

//Time complexity: O(nlogn)
//Space complexity: O(n)

class Solution {
    public boolean canReorderDoubled(int[] A) {
        Map<Integer, Integer> cnt = new TreeMap();
        
        for(int a: A) {
            int c = 0;
            if(cnt.containsKey(a)) {
                c = cnt.get(a);
            }
            cnt.put(a, c+1);
        }
        
        for(Integer k: cnt.keySet()) {
            int ccnt = cnt.get(k);
            if(ccnt == 0) {
                continue;
            }
            int nk = k<0 ? k/2 : k*2;
            if(k == 0) {
                if(ccnt%2 != 0) {
                    return false;
                }
                cnt.put(0, 0);
                continue;
            }
            if(!cnt.containsKey(nk)) {
                continue;
            }
            int ncnt = cnt.get(nk);
            if(ncnt == 0) {
                continue;
            }
            if(ncnt < ccnt) {
                ccnt -= ncnt;
                ncnt = 0;
            } else {
                ncnt -= ccnt;
                ccnt = 0;
            }            
            cnt.put(k, ccnt);
            cnt.put(nk, ncnt);
        }
        
        for(Integer k: cnt.keySet()) {
            if(cnt.get(k) != 0) {
                return false;
            }
        }
        
        return true;
        
    }
}
