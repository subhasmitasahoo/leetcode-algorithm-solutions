//Time complexity: O(NlogN)
//Space complexity: O(N)

class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        
        Arrays.sort(A);
        Stack<Integer> temp = new Stack();
        TreeMap<Integer, List<Integer>> mb = new TreeMap();
        
        for(int i=0; i<B.length; i++) {
            mb.putIfAbsent(B[i], new ArrayList());
            mb.get(B[i]).add(i);
        }
        
        int ind = 0;
        for(int b: mb.keySet()) {
            List<Integer> indices = mb.get(b);
            for(int i=0; i<indices.size(); i++) {
                while(ind<A.length && A[ind] <= b) {
                    temp.push(A[ind]);
                    ind++;
                }
                if(ind<A.length) {
                    B[indices.get(i)] = A[ind];
                    ind++;
                } else {
                    B[indices.get(i)] = temp.pop();
                }
            }
        }
        return B;
    }
}
