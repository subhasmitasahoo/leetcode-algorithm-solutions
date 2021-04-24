class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.length() != t.length()) {
            return false;
        }
        vector<int> track(26, 0);
        for(char c: s) {
            track[c-'a']++;
        }
        
        for(char c: t) {
            if(track[c-'a'] == 0) {
                return false;
            }
            track[c-'a']--;
        }
        return true;
    }
};
