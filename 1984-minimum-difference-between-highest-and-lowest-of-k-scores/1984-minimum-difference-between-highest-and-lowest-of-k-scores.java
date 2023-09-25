class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE, n = nums.length;
        k--;
        for (int i = k; i < n ; i++) {
            min = Math.min(nums[i] - nums[i-k], min);
        }
        return min;
    }
}