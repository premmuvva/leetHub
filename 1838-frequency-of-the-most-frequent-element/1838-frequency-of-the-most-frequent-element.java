class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        if (n ==1) return 1;
        Arrays.sort(nums);
        int st = 0, en = 1, ans = 0;
        long te = 0L;
        while(en < n) {
            if (te > k) {
                te -= (nums[en-1] - nums[st]);
                st++;
                continue;
            }
            ans = Math.max(ans, en-st);
            te = (nums[en] - nums[en-1]) * ((long)en-st) + te;
            en++;
        }
        if (te <= k) ans = Math.max(ans, en-st);
        return ans;
    }
}