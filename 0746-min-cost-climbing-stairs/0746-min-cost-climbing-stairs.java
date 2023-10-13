class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length, a = cost[n-1], b = cost[n-2];
        for(int i = n - 3; i >= 0; i--) {
            n = Math.min(a, b) + cost[i];
            a = b;
            b = n;
        }
        return Math.min(a, b);
    }
}