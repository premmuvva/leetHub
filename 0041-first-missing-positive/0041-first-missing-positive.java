class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int temp = 0;
        for (int i = 0; i<n; i++) {
            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i]-1]) {
                temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
                i--;
            }
        }

        for (int i = 1; i<=n; i++)
            if (nums[i-1] != i) return i;

        return n + 1;
    }
}