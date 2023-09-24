class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double [][] dp = new double[query_row+ 2][query_row + 2];
        dp[0][0] = poured;
        double temp;
        for(int i = 0; i<= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                temp = (dp[i][j] - 1) /2;
                if(temp > 0) {
                    dp[i+1][j] += temp;
                    dp[i+1][j+1] += temp;
                }
            }
        }
        return Math.min(1.0, dp[query_row][query_glass]);
    }
}