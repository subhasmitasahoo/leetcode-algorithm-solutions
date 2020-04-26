//Problem link: https://leetcode.com/problems/merge-two-sorted-lists/solution/
//Time complexity: O(m+n)
//Space complexity: O(1)

//NOTE: Unnecessarily I haave made it complicated.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        
        ListNode h1 = l1;
        ListNode h2 = l2;
        ListNode t1 = h1;
        
        if(h1.val > h2.val) {
            t1 = h2;
            h1 = l2;
            h2 = l1;
        }
        
        ListNode prev = null;
        while(h1!=null && h2 != null) {
            if(h1.val <= h2.val) {
                prev = h1;
                h1 = h1.next;
            } else {
                ListNode temp = h2.next;
                h2.next = h1;
                prev.next = h2;
                prev = h2;
                h2 = temp;
            }
        }
        if(h2 != null) {
            prev.next = h2;
        }
        
        return t1;
    }
}
