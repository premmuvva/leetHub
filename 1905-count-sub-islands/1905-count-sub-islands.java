class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n = grid1[0].length, ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j<n; j++) {
                if (grid2[i][j] == 1 && rec(grid1, grid2, i, j, m, n)) {
                    ans++;
                    // for (int ii = 0; ii < m; ii++) System.out.println(Arrays.toString(grid2[ii]));
                    // System.out.printf("%d %d\n", i, j);
                }
            }
        }
        
        return ans;
    }
    
    boolean rec(int[][] ga, int[][] gb, int i, int j, int m, int n) {
        if (i >= m || i < 0 || j >= n || j<0 || gb[i][j] == 0) return true;
        gb[i][j] = 0;
        boolean ans;
        if (ga[i][j] == 0) {
            rec(ga, gb, i+1, j, m, n);
            rec(ga, gb, i-1, j, m, n);
            rec(ga, gb, i, j+1, m, n);
            rec(ga, gb, i, j-1, m, n);
            ans = false;
        } else {
            boolean t1 = rec(ga, gb, i+1, j, m, n), 
            t2 = rec(ga, gb, i-1, j, m, n),
            t3 = rec(ga, gb, i, j+1, m, n),
            t4 = rec(ga, gb, i, j-1, m, n);
            ans = t1 && t2 && t3 && t4;
        }
        // System.out.printf("%d %d %b \n", i, j, ans);
        return ans;
    }
}