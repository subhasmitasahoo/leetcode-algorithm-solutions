//Time complexity: O(N**3)
//Space complexity: O(N) - stack space due to recursion

class Solution {
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        int len1 = 1, len2 = 1;
        
        double num1, num2;
        while(len1 < len) {
            if(len1>1) {
                if(num.charAt(0) == '0') {
                    return false;
                }
            }
            num1 = Double.valueOf(num.substring(0,len1));
            len2 = 1;
            while(len1+len2< len) {
                if(len2 > 1) {
                    if(num.charAt(len1) == '0') {
                        break;
                    }
                }
                num2 = Double.valueOf(num.substring(len1, len1+len2));
                if(isAdditive(num1, num2, num.substring(len1+len2))) {
                    return true;
                }
                len2++;
            }
            len1++;
        }
        return false;
    }
    
    private boolean isAdditive(double n1, double n2, String num) {
        // System.out.println(n1+" "+n2+" "+num);
        int len = num.length();
        if(len == 0) {
            return false;
        }
        
        double cur = n1+n2;
        String curs = String.valueOf(cur);
        if(curs.contains(".")) {
            curs = curs.substring(0,curs.indexOf("."));
            // System.out.println(curs);
        }
        int i=0;
        if(curs.length() > 1) {
            if(num.charAt(0) == '0') {
                return false;
            }
        }
        while(i<curs.length()) {
            if(i == len) {
                return false;
            }
            if(num.charAt(i) != curs.charAt(i)) {
                return false;
            }
            i++;
        }
        if(i==len) {
            return true;
        }
        return isAdditive(n2, cur, num.substring(i));
    }
}
