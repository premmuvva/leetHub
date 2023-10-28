class Solution {
    public int maximizeSum(int[] nums, int k) {
        int ans = 0;
        for(int i: nums)
            ans = Math.max(ans, i);
        return (ans * k) + ((k-1) * (k)) / 2;
    }
}