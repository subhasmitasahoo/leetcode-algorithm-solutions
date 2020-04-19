//Problem link: https://leetcode.com/problems/minimum-area-rectangle/submissions/
//Time complexity: O(n*n)
//Space complexity: O(n)

class Solution {
    public int minAreaRect(int[][] points) {
        Set<Integer> s = new HashSet();
        
        for(int[] p: points) {
            s.add(p[0] + p[1]*40001);
        }
        
        int res = Integer.MAX_VALUE;
        
        for(int i=0; i<points.length; i++) {
            for(int j=i+1; j<points.length; j++) {
                if(points[i][0] != points[j][0] && points[i][1] != points[j][1]) {
                    if(s.contains(points[i][0] + points[j][1]*40001) && s.contains(points[j][0] + points[i][1]*40001)) {
                        res = Math.min(res, Math.abs((points[i][0]-points[j][0]) * (points[i][1] - points[j][1])));
                    }
                }
            }
        }
        return res != Integer.MAX_VALUE ? res : 0;
    }
}
