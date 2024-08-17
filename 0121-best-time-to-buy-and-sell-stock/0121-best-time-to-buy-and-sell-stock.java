class Solution {
    public int maxProfit(int[] prices) {
        int max = 0, i, n = prices.length, cs = prices[n-1];
        for (i = n -1; i >= 0; i--) {
            max = Math.max(max, cs - prices[i]);
            cs = Math.max(cs, prices[i]);
        }
        return max;
    }
}