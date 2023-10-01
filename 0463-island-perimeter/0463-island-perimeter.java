class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0;
        for(int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++) {
                if(grid[i][j] == 1) {
                    ans += solve(grid, i, j, m, n);
                }
            }
        }
        return ans;
    }
    
    private int solve(int[][] grid, int i, int j, int m, int n) {
        int ans = 0;
        if (i == 0 || (i > 0 && grid[i-1][j] != 1)) ans++;
        if (i == m - 1 || (i < m - 1 && grid[i+1][j] != 1)) ans++;
        if (j == 0 || (j > 0 && grid[i][j-1] != 1)) ans++;
        if (j == n - 1 || (j < n -1 && grid[i][j+1] != 1)) ans++; 
        return ans;
    }
}