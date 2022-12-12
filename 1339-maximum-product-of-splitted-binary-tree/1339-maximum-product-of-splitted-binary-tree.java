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
        long ans = (root.val * (sum - root.val)) ;
        if (root.left != null) ans = Math.max(ans, solve(sum, root.left));
        if (root.right != null) ans = Math.max(ans, solve(sum, root.right));
        return ans;
    }
    
    private long calcSum(TreeNode root) {
        if (root == null) return 0;
        root.val += (calcSum(root.left) + calcSum(root.right));
        return root.val;
    }
}