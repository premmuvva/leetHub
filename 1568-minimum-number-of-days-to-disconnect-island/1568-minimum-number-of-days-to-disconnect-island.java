class Solution {
    
    private void flood(int[][] grid, boolean [][] vis, int i, int j, int n, int m) {
        if (i >= n || j >= m || i < 0 || j < 0 || vis[i][j] || grid[i][j] == 0 ) {
            return;
        }
        // System.out.printf("%d %d %s\n", i, j, Arrays.toString(vis[i]));
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
                    // System.out.printf("%d %d %d\n", i, j, ans);
                    flood(grid, vis, i, j, n, m);
                }
                // for (int ii = 0; ii < n ;ii ++) System.out.println(Arrays.toString(grid[ii]));
                // System.out.println();
                // for (int ii = 0; ii < n ;ii ++) System.out.println(Arrays.toString(vis[ii]));
            }
        }
        
        // System.out.println(ans);
        return ans;
    }
    
    public int minDays(int[][] grid) {
        if (count(grid) != 1) {
            return 0;
        }
        // for (int ii = 0; ii < n ;ii ++) System.out.println(Arrays.toString(grid[ii]));        
        int i = 0, j = 0, n = grid.length, m = grid[0].length;
        
        for (i = 0; i < n; i++) {
            for (j = 0; j< m; j++) {
                if(grid[i][j] == 0) continue;
                grid[i][j] = 0;
                int ans = count(grid);
                // for (int ii = 0; ii < n ;ii ++) System.out.println(Arrays.toString(grid[ii]));
                // System.out.println(ans);
                if(ans != 1) return 1;
                grid[i][j] = 1;
            }
        }
        // System.out.printf("%d %d premf\n", i, j);
        return 2;
    }
}