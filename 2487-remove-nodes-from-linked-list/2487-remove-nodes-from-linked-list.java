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
    public ListNode removeNodes(ListNode head) {
        return solve(head);
    }
    
    private ListNode solve(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = solve(head.next);
        if (next.val > head.val) 
            return next;
        head.next = next;
        return head;
    }
}