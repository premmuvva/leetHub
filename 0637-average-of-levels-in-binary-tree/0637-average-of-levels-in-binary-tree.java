
import java.util.ArrayList;
import java.util.Map;

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
    public List<Double> averageOfLevels(TreeNode root) {
        Map<Integer, Long[]> hm = new HashMap();
        rec(root, hm, 0);
        List<Double> ans = new ArrayList<>();
        Long[] temp;
        for (int i = 0; i<100000; i++) {
            if (hm.containsKey(i)) {
                temp = hm.get(i);
                ans.add((double)temp[0]/temp[1]);
            } else 
                break;
        }
        return ans;
    }
    void rec(TreeNode root, Map<Integer, Long[]> hm, int h) {
        if (root == null) return;
        Long[] val = hm.getOrDefault(h, new Long[]{0L, 0L});
        hm.put(h, new Long[]{val[0]+root.val, val[1]+1});
        rec(root.left, hm, h+1);
        rec(root.right, hm, h+1);
    }
}