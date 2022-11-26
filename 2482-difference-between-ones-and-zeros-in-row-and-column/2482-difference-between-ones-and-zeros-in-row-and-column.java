class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int ar[][] = new int[2][grid.length], co[][] = new int[2][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    ar[0][i] ++;
                    co[0][j] ++;
                } else {
                    ar[1][i] ++;
                    co[1][j] ++;
                }
            }
        }
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = ar[1][i] + co[1][j] - ar[0][i] - co[0][j];
            }
        }
        return grid;
    }
}