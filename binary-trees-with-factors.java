//Probleem link: https://leetcode.com/problems/binary-trees-with-factors/submissions/
//Time complexity: O(nlogn + sum(sqrt(ele)))
//Space complexity: O(n)

class Solution {
    public int numFactoredBinaryTrees(int[] A) {
        long MOD = 1000000007;
        Map<Integer, Long> m = new HashMap();
        Arrays.sort(A);
        long res = 0;
        for(int a: A) {
            if(m.containsKey(a)) {
                continue;
            }
            long cur = 1;
            for(int i=1; i*i<=a; i++) {
                if(a%i == 0) {
                    if(m.containsKey(i) && m.containsKey(a/i)) {
                        long temp = (m.get(i)*m.get(a/i))%MOD;
                        if(i != a/i) {
                            temp*=2;
                        }
                        cur = (cur + temp)%MOD;
                    }
                } 
            }
            m.put(a, cur);
        }
        
        for(long a: m.values()) {
            res = (res+a)%MOD;
        }
        return (int)res;
    }
}
