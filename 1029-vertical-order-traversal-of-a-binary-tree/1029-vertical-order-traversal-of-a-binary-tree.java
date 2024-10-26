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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Integer>> hm = new TreeMap();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {
            if (a[1] == b[1]) {
                if (a[2] == b[2]) {
                    return a[0] - b[0];
                } else {
                    return a[2] - b[2];
                }
            } else {
                return a[1] - b[1];
            }
        });
        rec(pq, root, 0, 0);
        int i = pq.peek()[1];
        List<List<Integer>> ans = new ArrayList();
        while(!pq.isEmpty()) {
            int[] temp = pq.poll();
            if (ans.size() <= (temp[1] - i)) {
                ans.add(new ArrayList());
            }
            ans.get(temp[1] - i).add(temp[0]);
        }
        return ans;
    }
    void rec(PriorityQueue<int[]> pq, TreeNode root, int left, int hei) {
        if (root == null) return;
        pq.offer(new int[]{root.val, left, hei});
        rec(pq, root.left, left - 1, hei + 1);
        rec(pq, root.right, left + 1, hei + 1);
    }
}
