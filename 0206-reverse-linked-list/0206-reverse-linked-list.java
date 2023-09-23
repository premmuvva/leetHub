/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, temp = head, temp1;
        if(temp == null) return temp;
        while(temp.next!=null) {
            temp1 = temp;
            temp = temp.next;
            temp1.next = pre;
            pre = temp1;
        }
        temp.next = pre;
        return temp;
    }
}