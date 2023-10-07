class Solution {
    public boolean isMonotonic(int[] nums) {
        if (nums.length <= 2) return true;
        boolean temp = false, flag = false;
        int i = 1, n = nums.length;
        while(i<n && nums[i-1] == nums[i]) i++;
        if(i== n) return true;
        temp = nums[i-1] > nums[i];
        for(; i<n; i++) {
            if(nums[i-1] == nums[i]) continue;
            if(temp ^ (nums[i-1] > nums[i])) return false;
        }
        return true;
    }
}