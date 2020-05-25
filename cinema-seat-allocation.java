//Problem link: https://leetcode.com/problems/cinema-seat-allocation/
//Time complexity: O(n)
//Space complexity: O(n)

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int ans = 0;
        Map<Integer, Set<Integer>> res = new HashMap();
        
        for(int i=0; i<reservedSeats.length; i++) {
            if(reservedSeats[i][1] == 1 || reservedSeats[i][1] == 10) {
                continue;
            }
            res.computeIfAbsent(reservedSeats[i][0], x -> new HashSet()).add(reservedSeats[i][1]);
        }
        ans += (n-res.size())*2;
        for(int i: res.keySet()) {
            Set<Integer> temp = res.get(i);
            if(!temp.contains(2) && !temp.contains(3)  && !temp.contains(4)  && !temp.contains(5)) {
                ans ++;
            } else if(!temp.contains(4) && !temp.contains(5)  && !temp.contains(6)  && !temp.contains(7)) {
                ans ++;
            } else if(!temp.contains(6) && !temp.contains(7)  && !temp.contains(8)  && !temp.contains(9))  {
                ans++;
            }
        }
        return ans;
    }
}
