class Solution {
    public boolean isMonotonic(int[] nums) {
        if (nums.length <= 2) return true;
        boolean temp = false, flag = false;
        int i = 1;
        while(i<nums.length && nums[i-1] == nums[i]) i++;
        if(i== nums.length) return true;
        temp = nums[i-1] > nums[i];
        // System.out.println(true^false);
        for(; i<nums.length; i++) {
            if(nums[i-1] == nums[i]) continue;
            if(temp ^ (nums[i-1] > nums[i])) return false;
        }
        return true;
    }
}