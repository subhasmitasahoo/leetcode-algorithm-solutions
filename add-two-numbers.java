//Time complexity: O(max(len1,len2))
//Space complexity: O(1)

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
        
        int c = 0;
        ListNode temp = l1, prev = null;
        while(temp!=null || l2!=null || c>0) {
            int curSum = (temp!=null ? temp.val: 0) + (l2!=null ? l2.val : 0) + c;
            if(temp != null) {
                temp.val = curSum % 10;
            } else {
                temp = new ListNode(curSum%10);
                prev.next = temp;
            }
            prev = temp;
            temp = temp.next;
            if(l2 != null) {
                l2 = l2.next;
            }
            c = curSum/10;
        }
        return l1;
    }
}
