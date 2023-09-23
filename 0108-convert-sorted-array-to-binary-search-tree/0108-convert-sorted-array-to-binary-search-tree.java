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
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }
    
    private TreeNode build(int[] arr, int start, int end) {
        if (start > end) return null;
        int n = start + (end - start)/2;
        TreeNode node = new TreeNode(arr[n]);
        node.left = build(arr, start, n - 1);
        node.right = build(arr, n + 1, end);
        return node;
    }
}