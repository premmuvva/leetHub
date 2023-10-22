class Solution {
    public int minimumSum(int[] nums) {
        
        int n = nums.length, min = nums[0], ans = Integer.MAX_VALUE;
        int[] max = new int[n];
        max[n-1] = nums[n-1];
        for (int i= n-2; i>0; i--) 
            max[i] = Math.min(max[i+1], nums[i]);
        
        for(int i = 1; i<n-1; i++) {
            if(min < nums[i] && max[i+1] < nums[i]) {
                ans = Math.min(ans, min + nums[i] + max[i+1]);
            }
            min = Math.min(min, nums[i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}