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
    long mod = 1000000007;
    public int maxProduct(TreeNode root) {
        long sum = calcSum(root) % mod;
        return (int) (solve(sum, root) % mod);
    }
    
    private long solve(long sum, TreeNode root) {
        if (root == null) return 0;
        long ans = Math.max(solve(sum, root.right), solve(sum, root.left));
        ans = Math.max(ans, (root.val * (sum - root.val)));
        return ans;
    }
    
    private int calcSum(TreeNode root) {
        if (root == null) return 0;
        root.val += (calcSum(root.left) + calcSum(root.right));
        return root.val;
    }
}