class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int[] bits = new int[32];
        int j = 0, or = 0, temp, bc;
        int ans = Integer.MAX_VALUE, n = nums.length, tb;
        for (int i=0; i<n; i++) {
            or |= nums[i];
            temp = nums[i];
            bc = 0;
            while(bc < 32) {
                bits[bc] += ((temp >> bc) & 1);
                bc++;
            }
            while(or >= k && j <= i) {
                temp = nums[j];
                bc = 0;
                ans = Math.min(ans, i - j + 1);
                while(bc < 32) {
                    tb = ((temp >> bc) & 1);
                    bits[bc] -= tb;
                    if (tb == 1 && bits[bc] == 0) {
                        or = (or ^ (1 << bc));
                    }
                    bc++;
                }
                j++;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
