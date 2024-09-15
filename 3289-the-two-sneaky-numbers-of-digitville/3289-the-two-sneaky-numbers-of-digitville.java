class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Arrays.sort(nums);

        int ans [] = new int[2];
        int c=0, n = nums.length;
        for (int i = 1; i< n; i++) {
            if (nums[i] == nums[i-1]) ans[c++] = nums[i];
        }
        return ans;
    }
}