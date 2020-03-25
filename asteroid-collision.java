//Problem link: https://leetcode.com/problems/asteroid-collision/
//Time complexity: O(n)
//Space complexity: O(n)

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack();
        
        for(int a: asteroids) {
            if(a<0) {
                boolean isPush = true;
                while(!st.isEmpty()) {
                    int cur = st.peek();
                    if(cur<0) {
                        break;
                    }
                    if(cur > -a) {
                        isPush = false;
                        break;
                    }
                    st.pop();
                    if(cur == -a) {
                        isPush = false;
                        break;
                    }
                }
                if(isPush) {
                    st.push(a);
                }
            } else {
                st.push(a);
            }
        }
        int[] res = new int[st.size()];
        int ind = res.length-1;
        while(!st.isEmpty()) {
            res[ind--] = st.pop();
        }
        return res;
    }
}
