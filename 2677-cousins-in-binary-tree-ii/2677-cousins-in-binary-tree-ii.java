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
    public TreeNode replaceValueInTree(TreeNode root) {
        
        if (root == null) return null;
        int arr[] = new int[100000];
        Queue<TreeNode> dp = new LinkedList();
        dp.add(root);
        int h = 0;
        while(!dp.isEmpty()) {
            int siz = dp.size();
            int sum = 0;
            while(siz-- > 0) {
                TreeNode poll = dp.remove();
                if(poll.left != null) dp.offer(poll.left);
                if(poll.right != null) dp.offer(poll.right);
                sum += poll.val;
            }
            arr[h++] = sum;
        }
        rec(root, arr, 0);
        root.val = 0;
        return root;
        // root.val = 0;
        // TreeNode 
        // while (root.left != 0 || root.right )
    }

    void rec(TreeNode root, int[] arr, int h) {
        if (root == null || (root.right == null && root.left == null)) return;
        int cur = 0;
        if (root.left != null) {
            cur += root.left.val; 
        }
        if (root.right != null) {
            cur += root.right.val;
        }
        if (root.left != null) {
            root.left.val = arr[h+1] - cur;
            rec(root.left, arr, h+1);
        }
        if (root.right != null) {
            root.right.val = arr[h+1] - cur;
            rec(root.right, arr, h+1);
        }
    }
}