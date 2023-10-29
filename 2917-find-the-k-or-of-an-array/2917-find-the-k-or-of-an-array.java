class Solution {
    public int findKOr(int[] nums, int k) {
        int n = nums.length, ans = 0;
        for (int i = 0; i < 31; i++) {
            int num = 1 << i;
            int co = 0;
            for (int j = 0; j < n; j++) {
                if ((num&nums[j]) != 0) co++;
            }
            if (co >= k) ans |= num;
        }
        return ans;
    }
}