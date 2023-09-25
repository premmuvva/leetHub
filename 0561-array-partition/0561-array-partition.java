class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, ans = 0;
        
        for(int i = 0; i<n; i+=2) {
            ans += nums[i];
        }
        return ans;
    }
}