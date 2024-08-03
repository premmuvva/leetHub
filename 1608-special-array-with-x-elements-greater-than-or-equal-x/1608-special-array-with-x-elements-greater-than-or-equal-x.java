class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, temp;
        for (int i = 1; i < n; i++) {
            // System.out.printf("%d %d\n", i, nums[n-i]);
            // temp = n - i >= 1 ? nums[n - i - 1] : Integer.MIN_VALUE;
            if (i <= nums[n - i] && i > nums[n - i - 1]) {
                return i;
            }
        }
        return n <= nums[0] ? n : -1;
    }
}