class Solution {

    public int largestCombination(int[] arr) {
        int [] dp = new int[33];
        for (int i : arr) {
            int co = 0;
            while(i > 0) {
                if (i%2 == 1) {
                    dp[co]++;
                }
                co++;
                i/=2;
            }
        }
        int ans = 0;
        for (int i : dp) {
            ans = Math.max(ans, i);
        }
        return ans;
    }
}