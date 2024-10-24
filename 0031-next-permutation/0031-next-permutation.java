class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        for (int i = n-2; i>=0; i--) {
            for (int j = n-1; j>i; j--) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    Arrays.sort(nums, i+1, n);
                    return;
                }
            }
        }
        Arrays.sort(nums);
    }
}