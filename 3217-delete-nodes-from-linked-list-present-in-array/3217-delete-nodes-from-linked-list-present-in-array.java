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
    public ListNode modifiedList(int[] nums, ListNode head) {
        int n = nums.length;
        Set<Integer> hs = new HashSet();
        for (int i: nums) hs.add(i);
        while(head != null && hs.contains(head.val)) {
            head = head.next;
        }
        if (head == null) return null;
        ListNode cur = head.next, pre = head;
        while(cur != null) {
            if (!hs.contains(cur.val)) {
                pre = cur;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return head;
            
    }
}