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
    int ans = 0, co = 0;
    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return ans;
    }
    
    private int[] solve(TreeNode root) {
        if(root == null) return new int[]{0,0};
        int[] lef = solve(root.left);
        int[] rig = solve(root.right);
        int su = lef[0] + root.val + rig[0];
        int to = (lef[1] + rig[1] + 1);
        if(root.val == su/to) ans++;
        return new int[]{su, to};
    }
}