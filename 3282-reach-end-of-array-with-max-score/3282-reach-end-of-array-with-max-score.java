class Solution {
    public long findMaximumScore(List<Integer> nums) {
        int n = nums.size(), cur = 0;
        long ans = 0L;
        for (int i =1; i< n; i++) {
            if (nums.get(cur) < nums.get(i)) {
                ans += (i - cur) * (long) nums.get(cur);
                cur = i;
            }
        }
        ans += (n-1-cur) * (long)nums.get(cur);
        return ans;
    }
}