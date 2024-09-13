class Solution {
    class Node {
        public Node left, right;
    }
    public int findMaximumXOR(int[] nums) {
        Node st = new Node(), temp = st;
        int ans = 0, n = nums.length;
        for (int i = 0; i<n; i++) {
            temp = st;
            insert(nums[i], temp);
            ans = Math.max(ans, maxx(nums[i], temp));
            // System.out.println(ans);
        }
        return ans;
    }
    
    int maxx(int n, Node root) {
        Node head = root;
        int msb = 30, ans = 0;
        while(msb >= 0) {
            if (((n >> msb) & 1) == 0) {
                if (head.right != null) {
                    head = head.right;
                    ans += (1 << msb);
                } else {
                    head = head.left;
                }
            } else {
                if (head.left != null) {
                    head = head.left;
                    ans += 1 << msb;
                } else {
                    head = head.right;
                }
            }
            msb--;
        }
        return ans;
    }
    
    void insert(int n, Node root) {
        int msb = 30;
        Node head = root;
        while(msb >= 0) {
            if (((n >> msb) & 1) != 0) {
                if (head.right == null) {
                    head.right = new Node();
                }
                head = head.right;
            } else {
                if (head.left == null) {
                    head.left = new Node();
                }
                head = head.left;
            }
            msb--;
        }
    }
}