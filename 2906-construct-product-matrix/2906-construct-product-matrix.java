
import java.math.BigInteger;

class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans[][] = new int[m][n], mod = 12345;
        long temp = 1L;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = (int) temp % mod;
                temp = (temp * grid[i][j]) % mod;
            }
        }
        temp = 1L;
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                ans[i][j] = (int) (temp * ans[i][j]) % mod;
                temp = (temp * grid[i][j]) % mod;
            }
        }
        return ans;
    }
}