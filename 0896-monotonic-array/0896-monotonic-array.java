class Solution {
    public boolean isMonotonic(int[] nums) {
        if (nums.length <= 2) return true;
        boolean temp = false, flag = false;
        System.out.println(true^false);
        for(int i = 1; i<nums.length; i++) {
            if(nums[i-1] == nums[i]) continue;
            if (!flag) {
                flag = true;
                temp = nums[i-1] > nums[i];
            }
            if(flag && temp ^ (nums[i-1] > nums[i])) return false;
        }
        return true;
    }
}