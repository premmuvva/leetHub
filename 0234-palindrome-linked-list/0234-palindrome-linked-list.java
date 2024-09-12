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
    public boolean isPalindrome(ListNode head) {
        // if (head.next == null) return true;
        ListNode ans = check(head, head);
        if (ans == null) return true;
        return ans.val == Integer.MAX_VALUE;
        
    }
    
    private ListNode check(ListNode head, ListNode cur) {
        ListNode st;
        if (cur.next == null) {
            st = head;
        } else 
            st = check(head, cur.next);
        if (st.val == cur.val) {
            return st.next;
        }
        head.val = Integer.MAX_VALUE;
        return head;
    }
}