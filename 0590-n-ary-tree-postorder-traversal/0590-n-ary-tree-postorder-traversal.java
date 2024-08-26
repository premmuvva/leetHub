/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        if (root == null) {
            return new ArrayList();
        }
        List<Integer> ans = new ArrayList();
        for (Node ch: root.children) {
            ans.addAll(postorder(ch));
        }
        ans.add(root.val);
        return ans;
    }
}