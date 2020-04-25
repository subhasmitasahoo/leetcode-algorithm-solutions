//Problem link: https://leetcode.com/problems/copy-list-with-random-pointer/
//Time complexity: O(n)
//Space complexity: O(n)

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return head;
        }
        Node temp = head;
        
        while(temp != null) {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }
        
        temp = head;
        while(temp != null) {
            if(temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        
        Node res = head;
        temp = res;
        Node ans = head.next;
        while(temp != null) {
            Node cur = temp.next;
            if(temp.next != null) {
                temp.next = temp.next.next;
            }
            temp = cur;
        }
        return ans;
    }
}
