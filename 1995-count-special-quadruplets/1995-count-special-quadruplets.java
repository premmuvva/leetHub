class Solution {
    public int countQuadruplets(int[] nums) {
        int n = nums.length, ans = 0;
        for(int i = 0; i<n; i++) {
            for (int j = i+1; j<n; j++) {
                for(int k = j+1; k<n; k++) {
                    for(int l = k+1; l<n; l++) {
                        if(nums[i] + nums[j] + nums[k] == nums[l]) ans++;
                    }
                }
            }
        }
        return ans;
    }
}