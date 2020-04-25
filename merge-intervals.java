//Problem link: https://leetcode.com/problems/merge-intervals/
//Time complexity: O(nlogn)
//Space complexity: O(n)

class Solution {
    public int[][] merge(int[][] intervals) {
        Collections.sort(Arrays.asList(intervals), new IntervalComparator());
        
        List<int[]> res = new ArrayList();
        
        int s = -1;
        int e = -1;
        for(int[] i : intervals) {
            if(s==-1) {
                s = i[0];
                e = i[1];
            } else if(e>=i[0]) {
                e = Math.max(e, i[1]);
            } else {
                res.add(new int[]{s, e});
                s = i[0];
                e = i[1];
            }   
        }
        if(s != -1) {
            res.add(new int[]{s,e});
        }
        return res.toArray(new int[res.size()][]);
    }
    
    private class IntervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            if(a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        }
    }
}
