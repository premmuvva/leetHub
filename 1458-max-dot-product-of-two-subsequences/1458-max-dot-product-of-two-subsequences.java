class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int dp[][] = new int[nums1.length + 2][nums2.length + 2];
        int ans = Integer.MIN_VALUE;
        for(int i = 1; i <= nums1.length; i++) {
            for(int j = 1; j <= nums2.length; j++) {
                int temp = nums1[i-1] * nums2[j-1];
                dp[i][j] = Math.max(temp, Math.max(i-1 == 0 ? Integer.MIN_VALUE:dp[i-1][j], Math.max(temp + dp[i-1][j-1], j-1 == 0 ? Integer.MIN_VALUE: dp[i][j-1])));
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}