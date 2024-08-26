class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n], suf = new int[n];
        pre[0] = 1;
        suf[n-1] = 1;
        for (int i = 0; i<n-1; i++) {
            pre[i+1] = pre[i] * nums[i];
            suf[n-i-2] = suf[n-i-1] * nums[n-i-1];
        }
        // System.out.println(Arrays.toString(pre));
        // System.out.println(Arrays.toString(suf));
        for (int i = 0; i<n; i++) {
            nums[i] = pre[i] * suf[i];
        }
        return nums;
    }
}