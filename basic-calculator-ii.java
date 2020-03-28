//Problem link: https://leetcode.com/problems/basic-calculator-ii/
//Time complexity: O(n)
//Space complexity: O(n)

class Solution {
    public int calculate(String s) {
        Stack<Integer> num = new Stack();
        Stack<Character> op = new Stack();
        
        int cn = 0;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == ' ') {
                continue;
            }
            if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                num.push(cn);
                while(!op.isEmpty() && ((op.peek() == '/' || op.peek() == '*') ||((op.peek() == '+' || op.peek() == '-') && (ch == '+' || ch=='-')))) {
                    int n2 = num.pop();
                    int n1 = num.pop();
                    char sign = op.pop();
                    num.push(getRes(n1, n2, sign));
                } 
                cn = 0;
                op.push(ch);
            } else {
                cn = cn*10 + (ch-'0');
            }
        }
        num.push(cn);
        
        while(!op.isEmpty()) {
            int n2 = num.pop();
            char sign = op.pop();
            int n1 = num.pop();            
            num.push(getRes(n1, n2, sign));
        }
        return num.peek();
    }
    
    private int getRes(int n1, int n2, char op) {
        switch(op) {
            case '+': return n1 + n2;
            case '-': return n1 - n2;
            case '*': return n1*n2;
            case '/': return n1/n2;
        }
        return 0;
    }
}
