
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
        // int pro = 1, mod = 12345;
        // for (int i = 0; i<m; i++) {
        //     for (int j = 0; j <n ;j++) {
        //         pro = (pro * grid[i][j]) % mod;
        //     }
        // }
        // int ans[][] = new int[m][n];
        // BigInteger bmod = new BigInteger(String.valueOf(mod)), bpro;
        // for (int i = 0; i<m; i++) {
        //     for (int j = 0; j <n ;j++) {
        //         int div = GCD(grid[i][j], mod);
        //         bpro = new BigInteger(String.valueOf(grid[i][j]/div));
        //         bmod = new BigInteger(String.valueOf(mod/div));
        //         ans[i][j] = (((bpro.modInverse(bmod)).intValue() % mod) * pro) % mod;
        //         System.out.printf("%d %d %d \n", bpro, bmod, ans[i][j]);
        //     }
        // }
        return ans;
    }
    
    private int GCD(int x, int y) 
    { 
        // Everything is divisible by 0 
        if (x == 0) 
            return y; 
        if (y == 0) 
            return x; 
        if (x == y) 
            return x; 
  
        if (x > y) 
            return GCD(x - y, y); 
        return GCD(x, y - x); 
    } 
}