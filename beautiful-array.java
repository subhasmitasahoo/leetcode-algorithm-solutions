//Problem link: https://leetcode.com/problems/beautiful-array/solution/
//Space complexity: O(nlogn)
//Time complexity: O(nlogn)

class Solution {
    Map<Integer, int[]> store = new HashMap();
    public int[] beautifulArray(int N) {
        return create(N);
    }
    
    int[] create(int n) {
        if(store.containsKey(n)) {
            return store.get(n);
        }
        int[] ans = new int[n];
        if(n==1) {
            ans[0] = 1;
            return ans;
        }
        int i = 0;
        for(int a: create((n+1)/2)) {
            ans[i++] = 2*a-1;
        }
        
        for(int a: create(n/2)) {
            ans[i++] = 2*a;
        }
        store.put(n, ans);
        return ans;
    }
}
