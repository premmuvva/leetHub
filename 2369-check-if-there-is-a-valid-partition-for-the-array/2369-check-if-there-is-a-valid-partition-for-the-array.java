class Solution {
    Map<Integer, Boolean> dp = new HashMap();
    public boolean validPartition(int[] nums) {
        return check(nums, nums.length - 1);
    }
    
    private boolean check(int[] nums, int start) {
        if (start < 0) return true;
        if (dp.containsKey(start)) return dp.get(start);
        boolean ans = false;
        if (start > 0 && nums[start] == nums[start - 1]) {
            ans = ans || check(nums, start - 2); 
        } 
        if (start > 1 && nums[start] == nums[start - 1] && nums[start - 1] == nums[start - 2]) {
            ans = ans || check(nums, start - 3);
        } 
        if (start > 1 && nums[start] - 1 == nums[start - 1] && nums[start - 1] - 1 == nums[start - 2]) {
            ans = ans || check(nums, start - 3);
        } 
        dp.put(start, ans);
        return ans;
    }
    
}