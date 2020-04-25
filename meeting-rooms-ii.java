//Problem link: https://leetcode.com/problems/meeting-rooms-ii/submissions/
//Time complexity: O(nlogn)
//Space complexity: O(n)

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        List<int[]> temp = new ArrayList();
        for(int[] i: intervals) {
            temp.add(new int[]{i[0], 0});
            temp.add(new int[]{i[1], 1});
        }
        Collections.sort(temp, new IntervalComparator());
        
        int res = 0;
        int cur = 0;
        for(int[] t: temp) {
            if(t[1]==0) {
                cur++;
            } else {
                cur--;
            }
            res = Math.max(res, cur);
        }
        return res;
    }
    
    
    private class IntervalComparator implements Comparator<int[]> {
        
        public int compare(int[] a, int[] b) {
            return a[0]==b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]);
        }
    }
        
    }
