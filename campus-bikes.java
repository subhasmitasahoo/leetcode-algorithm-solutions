//Problem link: https://leetcode.com/problems/campus-bikes/
//Time complexity: O(n*mlog(n*m))
//Space complexity: O(n*m)

class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        List<int[]> temp = new ArrayList();
        for(int i=0; i<workers.length; i++) {
            for(int j=0; j<bikes.length; j++) {
                temp.add(new int[]{i,j, Math.abs(workers[i][0]-bikes[j][0]) + Math.abs(workers[i][1]-bikes[j][1])});
            }
        }
        
        Collections.sort(temp, new bikesComparator());
        
        int[] res = new int[workers.length];
        Arrays.fill(res, -1);
        boolean[] vis = new boolean[bikes.length];
        
        for(int[] t: temp) {
            if(res[t[0]]==-1 && !vis[t[1]]) {
                res[t[0]] = t[1];
                vis[t[1]] = true;
            }
        }
        return res;
    }
    
    private class bikesComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            if(a[2] != b[2]) {
                return Integer.compare(a[2], b[2]);
            }
            
            if(a[0]!=b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        }
    }
    
}
