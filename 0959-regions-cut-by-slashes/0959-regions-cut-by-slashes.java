class Solution {
    public int regionsBySlashes(String[] grid) {
        int i, j, ii, jj, ans = 0, n = grid.length;
        boolean[][] hm = new boolean[3*n][3*n];
        // System.out.println();
        for (i = 0; i<n; i++) {
            ii = 3 * i;
            for (j = 0; j<n; j++) {
                jj = 3 * j;
                if (grid[i].charAt(j) == '/') {
                    hm[ii + 2][jj] = true;
                    hm[ii + 1][jj + 1] = true;
                    hm[ii][jj + 2] = true;
                } else if (grid[i].charAt(j) == '\\') {
                    hm[ii][jj] = true;
                    hm[ii + 1][jj + 1] = true;
                    hm[ii + 2][jj + 2] = true;
                }
            }
        }
        ii = 3 * n;
        for (i = 0; i<ii; i++) {
            for (j = 0; j<ii; j++) {
                if(!hm[i][j]) {
                    ans ++;
                    floodFill(hm, i, j, ii);
                }
                
            }
        }
        return ans;
    }
    
    private void floodFill(boolean[][] hm, int i, int j, int n) {
        if(i<0 || i>=n || j <0 || j>=n || hm[i][j]) {
            return;
        }
        hm[i][j] = true;
        floodFill(hm, i+1, j, n);
        floodFill(hm, i-1, j, n);
        floodFill(hm, i, j-1, n);
        floodFill(hm, i, j+1, n);
    }
}