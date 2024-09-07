class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length - 1, zc = 0, le = -1;
        for (int i = 0; i<n; i++) {
            if (nums[i] == 0) continue;
            if (nums[i] == nums[i+1]) {
                nums[zc++] = nums[i++] * 2;
                le = i;
                continue;
            }
            nums[zc++] = nums[i];
            
        }
        if (nums[n] != 0 && le != n) nums[zc++] = nums[n];
        n++;
        for (int i = zc; i<n; i++) nums[i] = 0;
        return nums;
    }
}