class Solution {
    public int minMaxGame(int[] nums) {
        calc(nums, nums.length);
        return nums[0];
    }
    
    private int calc(int[] nums, int end) {
        if(end <= 1) return 0;
        end = end / 2;
        for(int i = 0; i < end; i++) {
            if ((i&1) == 0) nums[i] = Math.min(nums[2*i], nums[2*i+1]);
            else nums[i] = Math.max(nums[2*i], nums[2*i+1]);
        }
        return calc(nums, end);
    }
}