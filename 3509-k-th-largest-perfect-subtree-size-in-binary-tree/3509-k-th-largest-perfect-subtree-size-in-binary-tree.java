/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Node {
        public boolean istr;
        public int val;

        public Node(boolean a, int b) {
            istr = a;
            val = b;
        }
    }
    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        ArrayList<Integer> arr = new ArrayList();
        isPerfect(root, arr);
        Collections.sort(arr, Collections.reverseOrder());
        // System.out.println(arr);
        return k-1 >= arr.size() ? -1 : arr.get(k-1);
    }

    private Node isPerfect(TreeNode root, List<Integer> arr) {
        // if (root.left == null ^ root.right == null)
        //     return new Node(false, 1);
        if (root == null) return new Node(true, 0);
        if (root.left == null && root.right == null) {
            arr.add(1);
            return new Node(true, 1);
        }
        // if (root.left.left == null ^ root.right.left == null)
        //     return new Node(false, 1);
        Node left = isPerfect(root.left, arr);
        Node right = isPerfect(root.right, arr);
        if (!left.istr || !right.istr || left.val != right.val){
            return new Node(false, 2 * left.val + 1);
        }
        arr.add(2 * left.val + 1);
        return new Node(true, 2 * left.val + 1);
    }
}