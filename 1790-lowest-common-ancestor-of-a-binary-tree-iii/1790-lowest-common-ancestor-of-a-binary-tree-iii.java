/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> par = new HashSet();
        Node temp = p;
        while(temp.parent != null) {
            par.add(temp);
            temp = temp.parent;
        }
        temp = q;
        while(temp.parent != null && !par.contains(temp)) {
            temp = temp.parent;
        }
        return temp;
    }
}