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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Map<Integer, Long> hm = new HashMap();
        rec(root, 0, hm);
        List<Long> li = hm.values().stream().sorted((a, b) -> Long.compare(b, a))
            .collect(Collectors.toList());
        // System.out.println(li);
        return hm.size() < k ? -1 : li.get(k-1);
    }

    void rec(TreeNode root, int h, Map<Integer, Long> hm) {
        if (root == null) return;
        hm.put(h, hm.getOrDefault(h, 0L) + root.val);
        rec(root.left, h+1, hm);
        rec(root.right, h+1, hm);
    }
}