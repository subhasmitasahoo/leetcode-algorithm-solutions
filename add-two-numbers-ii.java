//Time complexity: O(len1 + len2)
//Space complexity: O(max(abs(len1-len2), min(len1, len2))) - stack size

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if(l1 == null) {
            return l2;
        }
        
        if(l2 == null) {
            return l1;
        }
        
        int cnt1 = 0;
        int cnt2 = 0;
        
        ListNode temp = l1;
        while(temp != null) {
            cnt1++;
            temp = temp.next;
        }
        
        temp = l2;
        while(temp != null) {
            cnt2++;
            temp = temp.next;
        }
        
        if(cnt2 > cnt1) {
            temp = l1;
            l1 = l2;
            l2 = temp;
            
            int tc = cnt1;
            cnt1 = cnt2;
            cnt2 = tc;
        }
        
        int diff = cnt1 - cnt2;
        
        temp = l1;
        while(diff>0) {
            temp = temp.next;
            diff--;
        }
        
        int c = addSameLenNumbers(temp, l2);
        c = addDigit(l1, temp, c);
        if(c>0) {
            ListNode n1 = new ListNode(c);
            n1.val = c;
            n1.next = l1;
            l1 = n1;
        }
        return l1;
    }
    
    private int addSameLenNumbers(ListNode l1, ListNode l2) {
        if(l1== null && l2==null) {
            return 0;
        }
        int c = addSameLenNumbers(l1.next, l2.next);
        int sum = l1.val + l2.val + c;
        l1.val = sum%10;
        return sum/10;
    }
    
    private int addDigit(ListNode l1, ListNode temp, int c) {
        if(l1 == temp) {
            return c;
        }
        int cr = addDigit(l1.next, temp, c);
        int sum = l1.val + cr;
        l1.val = sum%10;
        return sum/10;
    }
}
