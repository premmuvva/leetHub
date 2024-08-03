class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // if (n < 3 && nums[0] == 1) {
        //     if (n == 1) return 1;
        //     return nums[1] == 1? -1 : 1;
        // }
        int temp;
        for (int i = 1; i <= n; i++) {
            // System.out.printf("%d %d\n", i, nums[n-i]);
            temp = n - i >= 1 ? nums[n - i - 1] : Integer.MIN_VALUE;
            if (i <= nums[n - i] && i > temp) {
                return i;
            }
        }
        return -1;
    }
}