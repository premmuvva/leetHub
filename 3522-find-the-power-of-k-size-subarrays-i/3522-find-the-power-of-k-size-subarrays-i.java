class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int i, n = nums.length, ci = 0;
        int dp[] = new int[n];
        dp[0] = ++ci;
        for (i = 0; i<n-1 ;i++) {
            if (nums[i] + 1 != nums[i+1]) {
                dp[i+1] = 0;
                ci = 0;
            } else {
                dp[i+1] = ++ci;
            }
            if (i >= k - 1) {
                if (dp[i] - dp[i - k + 1] == k - 1) {
                    nums[i - k + 1] = nums[i];
                } else {
                    nums[i - k + 1] = -1;
                }
            }
        }
        if (dp[i] - dp[i - k + 1] == k - 1) {
            nums[i - k + 1] = nums[i];
        } else {
            nums[i - k + 1] = -1;
        }
        return Arrays.copyOfRange(nums, 0, n-k+1);
    }
}