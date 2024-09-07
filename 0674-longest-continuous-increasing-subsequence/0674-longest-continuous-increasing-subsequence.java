class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int ans = 0, n = nums.length - 1, cs = 1;
        for (int i = 0; i< n; i++) {
            if (nums[i] < nums[i+1]) {
                cs++;
            } else {
                ans = Math.max(ans, cs);
                cs = 1;
            }
        }
        ans = Math.max(ans, cs);
        return ans;
    }
}