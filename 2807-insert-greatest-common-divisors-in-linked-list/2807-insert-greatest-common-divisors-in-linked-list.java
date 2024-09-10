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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode cur = head, temp;
        while(cur.next != null) {
            temp = new ListNode(gcdd(cur.val, cur.next.val));
            // System.out.println(temp.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;
        }
        return head;
    }
    
    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }
    
    int gcdd(int a, int b) {
        while(a == 1 || b == 1) return 1;
        int temp;
        while(b != 0) {
            temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}