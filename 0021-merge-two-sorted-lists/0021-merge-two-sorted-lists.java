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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode ans = new ListNode();
        ListNode head = ans, pre = new ListNode();
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                head.val = list2.val;
                list2 = list2.next;
            } else {
                head.val = list1.val;
                list1 = list1.next;
            }
            pre = head;
            head.next = new ListNode();
            head = head.next;
        }
        if (list1 != null) {
            pre.next = list1;
        }
        if (list2 != null) { 
            pre.next = list2;
        }
        // pre.next = null;
        return ans;
    }
}