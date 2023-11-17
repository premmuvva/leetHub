class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, ans = Integer.MIN_VALUE;
        for(int i = n-1, j = 0; i>j; i--, j++) {
            ans = Math.max(ans, nums[i] + nums[j]);
        }
        return ans;
    }
}