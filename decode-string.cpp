// Problem link: https://leetcode.com/problems/decode-string/
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
public:
    string decodeString(string s) {
        stack<string> temp;
        
        int i = 0;
        while(i < s.length()) {
            if(s[i] == ']') {
                doProcess(temp);
            } else {
                temp.push(string(1, s[i]));
            }
            i++;
        }
        string res = "";
        while(!temp.empty()) {
            res = temp.top() + res;
            temp.pop();
        }
        return res;
    }
    
    void doProcess(stack<string> & stk) {
        string text;
        int num = 0;
        while(stk.top() != "[") {
            //cout<<stk.top()<<endl;
            text = stk.top() + text;
            stk.pop();
        }
        stk.pop();
        int base = 1;
       //cout<<"stk.top()"<<stk.top()<<endl;
        while(!stk.empty() && stk.top() >= "0" && stk.top() <= "9") {
            num = stoi(stk.top())*base + num;
            base *= 10;
            stk.pop();
        }
        //cout<<"num: "<<num<<endl;
        string res = text;
        for(int i=0; i<num-1; i++) {
            res += text;
        }
        stk.push(res);
    }
};
