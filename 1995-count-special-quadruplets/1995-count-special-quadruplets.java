class Solution {
    public int countQuadruplets(int[] nums) {
        int ans = 0, len = nums.length;
        for (int i = 0; i< len - 3; i++) {
            for (int j = i+1; j< len - 2;j ++){
                for (int k = j+1; k < len - 1; k++) {
                    for (int l = k + 1; l < len; l++) {
                        if (nums[i] + nums[j] + nums[k] == nums[l]) ans++;
                    }
                }
            }
        }
        return ans;
    }
}