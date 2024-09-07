class Solution {
    public void moveZeroes(int[] nums) {
        int zi = 0, n = nums.length;
        
        for (int i = 0; i<n; i++) {
            if (nums[i] != 0) {
                nums[zi++] = nums[i];
            }
        }
        while (zi < n) nums[zi++] = 0;
    }
}