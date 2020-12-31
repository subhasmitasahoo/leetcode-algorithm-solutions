// Problem link: https://leetcode.com/problems/string-compression/
// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
public:
    int compress(vector<char>& chars) {
        int sz = chars.size();
        int ci = 0;
        int cnt = 0;
        for(int i=0; i<chars.size(); i++) {
            if(i>0 && chars[i] != chars[i-1]) {
                countAndUpdate(chars, ci, i, cnt);
            }
            cnt++;
        }
        countAndUpdate(chars, ci, sz, cnt);
        return ci;
    }
    
    void countAndUpdate(vector<char> &chars, int &ci, int i, int &cnt) {
        chars[ci++] = chars[i-1];
        int bi = ci;
        if(cnt > 1) {
            while(cnt > 0) {
            chars[ci++] = (char)((cnt%10)+'0');
            cnt/=10;
            }
            reverse(chars.begin()+bi, chars.begin()+ci);
        } else {
            cnt = 0;
        }
    }
};
