class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length, m = grid[0].length, i, j, r1, r2, r3, c1, c2, c3, d1, d2, ans = 0, exor = (1 << 10) - 2;
        if (n < 3 || m < 3) return 0;
        for (i = 0; i < n - 2; i++) {
            for (j = 0; j < m - 2; j++) {
                int xor = 0;
                
                xor = xor | (1 << grid[i][j]);
                xor = xor | (1 << grid[i+1][j]);
                xor = xor | (1 << grid[i+2][j]);
                xor = xor | (1 << grid[i][j+1]);
                xor = xor | (1 << grid[i][j+2]);
                xor = xor | (1 << grid[i+1][j+1]);
                xor = xor | (1 << grid[i+1][j+2]);
                xor = xor | (1 << grid[i+2][j+1]);
                xor = xor | (1 << grid[i+2][j+2]);
                // System.out.println(xor);
                // System.out.println(exor);
                if (xor != exor) continue;
                r1 = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
                r2 = grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2];
                r3 = grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];
                c1 = grid[i][j] + grid[i + 1][j] + grid[i + 2][j];
                c2 = grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1];
                c3 = grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2];
                d1 = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2];
                d2 = grid[i][j+2] + grid[i + 1][j + 1] + grid[i + 2][j];
                if(r1 == r2 && r2 == r3 && r3 == c1 && c1 == c2 && c2 == c3 && c3 == d1 && d1 == d2) ans ++;
            }
        }
        return ans;
    }
}