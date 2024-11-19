class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long cs = 0L, ans = 0L;
        Map<Integer, Integer> hs = new HashMap();
        for (int i = 0; i<k; i++) {
            hs.put(nums[i], hs.getOrDefault(nums[i], 0) + 1);
            cs += nums[i];
        }
        if (hs.size() == k)
            ans = cs;
        for (int i = k; i<n; i++) {
            hs.put(nums[i], hs.getOrDefault(nums[i], 0) + 1);
            hs.put(nums[i-k], hs.get(nums[i-k]) - 1);
            if (hs.get(nums[i-k]) == 0) {
                hs.remove(nums[i-k]);
            }
            cs = cs + nums[i] - nums[i-k];
            if (hs.size() == k)
                ans = Math.max(ans, cs);
        }
        return ans;
    }
}