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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList();
        Map<Integer, List<Integer>> hm = new TreeMap();
        
        rec(root, hm);
        // System.out.println(hm);
        return new ArrayList(hm.values());
        
    }
    
    private void rec(TreeNode root, Map<Integer, List<Integer>> hm) {
        Queue<Pair<TreeNode, Integer>> qu = new LinkedList();
        qu.add(new Pair(root, 0));
        while(!qu.isEmpty()) {
            Pair<TreeNode, Integer> poll = qu.remove();
            TreeNode node = poll.getKey();
            int heigh = poll.getValue();
            if (node.left != null)
                qu.add(new Pair(node.left, heigh - 1));
            if (node.right != null)
                qu.add(new Pair(node.right, heigh + 1));
            hm.computeIfAbsent(heigh, k -> new ArrayList()).add(node.val);
        }
        // double mid = (min + max)/2;
        // hm.computeIfAbsent(min, k -> new ArrayList()).add(root.val);
        // rec(root.left, min - 1, hm);
        // rec(root.right, min + 1, hm);
        return;
    }
}