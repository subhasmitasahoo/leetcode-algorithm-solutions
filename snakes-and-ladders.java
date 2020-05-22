//Problem link: https://leetcode.com/problems/snakes-and-ladders/submissions/
//Time complexity: O(n*n)
//Space complexity: O(n*n)

class Solution {
    public int snakesAndLadders(int[][] board) {
        int sz = board.length;
        if(sz == 0) {
            return 0;
        }
        
        int target = sz*sz-1;
        
        if(target == 0) {
            return 0;
        }
        
        Map<Integer, Integer> steps = new HashMap();
        
        Queue<Integer> q = new LinkedList();
        q.add(0);
        steps.put(0, 0);
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int i=1; i<=6; i++) {
                int temp = cur + i;
                int rind = temp/sz;
                int cind = temp%sz;
                if(rind %2 != 0) {
                    cind = sz-cind-1;
                }
                rind = sz-rind-1;
                if(board[rind][cind] != -1) {
                    temp = board[rind][cind]-1;
                }
                if(steps.containsKey(temp)) {
                    continue;
                }
                q.add(temp);
                steps.put(temp, steps.get(cur)+1);
                if(temp == target) {
                    return steps.get(temp);
                }
            }
        }
        return -1;
    }
}
