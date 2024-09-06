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
        ListNode cur = head;
        while(cur.next != null) {
            if (!hs.contains(cur.next.val)) {
                cur = cur.next;
            } else {
                cur.next = cur.next.next;
            }
        }
        return head;
            
    }
}