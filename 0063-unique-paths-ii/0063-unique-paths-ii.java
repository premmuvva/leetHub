class Solution {
    int dp[][] = new int[101][101];
    boolean dpb[][] = new boolean[101][101];
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        for (int[] dpp : dp)
            Arrays.fill(dpp, -1);
        if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) return 0;
        return count(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1);
    }
    
    private int count(int[][] arr, int i, int j) {
        if (i == 0 && j == 0) return 1;
        if (dpb[i][j]) return dp[i][j];
        int ans = 0;
        if (i > 0 && arr[i-1][j] != 1) ans += count(arr, i - 1, j);
        if (j > 0  && arr[i][j-1] != 1) ans += count(arr, i, j - 1);
        dpb[i][j] = true;
        dp[i][j] = ans;
        return ans;
    }
}