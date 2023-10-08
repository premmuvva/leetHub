class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int dp[][] = new int[nums1.length + 2][nums2.length + 2];
        int ans = Integer.MIN_VALUE;
        // System.out.printf("     ");
        // for(int i = 0; i < nums2.length-1; i++) 
        //     System.out.printf("%d  ", nums2[i]);
        // System.out.println("");
        for(int i = 1; i <= nums1.length; i++) {
            for(int j = 1; j <= nums2.length; j++) {
                int temp = nums1[i-1] * nums2[j-1];
                dp[i][j] = Math.max(temp, Math.max(i-1 == 0 ? Integer.MIN_VALUE:dp[i-1][j], Math.max(temp + dp[i-1][j-1], j-1 == 0 ? Integer.MIN_VALUE: dp[i][j-1])));
                ans = Math.max(ans, dp[i][j]);
            }
        }
        
        // for(int i = 1; i <= nums1.length; i++) {
        //     System.out.printf("%d  | ", nums1[i-1]);
        //     for(int j = 1; j <= nums2.length; j++) {
        //         System.out.printf("%d ", dp[i][j]);
        //     }
        //     System.out.println("");
        // }
        // System.out.println("");
        // System.out.println("");
        // System.out.println("");
        return ans;
    }
}