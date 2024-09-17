class Solution {
    public int numIslands(char[][] grid) {
        int i = 0, j = 0, m = grid.length, n = grid[0].length, ans = 0;
        for (; i<m; i++) {
            for (j = 0; j<n; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    rec(grid, i, j, m, n);
                }
            }
        }
        return ans;
    }
    
    void rec(char[][]grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') return;
        grid[i][j] = '0';
        rec(grid, i - 1, j, m, n);
        rec(grid, i, j - 1, m, n);
        rec(grid, i + 1, j, m, n);
        rec(grid, i, j + 1, m, n);
    }
}