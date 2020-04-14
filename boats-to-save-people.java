//Problem link: https://leetcode.com/problems/boats-to-save-people/
//Time complexity: O(nlogn)
//Space complexity: O(1)

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        
        int l = 0, h = people.length-1;
        int ans = 0;
        
        while(l<=h) {
            if(l==h) {
                ans++;
                break;
            }
            if(people[l]+people[h] <= limit) {
                ans++;
                l++;
                h--;
            } else {
                ans++;
                h--;
            }
        }
        return ans;
    }
}
