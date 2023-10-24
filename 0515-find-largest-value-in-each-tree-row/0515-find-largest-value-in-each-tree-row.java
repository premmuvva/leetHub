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
    public List<Integer> largestValues(TreeNode root) {
        
        if(root == null) return new ArrayList<Integer>();
        int max = root.val, cu = 0;
        Queue<TreeNode> pq  = new LinkedList();
        Queue<Integer> node = new LinkedList();
        List<Integer> ans = new ArrayList();
        pq.add(root);
        node.add(0);
        TreeNode temp = null;
        int temp1;
        while(pq.size() != 0) {
            temp = pq.poll();
            temp1 = node.poll();
            if(temp1 == cu) {
                max = Math.max(max, temp.val);
            } else {
                ans.add(max);
                max = temp.val; 
                cu = temp1;
            }
            if (temp.left != null){
                pq.add(temp.left);
                node.add(temp1+1);
            }
            
            if (temp.right != null){
                pq.add(temp.right);
                node.add(temp1+1);
            }
        }
        if(temp != null) {
            ans.add(max);
        }
        return ans;
        
        
    }
}