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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode cur = head, temp;
        int cou = 0;
        while(cur != null) {
            cou++;
            cur = cur.next;
        }
        int dif = cou % k, cs, es = cou/k;
        ListNode[] ans = new ListNode[k];
        cur = head;
        for (int i = 0; i<k; i++) {
            cs = es - 1;
            if (dif > 0) {
                cs++;
                dif--;
            }
            ans[i] = cur;
            while(cs > 0 && cur!= null) {
                cs--;
                cur = cur.next;
            }
            temp = cur;
            if (cur != null) {
                cur = cur.next;
                temp.next = null;
            }
        }
        return ans;
    }
}