//Problem link: https://leetcode.com/problems/break-a-palindrome/submissions/
//Time complexity: O(n)
//Space complexity: O(n) // To store the result 

class Solution {
    public String breakPalindrome(String palindrome) {
        int len = palindrome.length();
        if(len == 1) {
            return "";
        }
        int l = 0;
        
        String res = "";
        while(l<len) {
            char ch = palindrome.charAt(l);
            if(l != len/2 || len%2 != 1) {
                if(ch != 'a') {
                    res += "a" + palindrome.substring(l+1);
                    return res;
                }
            }
            res += String.valueOf(ch);
            l++;
        }
        for(int i=0; i<26; i++) {
            if(palindrome.charAt(len-1) != 'a'+i) {
                return palindrome.substring(0, len-1) + String.valueOf((char)('a'+i));
            }
        }
        return "";
    }
}
