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
    
    Map<Node, Node> dp = new HashMap();
    
    public Node copyRandomList(Node head) {
        // if (head == null) return head;
        // Node cphead = new Node(head.val);
        // dp.put(head, cphead);
        
        // dp()
        return solve(head);
        
        // return cphead;
    }
    
    private Node solve(Node head) {
        if (head == null) return null;
        Node copy;
        if (dp.containsKey(head)) copy = dp.get(head);
        else dp.put(head, (copy = new Node(head.val)));
        if(head.random != null) {
            if(!dp.containsKey(head.random)) {
                Node temp = new Node(head.random.val);
                dp.put(head.random, temp);
            }
            copy.random = dp.get(head.random);
        }
        if(head.next != null) {
            if(!dp.containsKey(head.next)) {
                Node temp = new Node(head.next.val);
                dp.put(head.next, temp);
            }
            copy.next = dp.get(head.next);
        }
        solve(head.next);
        return copy;
    }
}