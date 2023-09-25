class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length/2, ans = 0;
        
        for(int i = 0; i<n; i++) {
            ans += nums[2 * i];
        }
        return ans;
    }
}