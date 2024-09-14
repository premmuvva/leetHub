class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length, twentybits = (1<<21) - 1, temp = nums[0], maxand = 0, ans = 1, len = 0, br;
        for (int i = 0; i< n; i++) {
            br = (temp & nums[i]);
            if (br == nums[i] && br == temp) {
                temp &= nums[i];
                len++;
            } else {
                len = 1;
                temp = nums[i];
            }
            
            if (temp > maxand) {
                maxand = temp;
                ans = 0;
            }
            if (temp == maxand && ans < len) ans = len;
            // System.out.printf("%d %d %d %d %d\n", temp, maxand, nums[i], len, ans);
        }
        return ans;
    }
}