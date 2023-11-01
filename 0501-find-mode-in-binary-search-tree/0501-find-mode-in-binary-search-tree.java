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
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> hm = new HashMap();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> b[1]-a[1]);
        solve(root, hm);
        int max = 0;
        for(Map.Entry<Integer, Integer> values: hm.entrySet()) {
            pq.add(new int[]{values.getKey(), values.getValue()});
        }
        max = pq.peek()[1];
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while(pq.size()>0 && pq.peek()[1] == max) {
            ans.add(pq.poll()[0]);
        }
        Object[] as = ans.toArray();
        int[] fans = new int[ans.size()];
        Arrays.setAll(fans, i -> (int)as[i]);
        // as.toArray(fans);
        return fans;
    }
    
    private int solve(TreeNode root, Map<Integer, Integer> hm) {
        if(root == null) return 0;
        hm.merge(root.val, 1, Integer::sum);
        solve(root.left, hm);
        solve(root.right, hm);
        return 0;
    }
}