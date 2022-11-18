class Solution {
    public int removeDuplicates(int[] nums) {
        int po = 1, i = 1, n = nums.length;
        for (; i < n; i++) 
            if (nums[i] != nums[i-1]) 
                nums[po++] = nums[i];
        return po;
    }
}