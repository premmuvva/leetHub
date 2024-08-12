class Solution {
    
    private void flood(int[][] grid, boolean [][] vis, int i, int j, int n, int m) {
        if (i >= n || j >= m || i < 0 || j < 0 || vis[i][j] || grid[i][j] == 0 ) {
            return;
        }
        vis[i][j] = true;
        flood(grid, vis, i + 1, j, n, m);
        flood(grid, vis, i - 1, j, n, m);
        flood(grid, vis, i, j + 1, n, m);
        flood(grid, vis, i, j - 1, n, m);
    }
    
    private int count(int [][] grid) {
        int i = 0, j = 0, n = grid.length, m = grid[0].length, ans = 0;
        boolean [][] vis = new boolean[n][m];
        for (; i < n; i++) {
            for (j = 0; j< m; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    ans ++;
                    flood(grid, vis, i, j, n, m);
                }
            }
        }
        return ans;
    }
    
    public int minDays(int[][] grid) {
        if (count(grid) != 1) {
            return 0;
        }      
        int i = 0, j = 0, n = grid.length, m = grid[0].length;
        
        for (i = 0; i < n; i++) {
            for (j = 0; j< m; j++) {
                if(grid[i][j] == 0) continue;
                grid[i][j] = 0;
                int ans = count(grid);
                if(ans != 1) return 1;
                grid[i][j] = 1;
            }
        }
        return 2;
    }
}